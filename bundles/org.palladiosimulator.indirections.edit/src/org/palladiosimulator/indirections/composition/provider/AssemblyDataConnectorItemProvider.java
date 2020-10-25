package org.palladiosimulator.indirections.composition.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.palladiosimulator.indirections.composition.provider.impl.DataSinkRoleValueChoiceCalculator;
import org.palladiosimulator.indirections.composition.provider.impl.DataSourceRoleValueChoiceCalculator;
import org.palladiosimulator.indirections.composition.provider.impl.SinkAssemblyContextValueChoiceCalculator;
import org.palladiosimulator.indirections.composition.provider.impl.SourceAssemblyContextValueChoiceCalculator;

import tools.mdsd.library.emfeditutils.itempropertydescriptor.ItemPropertyDescriptorUtils;

public class AssemblyDataConnectorItemProvider
        extends AssemblyDataConnectorItemProviderGen {

    /**
     * {@inheritDoc}
     */
    public AssemblyDataConnectorItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addSinkAssemblyContextPropertyDescriptor(Object object) {
        super.addSinkAssemblyContextPropertyDescriptor(object);
        var decorator = ItemPropertyDescriptorUtils.decorateLastDescriptor(itemPropertyDescriptors);
        decorator.setValueChoiceCalculator(new SinkAssemblyContextValueChoiceCalculator());
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
