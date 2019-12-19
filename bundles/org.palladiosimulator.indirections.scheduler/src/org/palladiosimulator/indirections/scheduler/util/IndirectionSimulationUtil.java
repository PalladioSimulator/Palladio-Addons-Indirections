package org.palladiosimulator.indirections.scheduler.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.ConcreteIndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.GroupingIndirectionDate;
import org.palladiosimulator.indirections.util.IterableUtil;
import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.pcm.parameter.VariableCharacterisation;
import org.palladiosimulator.pcm.parameter.VariableUsage;
import org.palladiosimulator.pcm.repository.EventGroup;
import org.palladiosimulator.pcm.repository.Parameter;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.simulationevents.PeriodicallyTriggeredSimulationEntity;
import org.palladiosimulator.simulizar.utils.SimulatedStackHelper;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.variables.EvaluationProxy;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.ValueNotInFrameException;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStack;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.analyser.visitors.StoExPrettyPrintVisitor;

public final class IndirectionSimulationUtil {
    private final static Logger LOGGER = Logger.getLogger(IndirectionSimulationUtil.class);

    private IndirectionSimulationUtil() {
    }

    public static void validateStackframeStructure(final Map<String, Object> dataMap, final String parameterName) {
        final String parameterCharacterisationPrefix = parameterName + ".";

        for (final Entry<String, Object> entry : dataMap.entrySet()) {
            if (!entry.getKey().startsWith(parameterCharacterisationPrefix)) {
                throw new IllegalArgumentException("Invalid characteristation for data frame: " + entry.getKey()
                        + ", expected characteristations for " + parameterName);
            }
        }
    }

