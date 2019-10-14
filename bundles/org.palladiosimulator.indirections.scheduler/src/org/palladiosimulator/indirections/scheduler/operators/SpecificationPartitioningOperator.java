package org.palladiosimulator.indirections.scheduler.operators;

import java.util.List;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.simulizar.utils.SimulatedStackHelper;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;

public class SpecificationPartitioningOperator<T extends IndirectionDate> extends PartitioningOperator<Object, T> {
    private List<PCMRandomVariable> specification;

    public SpecificationPartitioningOperator(List<PCMRandomVariable> specification) {
        this.specification = specification;
    }

    @Override
    protected Object getPartition(IndirectionDate date) {
        final SimulatedStackframe<Object> stack = SimulatedStackHelper.createFromMap(date.getData());

        return specification.stream().collect(Collectors.toMap(it -> it.getSpecification(),
                it -> StackContext.evaluateStatic(it.getSpecification(), stack)));

    }

}