package org.palladiosimulator.indirections.actions.provider;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.palladiosimulator.indirections.actions.ConsumeDataAction;
import org.palladiosimulator.indirections.actions.provider.impl.AbstractActionValueChoiceCalculator;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.util.modelquery.ModelQueryUtils;
import org.palladiosimulator.pcm.repository.ProvidedRole;
import org.palladiosimulator.pcm.repository.RepositoryComponent;

import tools.mdsd.library.emfeditutils.itempropertydescriptor.ItemPropertyDescriptorUtils;
import tools.mdsd.library.emfeditutils.itempropertydescriptor.ValueChoiceCalculatorBase;

public class ConsumeDataActionItemProvider extends ConsumeDataActionItemProviderGen {

    /**
     * {@inheritDoc}
     */
    public ConsumeDataActionItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addDataSinkRolePropertyDescriptor(Object object) {
        super.addDataSinkRolePropertyDescriptor(object);
        var decorator = ItemPropertyDescriptorUtils.decorateLastDescriptor(itemPropertyDescriptors);
        decorator
            .setValueChoiceCalculator(new ValueChoiceCalculatorBase<>(ConsumeDataAction.class, DataSinkRole.class) {
                @Override
                protected Collection<?> getValueChoiceTyped(ConsumeDataAction object, List<DataSinkRole> typedList) {
                    var component = ModelQueryUtils.findParentOfType(object, RepositoryComponent.class);
                    var componentProvidedRoles = component
                        .map(RepositoryComponent::getProvidedRoles_InterfaceProvidingEntity)
                        .map(c -> (List<ProvidedRole>) c)
                        .orElseGet(() -> Arrays.asList((ProvidedRole) null));
                    return typedList.stream()
                        .filter(r -> r == null || componentProvidedRoles.contains(r))
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
