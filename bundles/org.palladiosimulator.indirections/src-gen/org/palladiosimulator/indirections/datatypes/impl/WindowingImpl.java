/**
 */
package org.palladiosimulator.indirections.datatypes.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.palladiosimulator.indirections.datatypes.DatatypesPackage;
import org.palladiosimulator.indirections.datatypes.Windowing;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Windowing</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.datatypes.impl.WindowingImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.datatypes.impl.WindowingImpl#getShift <em>Shift</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.datatypes.impl.WindowingImpl#getGracePeriod <em>Grace Period</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WindowingImpl extends CDOObjectImpl implements Windowing {
	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final double SIZE_EDEFAULT = 0.0;

	/**
	 * The default value of the '{@link #getShift() <em>Shift</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShift()
	 * @generated
	 * @ordered
	 */
	protected static final double SHIFT_EDEFAULT = 0.0;

	/**
	 * The default value of the '{@link #getGracePeriod() <em>Grace Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGracePeriod()
	 * @generated
	 * @ordered
	 */
	protected static final double GRACE_PERIOD_EDEFAULT = 0.0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WindowingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatatypesPackage.Literals.WINDOWING;
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
	public double getSize() {
		return (Double) eDynamicGet(DatatypesPackage.WINDOWING__SIZE, DatatypesPackage.Literals.WINDOWING__SIZE, true,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSize(double newSize) {
		eDynamicSet(DatatypesPackage.WINDOWING__SIZE, DatatypesPackage.Literals.WINDOWING__SIZE, newSize);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getShift() {
		return (Double) eDynamicGet(DatatypesPackage.WINDOWING__SHIFT, DatatypesPackage.Literals.WINDOWING__SHIFT, true,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setShift(double newShift) {
		eDynamicSet(DatatypesPackage.WINDOWING__SHIFT, DatatypesPackage.Literals.WINDOWING__SHIFT, newShift);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getGracePeriod() {
		return (Double) eDynamicGet(DatatypesPackage.WINDOWING__GRACE_PERIOD,
				DatatypesPackage.Literals.WINDOWING__GRACE_PERIOD, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGracePeriod(double newGracePeriod) {
		eDynamicSet(DatatypesPackage.WINDOWING__GRACE_PERIOD, DatatypesPackage.Literals.WINDOWING__GRACE_PERIOD,
				newGracePeriod);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case DatatypesPackage.WINDOWING__SIZE:
			return getSize();
		case DatatypesPackage.WINDOWING__SHIFT:
			return getShift();
		case DatatypesPackage.WINDOWING__GRACE_PERIOD:
			return getGracePeriod();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case DatatypesPackage.WINDOWING__SIZE:
			setSize((Double) newValue);
			return;
		case DatatypesPackage.WINDOWING__SHIFT:
			setShift((Double) newValue);
			return;
		case DatatypesPackage.WINDOWING__GRACE_PERIOD:
			setGracePeriod((Double) newValue);
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
		case DatatypesPackage.WINDOWING__SIZE:
			setSize(SIZE_EDEFAULT);
			return;
		case DatatypesPackage.WINDOWING__SHIFT:
			setShift(SHIFT_EDEFAULT);
			return;
		case DatatypesPackage.WINDOWING__GRACE_PERIOD:
			setGracePeriod(GRACE_PERIOD_EDEFAULT);
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
		case DatatypesPackage.WINDOWING__SIZE:
			return getSize() != SIZE_EDEFAULT;
		case DatatypesPackage.WINDOWING__SHIFT:
			return getShift() != SHIFT_EDEFAULT;
		case DatatypesPackage.WINDOWING__GRACE_PERIOD:
			return getGracePeriod() != GRACE_PERIOD_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //WindowingImpl
