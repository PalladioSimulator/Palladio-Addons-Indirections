package org.palladiosimulator.indirections.composition.provider.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.palladiosimulator.indirections.util.itempropertydescriptor.ValueChoiceCalculatorBase;
import org.palladiosimulator.pcm.core.composition.Connector;
import org.palladiosimulator.pcm.core.entity.ComposedProvidingRequiringEntity;
import org.palladiosimulator.pcm.repository.ProvidedRole;
import org.palladiosimulator.pcm.repository.RequiredRole;
import org.palladiosimulator.pcm.repository.Role;

public class OuterRoleValueChoiceCalculator extends ValueChoiceCalculatorBase<Connector, Role> {

    public OuterRoleValueChoiceCalculator() {
        super(Connector.class, Role.class);
    }

    @Override
    protected Collection<?> getValueChoiceTyped(Connector object, List<Role> typedList) {
        var parentStructure = Optional.of(object.getParentStructure__Connector())
            .filter(ComposedProvidingRequiringEntity.class::isInstance)
            .map(ComposedProvidingRequiringEntity.class::cast);

        var providedRoles = parentStructure
            .map(ComposedProvidingRequiringEntity::getProvidedRoles_InterfaceProvidingEntity)
            .map(Collection::stream)
            .orElseGet(() -> Arrays.asList((ProvidedRole) null)
                .stream());

        var requiredRoles = parentStructure
            .map(ComposedProvidingRequiringEntity::getRequiredRoles_InterfaceRequiringEntity)
            .map(Collection::stream)
            .orElseGet(() -> Arrays.asList((RequiredRole) null)
                .stream());

        var parentRoles = Stream.concat(providedRoles, requiredRoles)
            .collect(Collectors.toList());

        return typedList.stream()
            .filter(r -> r == null || parentRoles.contains(r))
            .collect(Collectors.toList());
    }

}
