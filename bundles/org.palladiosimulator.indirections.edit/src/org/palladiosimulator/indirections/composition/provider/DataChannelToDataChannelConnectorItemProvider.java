package org.palladiosimulator.indirections.composition.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.palladiosimulator.indirections.composition.provider.impl.DataSinkRoleValueChoiceCalculator;
import org.palladiosimulator.indirections.composition.provider.impl.DataSourceRoleValueChoiceCalculator;
import org.palladiosimulator.indirections.composition.provider.impl.SinkDataChannelValueChoiceCalculator;
import org.palladiosimulator.indirections.composition.provider.impl.SourceDataChannelContextValueChoiceCalculator;
import org.palladiosimulator.indirections.util.itempropertydescriptor.ItemPropertyDescriptorUtils;

public class DataChannelToDataChannelConnectorItemProvider extends DataChannelToDataChannelConnectorItemProviderGen {

    /**
     * {@inheritDoc}
     */
    public DataChannelToDataChannelConnectorItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addSinkDataChannelPropertyDescriptor(Object object) {
        super.addSinkDataChannelPropertyDescriptor(object);
        var decorator = ItemPropertyDescriptorUtils.decorateLastDescriptor(itemPropertyDescriptors);
        decorator.setValueChoiceCalculator(new SinkDataChannelValueChoiceCalculator());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addSourceDataChannelPropertyDescriptor(Object object) {
        super.addSourceDataChannelPropertyDescriptor(object);
        var decorator = ItemPropertyDescriptorUtils.decorateLastDescriptor(itemPropertyDescriptors);
        decorator.setValueChoiceCalculator(new SourceDataChannelContextValueChoiceCalculator());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addDataSourceRolePropertyDescriptor(Object object) {
        super.addDataSourceRolePropertyDescriptor(object);
        var decorator = ItemPropertyDescriptorUtils.decorateLastDescriptor(itemPropertyDescriptors);
        decorator.setValueChoiceCalculator(new DataSourceRoleValueChoiceCalculator());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addDataSinkRolePropertyDescriptor(Object object) {
        super.addDataSinkRolePropertyDescriptor(object);
        var decorator = ItemPropertyDescriptorUtils.decorateLastDescriptor(itemPropertyDescriptors);
        decorator.setValueChoiceCalculator(new DataSinkRoleValueChoiceCalculator());
    }

}
