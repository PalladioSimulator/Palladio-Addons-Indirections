/**
 */
package org.palladiosimulator.indirections.repository.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.RepositoryPackage;
import org.palladiosimulator.pcm.repository.provider.ProvidedRoleItemProvider;

/**
 * This is the item provider adapter for a
 * {@link org.palladiosimulator.indirections.repository.DataSinkRole} object. <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 *
 * @generated
 */
public class DataSinkRoleItemProvider extends ProvidedRoleItemProvider {
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public DataSinkRoleItemProvider(final AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(final Object object) {
        if (this.itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            this.addEventGroupPropertyDescriptor(object);
            this.addPushesToPropertyDescriptor(object);
            this.addPushingPropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Event Group feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected void addEventGroupPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_DataSinkRole_eventGroup_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_DataSinkRole_eventGroup_feature",
                        "_UI_DataSinkRole_type"),
                RepositoryPackage.Literals.DATA_SINK_ROLE__EVENT_GROUP, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Pushes To feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected void addPushesToPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_DataSinkRole_pushesTo_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_DataSinkRole_pushesTo_feature",
                        "_UI_DataSinkRole_type"),
                RepositoryPackage.Literals.DATA_SINK_ROLE__PUSHES_TO, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Pushing feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected void addPushingPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_DataSinkRole_pushing_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_DataSinkRole_pushing_feature",
                        "_UI_DataSinkRole_type"),
                RepositoryPackage.Literals.DATA_SINK_ROLE__PUSHING, false, false, false,
                ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
    }

    /**
     * This returns DataSinkRole.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage(final Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/DataSinkRole"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final String label = ((DataSinkRole) object).getEntityName();
        return label == null || label.length() == 0 ? this.getString("_UI_DataSinkRole_type")
                : this.getString("_UI_DataSinkRole_type") + " " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to
     * {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void notifyChanged(final Notification notification) {
        this.updateChildren(notification);

        switch (notification.getFeatureID(DataSinkRole.class)) {
        case RepositoryPackage.DATA_SINK_ROLE__PUSHING:
            this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that
     * can be created under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(final Collection<Object> newChildDescriptors, final Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);
    }

}
