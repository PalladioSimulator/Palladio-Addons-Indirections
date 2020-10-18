package org.palladiosimulator.indirections.composition.provider.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.composition.abstract_.DataChannelSinkConnector;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.util.itempropertydescriptor.ValueChoiceCalculatorBase;

public class SinkDataChannelValueChoiceCalculator
        extends ValueChoiceCalculatorBase<DataChannelSinkConnector, DataChannel> {

    public SinkDataChannelValueChoiceCalculator() {
        super(DataChannelSinkConnector.class, DataChannel.class);
    }

    @Override
    protected Collection<?> getValueChoiceTyped(DataChannelSinkConnector object, List<DataChannel> typedList) {
        if (object.getDataSinkRole() != null) {
            return typedList.stream()
                .filter(dc -> dc == null || dc.getDataSinkRoles()
                    .contains(object.getDataSinkRole()))
                .collect(Collectors.toList());
        }
        return typedList;
    }

}
