package org.palladiosimulator.indirections.composition.provider.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSourceConnector;
import org.palladiosimulator.indirections.util.itempropertydescriptor.ValueChoiceCalculatorBase;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.RepositoryComponent;

public class SourceAssemblyContextValueChoiceCalculator
        extends ValueChoiceCalculatorBase<AssemblyContextSourceConnector, AssemblyContext> {

    public SourceAssemblyContextValueChoiceCalculator() {
        super(AssemblyContextSourceConnector.class, AssemblyContext.class);
    }

    @Override
    protected Collection<?> getValueChoiceTyped(AssemblyContextSourceConnector object,
            List<AssemblyContext> typedList) {
        if (object.getDataSourceRole() != null) {
            return typedList.stream()
                .filter(ac -> ac == null || Optional.of(ac.getEncapsulatedComponent__AssemblyContext())
                    .map(RepositoryComponent::getRequiredRoles_InterfaceRequiringEntity)
                    .map(c -> c.contains(object.getDataSourceRole()))
                    .orElse(false))
                .collect(Collectors.toList());
        }
        if (object.getParentStructure__Connector() != null) {
            var candidates = object.getParentStructure__Connector()
                .getAssemblyContexts__ComposedStructure();
            return typedList.stream()
                .filter(ac -> ac == null || candidates.contains(ac))
                .collect(Collectors.toList());
        }
        return typedList;
    }

}
