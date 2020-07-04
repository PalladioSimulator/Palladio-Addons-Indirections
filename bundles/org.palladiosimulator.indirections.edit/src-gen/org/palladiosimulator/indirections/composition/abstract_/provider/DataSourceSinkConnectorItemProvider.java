/**
 */
package org.palladiosimulator.indirections.composition.abstract_.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.palladiosimulator.indirections.actions.provider.IndirectionsEditPlugin;
import org.palladiosimulator.indirections.composition.abstract_.AbstractPackage;
import org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector;
import org.palladiosimulator.pcm.core.composition.provider.ConnectorItemProvider;

/**
 * This is the item provider adapter for a
 * {@link org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class DataSourceSinkConnectorItemProvider extends ConnectorItemProvider {
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public DataSourceSinkConnectorItemProvider(final AdapterFactory adapterFactory) {
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
            this.addDataSinkRolePropertyDescriptor(object);
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
                this.getString("_UI_DataSourceSinkConnector_dataSourceRole_feature"),
                this.getString("_UI_PropertyDescriptor_description",
                        "_UI_DataSourceSinkConnector_dataSourceRole_feature", "_UI_DataSourceSinkConnector_type"),
                AbstractPackage.Literals.DATA_SOURCE_SINK_CONNECTOR__DATA_SOURCE_ROLE, true, false, true, null, null,
                null));
    }

    /**
     * This adds a property descriptor for the Data Sink Role feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected void addDataSinkRolePropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_DataSourceSinkConnector_dataSinkRole_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_DataSourceSinkConnector_dataSinkRole_feature",
                        "_UI_DataSourceSinkConnector_type"),
                AbstractPackage.Literals.DATA_SOURCE_SINK_CONNECTOR__DATA_SINK_ROLE, true, false, true, null, null,
                null));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final String label = ((DataSourceSinkConnector) object).getId();
        return label == null || label.length() == 0 ? this.getString("_UI_DataSourceSinkConnector_type")
                : this.getString("_UI_DataSourceSinkConnector_type") + " " + label;
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

    /**
     * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return IndirectionsEditPlugin.INSTANCE;
    }

}
