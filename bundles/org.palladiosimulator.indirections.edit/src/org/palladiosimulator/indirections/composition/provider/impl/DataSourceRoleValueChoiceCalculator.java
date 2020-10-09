package org.palladiosimulator.indirections.composition.provider.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSourceConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector;
import org.palladiosimulator.indirections.repository.DataChannel;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.util.itempropertydescriptor.ValueChoiceCalculatorBase;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.RepositoryComponent;

public class DataSourceRoleValueChoiceCalculator
        extends ValueChoiceCalculatorBase<DataSourceSinkConnector, DataSourceRole> {

    public DataSourceRoleValueChoiceCalculator() {
        super(DataSourceSinkConnector.class, DataSourceRole.class);
    }

    @Override
    protected Collection<?> getValueChoiceTyped(DataSourceSinkConnector object, List<DataSourceRole> typedList) {
        var assemblyContextCandidates = Optional.of(object)
            .filter(AssemblyContextSourceConnector.class::isInstance)
            .map(AssemblyContextSourceConnector.class::cast)
            .map(AssemblyContextSourceConnector::getSourceAssemblyContext)
            .map(AssemblyContext::getEncapsulatedComponent__AssemblyContext)
            .map(RepositoryComponent::getRequiredRoles_InterfaceRequiringEntity)
            .map(c -> c.stream()
                .filter(DataSourceRole.class::isInstance)
                .map(DataSourceRole.class::cast))
            .orElseGet(() -> Arrays.asList((DataSourceRole) null)
                .stream());
        var dataChannelCandidates = Optional.of(object)
            .filter(DataChannelSourceConnector.class::isInstance)
            .map(DataChannelSourceConnector.class::cast)
            .map(DataChannelSourceConnector::getSourceDataChannel)
            .map(DataChannel::getDataSourceRoles)
            .map(Collection::stream)
            .orElseGet(() -> Arrays.asList((DataSourceRole) null)
                .stream());
        return Stream.concat(assemblyContextCandidates, dataChannelCandidates)
            .filter(typedList::contains)
            .collect(Collectors.toList());
    }

}
