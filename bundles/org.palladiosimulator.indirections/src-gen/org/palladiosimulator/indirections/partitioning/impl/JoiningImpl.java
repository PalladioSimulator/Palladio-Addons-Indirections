/**
 */
package org.palladiosimulator.indirections.partitioning.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;

import org.palladiosimulator.indirections.partitioning.Joining;
import org.palladiosimulator.indirections.partitioning.PartitioningPackage;
import org.palladiosimulator.pcm.core.PCMRandomVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Joining</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.partitioning.impl.JoiningImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.partitioning.impl.JoiningImpl#isCanContributeMultipleTimes <em>Can Contribute Multiple Times</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.partitioning.impl.JoiningImpl#getKey <em>Key</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JoiningImpl extends CDOObjectImpl implements Joining {
	/**
	 * The default value of the '{@link #isCanContributeMultipleTimes() <em>Can Contribute Multiple Times</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanContributeMultipleTimes()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CAN_CONTRIBUTE_MULTIPLE_TIMES_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JoiningImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PartitioningPackage.Literals.JOINING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataChannelSourceConnector getSource() {
		return (DataChannelSourceConnector) eDynamicGet(PartitioningPackage.JOINING__SOURCE,
				PartitioningPackage.Literals.JOINING__SOURCE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataChannelSourceConnector basicGetSource() {
		return (DataChannelSourceConnector) eDynamicGet(PartitioningPackage.JOINING__SOURCE,
				PartitioningPackage.Literals.JOINING__SOURCE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(DataChannelSourceConnector newSource) {
		eDynamicSet(PartitioningPackage.JOINING__SOURCE, PartitioningPackage.Literals.JOINING__SOURCE, newSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isCanContributeMultipleTimes() {
		return (Boolean) eDynamicGet(PartitioningPackage.JOINING__CAN_CONTRIBUTE_MULTIPLE_TIMES,
				PartitioningPackage.Literals.JOINING__CAN_CONTRIBUTE_MULTIPLE_TIMES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCanContributeMultipleTimes(boolean newCanContributeMultipleTimes) {
		eDynamicSet(PartitioningPackage.JOINING__CAN_CONTRIBUTE_MULTIPLE_TIMES,
				PartitioningPackage.Literals.JOINING__CAN_CONTRIBUTE_MULTIPLE_TIMES, newCanContributeMultipleTimes);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<PCMRandomVariable> getKey() {
		return (EList<PCMRandomVariable>) eDynamicGet(PartitioningPackage.JOINING__KEY,
				PartitioningPackage.Literals.JOINING__KEY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case PartitioningPackage.JOINING__KEY:
			return ((InternalEList<?>) getKey()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case PartitioningPackage.JOINING__SOURCE:
			if (resolve)
				return getSource();
			return basicGetSource();
		case PartitioningPackage.JOINING__CAN_CONTRIBUTE_MULTIPLE_TIMES:
			return isCanContributeMultipleTimes();
		case PartitioningPackage.JOINING__KEY:
			return getKey();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case PartitioningPackage.JOINING__SOURCE:
			setSource((DataChannelSourceConnector) newValue);
			return;
		case PartitioningPackage.JOINING__CAN_CONTRIBUTE_MULTIPLE_TIMES:
			setCanContributeMultipleTimes((Boolean) newValue);
			return;
		case PartitioningPackage.JOINING__KEY:
			getKey().clear();
			getKey().addAll((Collection<? extends PCMRandomVariable>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case PartitioningPackage.JOINING__SOURCE:
			setSource((DataChannelSourceConnector) null);
			return;
		case PartitioningPackage.JOINING__CAN_CONTRIBUTE_MULTIPLE_TIMES:
			setCanContributeMultipleTimes(CAN_CONTRIBUTE_MULTIPLE_TIMES_EDEFAULT);
			return;
		case PartitioningPackage.JOINING__KEY:
			getKey().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case PartitioningPackage.JOINING__SOURCE:
			return basicGetSource() != null;
		case PartitioningPackage.JOINING__CAN_CONTRIBUTE_MULTIPLE_TIMES:
			return isCanContributeMultipleTimes() != CAN_CONTRIBUTE_MULTIPLE_TIMES_EDEFAULT;
		case PartitioningPackage.JOINING__KEY:
			return !getKey().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //JoiningImpl
