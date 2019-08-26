/**
 */
package org.palladiosimulator.simulizar.indirection.system.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.palladiosimulator.pcm.core.composition.provider.EventChannelItemProvider;

import org.palladiosimulator.simulizar.indirection.partitioning.PartitioningFactory;

import org.palladiosimulator.simulizar.indirection.system.DataChannel;
import org.palladiosimulator.simulizar.indirection.system.SystemPackage;

/**
 * This is the item provider adapter for a {@link org.palladiosimulator.simulizar.indirection.system.DataChannel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DataChannelItemProvider extends EventChannelItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataChannelItemProvider(AdapterFactory adapterFactory) {
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

			addCapacityPropertyDescriptor(object);
			addSourceEventGroupPropertyDescriptor(object);
			addSinkEventGroupPropertyDescriptor(object);
			addDataChannelSourceConnectorPropertyDescriptor(object);
			addDataChannelSinkConnectorPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Capacity feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCapacityPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_DataChannel_capacity_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_DataChannel_capacity_feature",
								"_UI_DataChannel_type"),
						SystemPackage.Literals.DATA_CHANNEL__CAPACITY, true, false, false,
						ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Source Event Group feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourceEventGroupPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_DataChannel_sourceEventGroup_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_DataChannel_sourceEventGroup_feature",
								"_UI_DataChannel_type"),
						SystemPackage.Literals.DATA_CHANNEL__SOURCE_EVENT_GROUP, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Sink Event Group feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSinkEventGroupPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_DataChannel_sinkEventGroup_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_DataChannel_sinkEventGroup_feature",
								"_UI_DataChannel_type"),
						SystemPackage.Literals.DATA_CHANNEL__SINK_EVENT_GROUP, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Data Channel Source Connector feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDataChannelSourceConnectorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_DataChannel_dataChannelSourceConnector_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DataChannel_dataChannelSourceConnector_feature",
						"_UI_DataChannel_type"),
				SystemPackage.Literals.DATA_CHANNEL__DATA_CHANNEL_SOURCE_CONNECTOR, true, false, true, null, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Data Channel Sink Connector feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDataChannelSinkConnectorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_DataChannel_dataChannelSinkConnector_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DataChannel_dataChannelSinkConnector_feature",
						"_UI_DataChannel_type"),
				SystemPackage.Literals.DATA_CHANNEL__DATA_CHANNEL_SINK_CONNECTOR, true, false, true, null, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(SystemPackage.Literals.DATA_CHANNEL__PARTITIONING);
			childrenFeatures.add(SystemPackage.Literals.DATA_CHANNEL__TIME_GROUPING);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns DataChannel.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DataChannel"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((DataChannel) object).getId();
		return label == null || label.length() == 0 ? getString("_UI_DataChannel_type")
				: getString("_UI_DataChannel_type") + " " + label;
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

		switch (notification.getFeatureID(DataChannel.class)) {
		case SystemPackage.DATA_CHANNEL__CAPACITY:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case SystemPackage.DATA_CHANNEL__PARTITIONING:
		case SystemPackage.DATA_CHANNEL__TIME_GROUPING:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add(createChildParameter(SystemPackage.Literals.DATA_CHANNEL__PARTITIONING,
				PartitioningFactory.eINSTANCE.createPartitioning()));

		newChildDescriptors.add(createChildParameter(SystemPackage.Literals.DATA_CHANNEL__TIME_GROUPING,
				PartitioningFactory.eINSTANCE.createWindowing()));

		newChildDescriptors.add(createChildParameter(SystemPackage.Literals.DATA_CHANNEL__TIME_GROUPING,
				PartitioningFactory.eINSTANCE.createConsumeAllAvailable()));

		newChildDescriptors.add(createChildParameter(SystemPackage.Literals.DATA_CHANNEL__TIME_GROUPING,
				PartitioningFactory.eINSTANCE.createCollectWithHoldback()));
	}

}
