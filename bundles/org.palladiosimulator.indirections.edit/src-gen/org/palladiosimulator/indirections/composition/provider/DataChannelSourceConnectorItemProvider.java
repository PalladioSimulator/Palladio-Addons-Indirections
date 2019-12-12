/**
 */
package org.palladiosimulator.indirections.composition.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;
import org.palladiosimulator.pcm.core.composition.provider.ConnectorItemProvider;

/**
 * This is the item provider adapter for a
 * {@link org.palladiosimulator.indirections.composition.DataChannelSourceConnector} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class DataChannelSourceConnectorItemProvider extends ConnectorItemProvider {
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public DataChannelSourceConnectorItemProvider(final AdapterFactory adapterFactory) {
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

            this.addDataSourceRolePropertyDescriptor(object);
            this.addAssemblyContextPropertyDescriptor(object);
            this.addDataChannelPropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Data Source Role feature. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addDataSourceRolePropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_DataChannelSourceConnector_dataSourceRole_feature"),
                this.getString("_UI_PropertyDescriptor_description",
                        "_UI_DataChannelSourceConnector_dataSourceRole_feature", "_UI_DataChannelSourceConnector_type"),
                CompositionPackage.Literals.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_SOURCE_ROLE, true, false, true, null,
                null, null));
    }

    /**
     * This adds a property descriptor for the Assembly Context feature. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addAssemblyContextPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_DataChannelSourceConnector_assemblyContext_feature"),
                this.getString("_UI_PropertyDescriptor_description",
                        "_UI_DataChannelSourceConnector_assemblyContext_feature",
                        "_UI_DataChannelSourceConnector_type"),
                CompositionPackage.Literals.DATA_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT, true, false, true, null,
                null, null));
    }

    /**
     * This adds a property descriptor for the Data Channel feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected void addDataChannelPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_DataChannelSourceConnector_dataChannel_feature"),
                this.getString("_UI_PropertyDescriptor_description",
                        "_UI_DataChannelSourceConnector_dataChannel_feature", "_UI_DataChannelSourceConnector_type"),
                CompositionPackage.Literals.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_CHANNEL, true, false, true, null, null,
                null));
    }

    /**
     * This returns DataChannelSourceConnector.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage(final Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/DataChannelSourceConnector"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final String label = ((DataChannelSourceConnector) object).getEntityName();
        return label == null || label.length() == 0 ? this.getString("_UI_DataChannelSourceConnector_type")
                : this.getString("_UI_DataChannelSourceConnector_type") + " " + label;
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
