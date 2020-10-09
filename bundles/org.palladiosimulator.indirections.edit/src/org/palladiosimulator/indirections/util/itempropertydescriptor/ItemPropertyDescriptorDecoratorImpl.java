package org.palladiosimulator.indirections.util.itempropertydescriptor;

import java.util.Collection;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

public class ItemPropertyDescriptorDecoratorImpl extends ItemPropertyDescriptorWrapper implements ItemPropertyDescriptorDecorator {

    private ValueChoiceCalculator valueChoiceCalculator;

    public ItemPropertyDescriptorDecoratorImpl(IItemPropertyDescriptor delegate) {
        super(delegate);
        this.valueChoiceCalculator = ((object, list) -> list);
    }

    @Override
    public void setValueChoiceCalculator(ValueChoiceCalculator transformator) {
        this.valueChoiceCalculator = transformator;
    }

    @Override
    public Collection<?> getChoiceOfValues(Object thisObject) {
        var superChoice = super.getChoiceOfValues(thisObject);
        return valueChoiceCalculator.getValueChoice(thisObject, superChoice);
    }
    
}
