/**
 */
package org.palladiosimulator.indirections.actions.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.command.CommandParameter;

import org.eclipse.emf.edit.domain.EditingDomain;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ChildCreationExtenderManager;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.palladiosimulator.indirections.actions.ActionsFactory;
import org.palladiosimulator.indirections.actions.ActionsPackage;

import org.palladiosimulator.indirections.actions.util.ActionsAdapterFactory;

import org.palladiosimulator.pcm.seff.ResourceDemandingBehaviour;
import org.palladiosimulator.pcm.seff.SeffPackage;

import org.palladiosimulator.pcm.seff.seff_reliability.SeffReliabilityPackage;

import org.palladiosimulator.pcm.seff.seff_reliability.util.SeffReliabilitySwitch;

import org.palladiosimulator.pcm.seff.util.SeffSwitch;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ActionsItemProviderAdapterFactory extends ActionsAdapterFactory
		implements ComposeableAdapterFactory, IChangeNotifier, IDisposable, IChildCreationExtender {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This helps manage the child creation extenders.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChildCreationExtenderManager childCreationExtenderManager = new ChildCreationExtenderManager(
			IndirectionsEditPlugin.INSTANCE, ActionsPackage.eNS_URI);

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionsItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.palladiosimulator.indirections.actions.AnalyseStackAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnalyseStackActionItemProvider analyseStackActionItemProvider;

	/**
	 * This creates an adapter for a {@link org.palladiosimulator.indirections.actions.AnalyseStackAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAnalyseStackActionAdapter() {
		if (analyseStackActionItemProvider == null) {
			analyseStackActionItemProvider = new AnalyseStackActionItemProvider(this);
		}

		return analyseStackActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.palladiosimulator.indirections.actions.ConsumeDataAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConsumeDataActionItemProvider consumeDataActionItemProvider;

	/**
	 * This creates an adapter for a {@link org.palladiosimulator.indirections.actions.ConsumeDataAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConsumeDataActionAdapter() {
		if (consumeDataActionItemProvider == null) {
			consumeDataActionItemProvider = new ConsumeDataActionItemProvider(this);
		}

		return consumeDataActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.palladiosimulator.indirections.actions.EmitDataAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EmitDataActionItemProvider emitDataActionItemProvider;

	/**
	 * This creates an adapter for a {@link org.palladiosimulator.indirections.actions.EmitDataAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEmitDataActionAdapter() {
		if (emitDataActionItemProvider == null) {
			emitDataActionItemProvider = new EmitDataActionItemProvider(this);
		}

		return emitDataActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.palladiosimulator.indirections.actions.CreateDateAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateDateActionItemProvider createDateActionItemProvider;

	/**
	 * This creates an adapter for a {@link org.palladiosimulator.indirections.actions.CreateDateAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCreateDateActionAdapter() {
		if (createDateActionItemProvider == null) {
			createDateActionItemProvider = new CreateDateActionItemProvider(this);
		}

		return createDateActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.palladiosimulator.indirections.actions.AddToDateAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddToDateActionItemProvider addToDateActionItemProvider;

	/**
	 * This creates an adapter for a {@link org.palladiosimulator.indirections.actions.AddToDateAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAddToDateActionAdapter() {
		if (addToDateActionItemProvider == null) {
			addToDateActionItemProvider = new AddToDateActionItemProvider(this);
		}

		return addToDateActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.palladiosimulator.indirections.actions.DataIteratorAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataIteratorActionItemProvider dataIteratorActionItemProvider;

	/**
	 * This creates an adapter for a {@link org.palladiosimulator.indirections.actions.DataIteratorAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDataIteratorActionAdapter() {
		if (dataIteratorActionItemProvider == null) {
			dataIteratorActionItemProvider = new DataIteratorActionItemProvider(this);
		}

		return dataIteratorActionItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>) type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<IChildCreationExtender> getChildCreationExtenders() {
		return childCreationExtenderManager.getChildCreationExtenders();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
		return childCreationExtenderManager.getNewChildDescriptors(object, editingDomain);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return childCreationExtenderManager;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void dispose() {
		if (analyseStackActionItemProvider != null)
			analyseStackActionItemProvider.dispose();
		if (consumeDataActionItemProvider != null)
			consumeDataActionItemProvider.dispose();
		if (emitDataActionItemProvider != null)
			emitDataActionItemProvider.dispose();
		if (createDateActionItemProvider != null)
			createDateActionItemProvider.dispose();
		if (addToDateActionItemProvider != null)
			addToDateActionItemProvider.dispose();
		if (dataIteratorActionItemProvider != null)
			dataIteratorActionItemProvider.dispose();
	}

	/**
	 * A child creation extender for the {@link SeffPackage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class SeffChildCreationExtender implements IChildCreationExtender {
		/**
		 * The switch for creating child descriptors specific to each extended class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected static class CreationSwitch extends SeffSwitch<Object> {
			/**
			 * The child descriptors being populated.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected List<Object> newChildDescriptors;

			/**
			 * The domain in which to create the children.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected EditingDomain editingDomain;

			/**
			 * Creates the a switch for populating child descriptors in the given domain.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain) {
				this.newChildDescriptors = newChildDescriptors;
				this.editingDomain = editingDomain;
			}

			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			@Override
			public Object caseResourceDemandingBehaviour(ResourceDemandingBehaviour object) {
				newChildDescriptors
						.add(createChildParameter(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
								ActionsFactory.eINSTANCE.createAnalyseStackAction()));

				newChildDescriptors
						.add(createChildParameter(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
								ActionsFactory.eINSTANCE.createConsumeDataAction()));

				newChildDescriptors
						.add(createChildParameter(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
								ActionsFactory.eINSTANCE.createEmitDataAction()));

				newChildDescriptors
						.add(createChildParameter(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
								ActionsFactory.eINSTANCE.createCreateDateAction()));

				newChildDescriptors
						.add(createChildParameter(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
								ActionsFactory.eINSTANCE.createAddToDateAction()));

				newChildDescriptors
						.add(createChildParameter(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
								ActionsFactory.eINSTANCE.createDataIteratorAction()));

				return null;
			}

			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected CommandParameter createChildParameter(Object feature, Object child) {
				return new CommandParameter(null, feature, child);
			}

		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
			ArrayList<Object> result = new ArrayList<Object>();
			new CreationSwitch(result, editingDomain).doSwitch((EObject) object);
			return result;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public ResourceLocator getResourceLocator() {
			return IndirectionsEditPlugin.INSTANCE;
		}
	}

	/**
	 * A child creation extender for the {@link SeffReliabilityPackage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class SeffReliabilityChildCreationExtender implements IChildCreationExtender {
		/**
		 * The switch for creating child descriptors specific to each extended class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected static class CreationSwitch extends SeffReliabilitySwitch<Object> {
			/**
			 * The child descriptors being populated.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected List<Object> newChildDescriptors;

			/**
			 * The domain in which to create the children.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected EditingDomain editingDomain;

			/**
			 * Creates the a switch for populating child descriptors in the given domain.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain) {
				this.newChildDescriptors = newChildDescriptors;
				this.editingDomain = editingDomain;
			}

			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			@Override
			public Object caseResourceDemandingBehaviour(ResourceDemandingBehaviour object) {
				newChildDescriptors
						.add(createChildParameter(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
								ActionsFactory.eINSTANCE.createAnalyseStackAction()));

				newChildDescriptors
						.add(createChildParameter(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
								ActionsFactory.eINSTANCE.createConsumeDataAction()));

				newChildDescriptors
						.add(createChildParameter(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
								ActionsFactory.eINSTANCE.createEmitDataAction()));

				newChildDescriptors
						.add(createChildParameter(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
								ActionsFactory.eINSTANCE.createCreateDateAction()));

				newChildDescriptors
						.add(createChildParameter(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
								ActionsFactory.eINSTANCE.createAddToDateAction()));

				newChildDescriptors
						.add(createChildParameter(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
								ActionsFactory.eINSTANCE.createDataIteratorAction()));

				return null;
			}

			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected CommandParameter createChildParameter(Object feature, Object child) {
				return new CommandParameter(null, feature, child);
			}

		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
			ArrayList<Object> result = new ArrayList<Object>();
			new CreationSwitch(result, editingDomain).doSwitch((EObject) object);
			return result;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public ResourceLocator getResourceLocator() {
			return IndirectionsEditPlugin.INSTANCE;
		}
	}

}
