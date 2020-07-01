/**
 */
package org.palladiosimulator.indirections.composition.abstract_.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.palladiosimulator.indirections.composition.abstract_.AbstractPackage;
import org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector;

/**
 * This is the item provider adapter for a {@link org.palladiosimulator.indirections.composition.abstract_.AssemblyContextSinkConnector} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AssemblyContextSinkConnectorItemProvider extends DataSourceSinkConnectorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContextSinkConnectorItemProvider(AdapterFactory adapterFactory) {
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

			addSinkAssemblyContextPropertyDescriptor(object);
			addPushesToPropertyDescriptor(object);
			addPushingPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Sink Assembly Context feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSinkAssemblyContextPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_AssemblyContextSinkConnector_sinkAssemblyContext_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_AssemblyContextSinkConnector_sinkAssemblyContext_feature",
								"_UI_AssemblyContextSinkConnector_type"),
						AbstractPackage.Literals.ASSEMBLY_CONTEXT_SINK_CONNECTOR__SINK_ASSEMBLY_CONTEXT, true, false,
						true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Pushes To feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPushesToPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_AssemblyContextSinkConnector_pushesTo_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_AssemblyContextSinkConnector_pushesTo_feature",
						"_UI_AssemblyContextSinkConnector_type"),
				AbstractPackage.Literals.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHES_TO, true, false, true, null, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Pushing feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPushingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_AssemblyContextSinkConnector_pushing_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_AssemblyContextSinkConnector_pushing_feature",
						"_UI_AssemblyContextSinkConnector_type"),
				AbstractPackage.Literals.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHING, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((AssemblyContextSinkConnector) object).getId();
		return label == null || label.length() == 0 ? getString("_UI_AssemblyContextSinkConnector_type")
				: getString("_UI_AssemblyContextSinkConnector_type") + " " + label;
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

		switch (notification.getFeatureID(AssemblyContextSinkConnector.class)) {
		case AbstractPackage.ASSEMBLY_CONTEXT_SINK_CONNECTOR__PUSHING:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		}
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