    /**
     * Same as
     * {@link SimulatedStackHelper#addParameterToStackFrame(SimulatedStackframe, EList, SimulatedStackframe)}
     * but defaults for the parameters.
     * 
     * Additionally, it can copy all characterizations for a type by specifying a reference name of:
     * input->output
     * 
     * @param parameterName
     */
    public static final void addParameterToStackFrameWithCopying(final SimulatedStackframe<Object> contextStackFrame,
            final EList<VariableUsage> parameter, final String parameterName,
            final SimulatedStackframe<Object> targetStackFrame) {

        for (final VariableUsage variableUsage : parameter) {
            if (variableUsage.getVariableCharacterisation_VariableUsage().isEmpty()) {
                final AbstractNamedReference namedReference = variableUsage.getNamedReference__VariableUsage();
                // TODO: move from convention quick hack to better solution
                final String[] split = namedReference.getReferenceName().split("->");
                if (split.length != 2) {
                    throw new PCMModelInterpreterException(
                            "If no variable chacterisations are present, name must be of form 'input->output'. Name is: "
                                    + namedReference.getReferenceName());
                }

                final String inputPrefix = split[0] + ".";
                final String outputPrefix = split[1] + ".";

                final List<Entry<String, Object>> inputs = contextStackFrame.getContents().stream()
                        .filter(it -> it.getKey().startsWith(inputPrefix)).collect(Collectors.toList());

                if (inputs.size() == 0) {
                    throw new PCMModelInterpreterException("Nothing found on stack frame for prefix '" + inputPrefix
                            + "'. Available: " + contextStackFrame.getContents().stream().map(it -> it.getKey())
                                    .collect(Collectors.joining(", ")));
                }

                inputs.forEach(it -> targetStackFrame
                        .addValue(outputPrefix + it.getKey().substring(inputPrefix.length()), it.getValue()));
                continue;
            }

            for (final VariableCharacterisation variableCharacterisation : variableUsage
                    .getVariableCharacterisation_VariableUsage()) {

                final PCMRandomVariable randomVariable = variableCharacterisation
                        .getSpecification_VariableCharacterisation();

                final AbstractNamedReference namedReference = variableCharacterisation
                        .getVariableUsage_VariableCharacterisation().getNamedReference__VariableUsage();

                final String id = new StoExPrettyPrintVisitor().doSwitch(namedReference).toString() + "."
                        + variableCharacterisation.getType().getLiteral();

                if (SimulatedStackHelper.isInnerReference(namedReference)) {
                    targetStackFrame.addValue(id,
                            new EvaluationProxy(randomVariable.getSpecification(), contextStackFrame.copyFrame()));
                } else {
                    targetStackFrame.addValue(id,
                            StackContext.evaluateStatic(randomVariable.getSpecification(), contextStackFrame));
                }

                if (LOGGER.isDebugEnabled()) {
                    try {
                        LOGGER.debug("Added value " + targetStackFrame.getValue(id) + " for id " + id
                                + " to stackframe " + targetStackFrame);
                    } catch (final ValueNotInFrameException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public static Parameter getOneParameter(final EventGroup eventGroup) {
        return IterableUtil.claimOne(eventGroup.getEventTypes__EventGroup()).getParameter__EventType();
    }

    /**
     * Changes the prefix in the given variable name from the parameter name of the incoming event
     * type to the one of the outgoing event type.
     */
    public static String rewriteVariableNamePrefix(final String variableName, final String incomingParameterName,
            final String outgoingParameterName) {
        if (variableName.startsWith(incomingParameterName)) {
            return outgoingParameterName + variableName.substring(incomingParameterName.length());
        } else {
            throw new AssertionError("Variable '" + variableName + "' does not start with incoming paramete name: "
                    + incomingParameterName);
        }
    }

    public static PeriodicallyTriggeredSimulationEntity triggerPeriodically(SimuComModel model, double firstOccurrence,
            double delay, Runnable taskToRun) {

        return new PeriodicallyTriggeredSimulationEntity(model, firstOccurrence, delay) {
            @Override
            protected void triggerInternal() {
                System.out.println(
                        "Triggering periodic process at " + model.getSimulationControl().getCurrentSimulationTime());
                taskToRun.run();
            }
        };
    }

    public static IndirectionDate claimDataFromStack(SimulatedStack<Object> stack, String id) {
        SimulatedStackframe<Object> currentStackFrame = stack.currentStackFrame();
        Object value;
        try {
            value = currentStackFrame.getValue(id);
        } catch (ValueNotInFrameException e) {
            throw new PCMModelInterpreterException("Expected id " + id + " on stack, but not found.", e);
        }
        if (!(value instanceof IndirectionDate)) {
            throw new PCMModelInterpreterException("Expected " + IndirectionDate.class.getName() + " for id " + id
                    + ", but got " + value.toString() + "(" + value.getClass().getName() + ")");
        }
        return (IndirectionDate) value;
    }

    // TODO: it is not very good to do exception handling checks here. This should be functionality
    // of the StackFrame, if it is really needed. Additionally, it is unclear, whether this should
    // just
    // shadow the variable.
    public static void createNewDataOnStack(SimulatedStack<Object> stack, String id, IndirectionDate date) {
        Object value = null;
        try {
            value = stack.currentStackFrame().getValue(id);
        } catch (ValueNotInFrameException e) {
        }

        if (value != null) {
            throw new PCMModelInterpreterException(
                    "Did expect " + id + " to not be present on stack, but found: " + value);
        }

        stack.currentStackFrame().addValue(id, date);
    }

    public static IndirectionDate createData(SimulatedStack<Object> contextStack,
            Iterable<VariableUsage> variableUsages, Double time) {
        SimulatedStackframe<Object> newStackFrame = new SimulatedStackframe<Object>();
        SimulatedStackHelper.addParameterToStackFrame(contextStack.currentStackFrame(),
                IterableUtil.toEList(variableUsages), newStackFrame);

        Map<String, Object> entries = IterableUtil.toMap(newStackFrame.getContents());
        IndirectionDate result = new ConcreteIndirectionDate(entries, time);

        return result;
    }

    public static void validateIndirectionDateStructure(IndirectionDate date, EventGroup eventGroup) {
        // TODO implement validation
        LOGGER.debug("Not validating indirection date structure");
    }

    public static List<Double> getDataAgeRecursive(IndirectionDate data) {
        return getDataAgeRecursive(data, new ArrayList<>());
    }

    public static List<Double> getDataAgeRecursive(IndirectionDate data, List<Double> measurements) {
        if (data instanceof GroupingIndirectionDate<?>) {
            for (IndirectionDate id : ((GroupingIndirectionDate<IndirectionDate>) data).getDataInGroup()) {
                getDataAgeRecursive(id, measurements);
            }
        } else {
            measurements.add(data.getTime());
        }
        return measurements;
    }
}
