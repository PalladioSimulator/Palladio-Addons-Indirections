package org.palladiosimulator.indirections.composition.provider.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSourceConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.RepositoryComponent;

import tools.mdsd.library.emfeditutils.itempropertydescriptor.ValueChoiceCalculatorBase;

public class DataSourceRoleValueChoiceCalculator
        extends ValueChoiceCalculatorBase<DataSourceSinkConnector, DataSourceRole> {

    public DataSourceRoleValueChoiceCalculator() {
        super(DataSourceSinkConnector.class, DataSourceRole.class);
    }

    @Override
    protected Collection<?> getValueChoiceTyped(DataSourceSinkConnector object, List<DataSourceRole> typedList) {
        return Optional.of(object)
            .filter(AssemblyContextSourceConnector.class::isInstance)
            .map(AssemblyContextSourceConnector.class::cast)
            .map(AssemblyContextSourceConnector::getSourceAssemblyContext)
            .map(AssemblyContext::getEncapsulatedComponent__AssemblyContext)
            .map(RepositoryComponent::getRequiredRoles_InterfaceRequiringEntity)
            .map(c -> c.stream()
                .filter(DataSourceRole.class::isInstance)
                .map(DataSourceRole.class::cast)
                .filter(typedList::contains)
                .collect(Collectors.toList()))
            .orElseGet(() -> Arrays.asList((DataSourceRole) null));
    }

}
