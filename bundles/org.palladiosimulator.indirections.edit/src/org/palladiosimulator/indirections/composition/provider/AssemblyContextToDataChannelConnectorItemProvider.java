package org.palladiosimulator.indirections.composition.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.palladiosimulator.indirections.composition.provider.impl.DataSinkRoleValueChoiceCalculator;
import org.palladiosimulator.indirections.composition.provider.impl.DataSourceRoleValueChoiceCalculator;
import org.palladiosimulator.indirections.composition.provider.impl.SinkDataChannelValueChoiceCalculator;
import org.palladiosimulator.indirections.composition.provider.impl.SourceAssemblyContextValueChoiceCalculator;
import org.palladiosimulator.indirections.util.itempropertydescriptor.ItemPropertyDescriptorUtils;

public class AssemblyContextToDataChannelConnectorItemProvider
        extends AssemblyContextToDataChannelConnectorItemProviderGen {

    /**
     * {@inheritDoc}
     */
    public AssemblyContextToDataChannelConnectorItemProvider(AdapterFactory adapterFactory) {
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
    protected void addSourceAssemblyContextPropertyDescriptor(Object object) {
        super.addSourceAssemblyContextPropertyDescriptor(object);
        var decorator = ItemPropertyDescriptorUtils.decorateLastDescriptor(itemPropertyDescriptors);
        decorator.setValueChoiceCalculator(new SourceAssemblyContextValueChoiceCalculator());
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
