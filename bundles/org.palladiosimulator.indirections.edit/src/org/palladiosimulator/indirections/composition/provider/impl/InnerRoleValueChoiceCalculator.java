package org.palladiosimulator.indirections.composition.provider.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.palladiosimulator.indirections.composition.abstract_.DataDelegationConnector;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.ComposedStructure;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import org.palladiosimulator.pcm.repository.Role;

import tools.mdsd.library.emfeditutils.itempropertydescriptor.ValueChoiceCalculatorBase;

public class InnerRoleValueChoiceCalculator extends ValueChoiceCalculatorBase<DataDelegationConnector, Role> {

    public InnerRoleValueChoiceCalculator() {
        super(DataDelegationConnector.class, Role.class);
    }

    @Override
    protected Collection<?> getValueChoiceTyped(DataDelegationConnector object, List<Role> typedList) {
        List<AssemblyContext> assemblyContexts = Optional.ofNullable(object.getAssemblyContext())
            .map(Arrays::asList)
            .orElseGet(() -> Optional.ofNullable(object.getParentStructure__Connector())
                .map(ComposedStructure::getAssemblyContexts__ComposedStructure)
                .map(l -> (List<AssemblyContext>) l)
                .orElseGet(() -> Collections.<AssemblyContext> emptyList()));
        var components = assemblyContexts.stream()
            .map(AssemblyContext::getEncapsulatedComponent__AssemblyContext)
            .collect(Collectors.toList());

        var providedRoles = components.stream()
            .map(RepositoryComponent::getProvidedRoles_InterfaceProvidingEntity)
            .flatMap(Collection::stream);
        var requiredRoles = components.stream()
            .map(RepositoryComponent::getRequiredRoles_InterfaceRequiringEntity)
            .flatMap(Collection::stream);
        var roles = Stream.concat(providedRoles, requiredRoles)
            .collect(Collectors.toList());

        return typedList.stream()
            .filter(r -> r == null || roles.contains(r))
            .collect(Collectors.toList());
    }

}
