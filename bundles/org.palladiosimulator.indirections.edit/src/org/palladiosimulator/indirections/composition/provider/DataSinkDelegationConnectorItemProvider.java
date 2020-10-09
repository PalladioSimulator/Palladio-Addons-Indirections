package org.palladiosimulator.indirections.composition.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.palladiosimulator.indirections.composition.provider.impl.AssemblyContextValueChoiceCalculator;
import org.palladiosimulator.indirections.composition.provider.impl.InnerRoleValueChoiceCalculator;
import org.palladiosimulator.indirections.composition.provider.impl.OuterRoleValueChoiceCalculator;
import org.palladiosimulator.indirections.util.itempropertydescriptor.ItemPropertyDescriptorUtils;

public class DataSinkDelegationConnectorItemProvider extends DataSinkDelegationConnectorItemProviderGen {

    /**
     * {@inheritDoc}
     */
    public DataSinkDelegationConnectorItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addInnerDataSinkRolePropertyDescriptor(Object object) {
        super.addInnerDataSinkRolePropertyDescriptor(object);
        var decorator = ItemPropertyDescriptorUtils.decorateLastDescriptor(itemPropertyDescriptors);
        decorator.setValueChoiceCalculator(new InnerRoleValueChoiceCalculator());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addOuterDataSinkRolePropertyDescriptor(Object object) {
        super.addOuterDataSinkRolePropertyDescriptor(object);
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
