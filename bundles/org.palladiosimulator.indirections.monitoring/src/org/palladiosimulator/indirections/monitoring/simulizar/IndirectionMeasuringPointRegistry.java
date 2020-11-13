package org.palladiosimulator.indirections.monitoring.simulizar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.measure.quantity.Duration;

import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPointRepository;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointFactory;
import org.palladiosimulator.edp2.models.measuringpoint.StringMeasuringPoint;
import org.palladiosimulator.indirections.actions.AnalyseStackAction;
import org.palladiosimulator.indirections.monitoring.IndirectionsMetricDescriptionConstants;
import org.palladiosimulator.indirectionsmeasuringpoint.IndirectionsmeasuringpointFactory;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.probeframework.calculator.ICalculatorFactory;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.runtimestate.AbstractSimuLizarRuntimeState;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.probes.TakeCurrentSimulationTimeProbe;

public class IndirectionMeasuringPointRegistry {
    private static class AllocatedAction {
        public final AbstractAction action;
        public final AssemblyContext assemblyContext;

        public AllocatedAction(final AbstractAction action, final AssemblyContext assemblyContext) {
            this.action = action;
            this.assemblyContext = assemblyContext;
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (this.getClass() != obj.getClass()) {
                return false;
            }
            final AllocatedAction other = (AllocatedAction) obj;
            return Objects.equals(this.action, other.action)
                    && Objects.equals(this.assemblyContext, other.assemblyContext);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.action, this.assemblyContext);
        }

    }

    private static final IndirectionsmeasuringpointFactory INDIRECTIONS_MEASURINGPOINT_FACTORY = IndirectionsmeasuringpointFactory.eINSTANCE;

    private static final MeasuringpointFactory MEASURINGPOINT_FACTORY = MeasuringpointFactory.eINSTANCE;
    /** Default repository where measuring points are attached to. */
    public static final MeasuringPointRepository MEASURING_POINT_REPOSITORY = MEASURINGPOINT_FACTORY
        .createMeasuringPointRepository();

    /** Default EMF factory for measuring points. */
    private static Map<AbstractSimuLizarRuntimeState, IndirectionMeasuringPointRegistry> registries = new HashMap<>();

    // TODO: really static?
    public static IndirectionMeasuringPointRegistry getInstanceFor(final InterpreterDefaultContext context) {
        registries.computeIfAbsent(context.getRuntimeState(),
                (ctx) -> new IndirectionMeasuringPointRegistry(ctx.getModel()));

        return registries.get(context.getRuntimeState());
    }

    private final Map<AllocatedAction, TriggeredProxyProbe<Double, Duration>> actionToProbe = new HashMap<>();

    private final ICalculatorFactory factory;

    private final SimuComModel myModel;

    public final TakeCurrentSimulationTimeProbe timeProbe;

    private IndirectionMeasuringPointRegistry(final SimuComModel myModel) {
        this.myModel = myModel;
        this.factory = myModel.getProbeFrameworkContext()
            .getCalculatorFactory();
        this.timeProbe = new TakeCurrentSimulationTimeProbe(myModel.getSimulationControl());
    }

    private TriggeredProxyProbe<Double, Duration> createProbe(final AllocatedAction allocatedAction) {
        String measurementIdentficationkeyString = "";
        if (allocatedAction.action instanceof AnalyseStackAction) {
            measurementIdentficationkeyString = " (key = "
                    + ((AnalyseStackAction) allocatedAction.action).getMeasurementIdentificationKey() + ")";
        }
        final StringMeasuringPoint measuringPoint = MeasuringUtil.createStringMeasuringPoint(MEASURING_POINT_REPOSITORY,
                "Data age for " + allocatedAction.action.getEntityName() + " @ "
                        + allocatedAction.assemblyContext.getEntityName() + measurementIdentficationkeyString);

        final TriggeredProxyProbe<Double, Duration> dataAgeProxyProbe = new TriggeredProxyProbe<Double, Duration>(
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC);
        final TriggeredCombiningProbe<Double, Duration> dataAgeMetricSetProbeList = new TriggeredCombiningProbe<Double, Duration>(
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC_TUPLE,
                List.of(this.timeProbe, dataAgeProxyProbe), dataAgeProxyProbe);

        this.factory.buildExecutionResultCalculator(measuringPoint, dataAgeMetricSetProbeList);
        return dataAgeProxyProbe;
    }

    public TriggeredProxyProbe<Double, Duration> getProbe(final AnalyseStackAction action,
            final AssemblyContext assemblyContext) {
        return this.actionToProbe.computeIfAbsent(new AllocatedAction(action, assemblyContext), this::createProbe);
    }
}
