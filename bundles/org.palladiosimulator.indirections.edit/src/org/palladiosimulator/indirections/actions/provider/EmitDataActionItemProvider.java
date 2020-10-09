package org.palladiosimulator.indirections.actions.provider;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.palladiosimulator.indirections.actions.EmitDataAction;
import org.palladiosimulator.indirections.actions.provider.impl.AbstractActionValueChoiceCalculator;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.util.itempropertydescriptor.ItemPropertyDescriptorUtils;
import org.palladiosimulator.indirections.util.itempropertydescriptor.ValueChoiceCalculatorBase;
import org.palladiosimulator.indirections.util.modelquery.ModelQueryUtils;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import org.palladiosimulator.pcm.repository.RequiredRole;

public class EmitDataActionItemProvider extends EmitDataActionItemProviderGen {

    /**
     * {@inheritDoc}
     */
    public EmitDataActionItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addDataSourceRolePropertyDescriptor(Object object) {
        super.addDataSourceRolePropertyDescriptor(object);
        var decorator = ItemPropertyDescriptorUtils.decorateLastDescriptor(itemPropertyDescriptors);
        decorator.setValueChoiceCalculator(new ValueChoiceCalculatorBase<>(EmitDataAction.class, DataSourceRole.class) {
            @Override
            protected Collection<?> getValueChoiceTyped(EmitDataAction object, List<DataSourceRole> typedList) {
                var component = ModelQueryUtils.findParentOfType(object, RepositoryComponent.class);
                var componentRequiredRoles = component
                    .map(RepositoryComponent::getRequiredRoles_InterfaceRequiringEntity)
                    .map(c -> (List<RequiredRole>) c)
                    .orElseGet(() -> Arrays.asList((RequiredRole) null));
                return typedList.stream()
                    .filter(r -> r == null || componentRequiredRoles.contains(r))
                    .collect(Collectors.toList());
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addPredecessor_AbstractActionPropertyDescriptor(Object object) {
        super.addPredecessor_AbstractActionPropertyDescriptor(object);
        var decorator = ItemPropertyDescriptorUtils.decorateLastDescriptor(itemPropertyDescriptors);
        decorator.setValueChoiceCalculator(new AbstractActionValueChoiceCalculator());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addSuccessor_AbstractActionPropertyDescriptor(Object object) {
        super.addSuccessor_AbstractActionPropertyDescriptor(object);
        var decorator = ItemPropertyDescriptorUtils.decorateLastDescriptor(itemPropertyDescriptors);
        decorator.setValueChoiceCalculator(new AbstractActionValueChoiceCalculator());
    }

}
