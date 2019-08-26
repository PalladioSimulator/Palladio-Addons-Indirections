/**
 */
package org.palladiosimulator.simulizar.indirection.composition.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

import org.palladiosimulator.pcm.core.composition.provider.ConnectorItemProvider;

import org.palladiosimulator.simulizar.indirection.composition.CompositionPackage;
import org.palladiosimulator.simulizar.indirection.composition.DataChannelSourceConnector;

/**
 * This is the item provider adapter for a {@link org.palladiosimulator.simulizar.indirection.composition.DataChannelSourceConnector} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DataChannelSourceConnectorItemProvider extends ConnectorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataChannelSourceConnectorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addSourceRolePropertyDescriptor(object);
			addAssemblyContextPropertyDescriptor(object);
			addDataChannelPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Source Role feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourceRolePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_DataChannelSourceConnector_sourceRole_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DataChannelSourceConnector_sourceRole_feature",
						"_UI_DataChannelSourceConnector_type"),
				CompositionPackage.Literals.DATA_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE, true, false, true, null, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Assembly Context feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAssemblyContextPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_DataChannelSourceConnector_assemblyContext_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_DataChannelSourceConnector_assemblyContext_feature",
								"_UI_DataChannelSourceConnector_type"),
						CompositionPackage.Literals.DATA_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT, true, false, true,
						null, null, null));
	}

	/**
	 * This adds a property descriptor for the Data Channel feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDataChannelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_DataChannelSourceConnector_dataChannel_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DataChannelSourceConnector_dataChannel_feature",
						"_UI_DataChannelSourceConnector_type"),
				CompositionPackage.Literals.DATA_CHANNEL_SOURCE_CONNECTOR__DATA_CHANNEL, true, false, true, null, null,
				null));
	}

	/**
	 * This returns DataChannelSourceConnector.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DataChannelSourceConnector"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((DataChannelSourceConnector) object).getId();
		return label == null || label.length() == 0 ? getString("_UI_DataChannelSourceConnector_type")
				: getString("_UI_DataChannelSourceConnector_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
