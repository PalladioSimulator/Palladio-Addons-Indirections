package org.palladiosimulator.indirections.composition.provider.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.composition.abstract_.DataChannelSourceConnector;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.util.itempropertydescriptor.ValueChoiceCalculatorBase;

public class SourceDataChannelContextValueChoiceCalculator
        extends ValueChoiceCalculatorBase<DataChannelSourceConnector, DataChannel> {

    public SourceDataChannelContextValueChoiceCalculator() {
        super(DataChannelSourceConnector.class, DataChannel.class);
    }

    @Override
    protected Collection<?> getValueChoiceTyped(DataChannelSourceConnector object, List<DataChannel> typedList) {
        if (object.getDataSourceRole() != null) {
            return typedList.stream()
                .filter(dc -> dc == null || dc.getDataSourceRoles()
                    .contains(object.getDataSourceRole()))
                .collect(Collectors.toList());
        }
        return typedList;
    }

}
