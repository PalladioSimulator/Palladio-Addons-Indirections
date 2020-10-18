package org.palladiosimulator.indirections.util.itempropertydescriptor;

import java.util.Collection;

import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

public class ItemPropertyDescriptorWrapper implements IItemPropertyDescriptor {

    private final IItemPropertyDescriptor delegate;

    public ItemPropertyDescriptorWrapper(IItemPropertyDescriptor delegate) {
        this.delegate = delegate;
    }

    public boolean canSetProperty(Object arg0) {
        return delegate.canSetProperty(arg0);
    }

    public String getCategory(Object arg0) {
        return delegate.getCategory(arg0);
    }

    public Collection<?> getChoiceOfValues(Object arg0) {
        return delegate.getChoiceOfValues(arg0);
    }

    public String getDescription(Object arg0) {
        return delegate.getDescription(arg0);
    }

    public String getDisplayName(Object arg0) {
        return delegate.getDisplayName(arg0);
    }

    public Object getFeature(Object arg0) {
        return delegate.getFeature(arg0);
    }

    public String[] getFilterFlags(Object arg0) {
        return delegate.getFilterFlags(arg0);
    }

    public Object getHelpContextIds(Object arg0) {
        return delegate.getHelpContextIds(arg0);
    }

    public String getId(Object arg0) {
        return delegate.getId(arg0);
    }

    public IItemLabelProvider getLabelProvider(Object arg0) {
        return delegate.getLabelProvider(arg0);
    }

    public Object getPropertyValue(Object arg0) {
        return delegate.getPropertyValue(arg0);
    }

    public boolean isCompatibleWith(Object arg0, Object arg1, IItemPropertyDescriptor arg2) {
        return delegate.isCompatibleWith(arg0, arg1, arg2);
    }

    public boolean isMany(Object arg0) {
        return delegate.isMany(arg0);
    }

    public boolean isMultiLine(Object arg0) {
        return delegate.isMultiLine(arg0);
    }

    public boolean isPropertySet(Object arg0) {
        return delegate.isPropertySet(arg0);
    }

    public boolean isSortChoices(Object arg0) {
        return delegate.isSortChoices(arg0);
    }

    public void resetPropertyValue(Object arg0) {
        delegate.resetPropertyValue(arg0);
    }

    public void setPropertyValue(Object arg0, Object arg1) {
        delegate.setPropertyValue(arg0, arg1);
    }

}
