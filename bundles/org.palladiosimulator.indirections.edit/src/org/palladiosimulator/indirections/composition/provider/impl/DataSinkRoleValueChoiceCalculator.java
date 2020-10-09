package org.palladiosimulator.indirections.composition.provider.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector;
import org.palladiosimulator.indirections.repository.DataChannel;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.util.itempropertydescriptor.ValueChoiceCalculatorBase;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.RepositoryComponent;

public class DataSinkRoleValueChoiceCalculator
        extends ValueChoiceCalculatorBase<DataSourceSinkConnector, DataSinkRole> {

    public DataSinkRoleValueChoiceCalculator() {
        super(DataSourceSinkConnector.class, DataSinkRole.class);
    }

    @Override
    protected Collection<?> getValueChoiceTyped(DataSourceSinkConnector object, List<DataSinkRole> typedList) {
        var assemblyContextCandidates = Optional.of(object)
            .filter(AssemblyContextSinkConnector.class::isInstance)
            .map(AssemblyContextSinkConnector.class::cast)
            .map(AssemblyContextSinkConnector::getSinkAssemblyContext)
            .map(AssemblyContext::getEncapsulatedComponent__AssemblyContext)
            .map(RepositoryComponent::getProvidedRoles_InterfaceProvidingEntity)
            .map(c -> c.stream()
                .filter(DataSinkRole.class::isInstance)
                .map(DataSinkRole.class::cast))
            .orElseGet(() -> Arrays.asList((DataSinkRole) null)
                .stream());
        var dataChannelCandidates = Optional.of(object)
            .filter(DataChannelSinkConnector.class::isInstance)
            .map(DataChannelSinkConnector.class::cast)
            .map(DataChannelSinkConnector::getSinkDataChannel)
            .map(DataChannel::getDataSinkRoles)
            .map(Collection::stream)
            .orElseGet(() -> Arrays.asList((DataSinkRole) null)
                .stream());
        return Stream.concat(assemblyContextCandidates, dataChannelCandidates)
            .filter(typedList::contains)
            .collect(Collectors.toList());
    }

}
