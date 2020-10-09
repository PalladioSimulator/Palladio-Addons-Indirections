package org.palladiosimulator.indirections.composition.provider.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector;
import org.palladiosimulator.indirections.util.itempropertydescriptor.ValueChoiceCalculatorBase;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.RepositoryComponent;

public class SinkAssemblyContextValueChoiceCalculator
        extends ValueChoiceCalculatorBase<AssemblyContextSinkConnector, AssemblyContext> {

    public SinkAssemblyContextValueChoiceCalculator() {
        super(AssemblyContextSinkConnector.class, AssemblyContext.class);
    }

    @Override
    protected Collection<?> getValueChoiceTyped(AssemblyContextSinkConnector object, List<AssemblyContext> typedList) {
        if (object.getDataSinkRole() != null) {
            return typedList.stream()
                .filter(ac -> ac == null || Optional.of(ac.getEncapsulatedComponent__AssemblyContext())
                    .map(RepositoryComponent::getProvidedRoles_InterfaceProvidingEntity)
                    .map(c -> c.contains(object.getDataSinkRole()))
                    .orElse(false))
                .collect(Collectors.toList());
        }
        return typedList;
    }

}