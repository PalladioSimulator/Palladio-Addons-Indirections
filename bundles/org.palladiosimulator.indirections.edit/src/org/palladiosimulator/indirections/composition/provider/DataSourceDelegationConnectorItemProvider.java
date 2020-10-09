package org.palladiosimulator.indirections.composition.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.palladiosimulator.indirections.composition.provider.impl.AssemblyContextValueChoiceCalculator;
import org.palladiosimulator.indirections.composition.provider.impl.InnerRoleValueChoiceCalculator;
import org.palladiosimulator.indirections.composition.provider.impl.OuterRoleValueChoiceCalculator;
import org.palladiosimulator.indirections.util.itempropertydescriptor.ItemPropertyDescriptorUtils;

public class DataSourceDelegationConnectorItemProvider extends DataSourceDelegationConnectorItemProviderGen {

    /**
     * {@inheritDoc}
     */
    public DataSourceDelegationConnectorItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addInnerDataSourceRolePropertyDescriptor(Object object) {
        super.addInnerDataSourceRolePropertyDescriptor(object);
        var decorator = ItemPropertyDescriptorUtils.decorateLastDescriptor(itemPropertyDescriptors);
        decorator.setValueChoiceCalculator(new InnerRoleValueChoiceCalculator());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addOuterDataSourceRolePropertyDescriptor(Object object) {
        super.addOuterDataSourceRolePropertyDescriptor(object);
        var decorator = ItemPropertyDescriptorUtils.decorateLastDescriptor(itemPropertyDescriptors);
        decorator.setValueChoiceCalculator(new OuterRoleValueChoiceCalculator());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addAssemblyContextPropertyDescriptor(Object object) {
        super.addAssemblyContextPropertyDescriptor(object);
        var decorator = ItemPropertyDescriptorUtils.decorateLastDescriptor(itemPropertyDescriptors);
        decorator.setValueChoiceCalculator(new AssemblyContextValueChoiceCalculator());
    }

}
