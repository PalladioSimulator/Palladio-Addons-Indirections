/**
 */
package org.palladiosimulator.indirections.datatypes;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Windowing</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.datatypes.Windowing#getSize <em>Size</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.datatypes.Windowing#getShift <em>Shift</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.datatypes.Windowing#getGracePeriod <em>Grace Period</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.datatypes.DatatypesPackage#getWindowing()
 * @model
 * @generated
 */
public interface Windowing extends TimeGrouping {
	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(double)
	 * @see org.palladiosimulator.indirections.datatypes.DatatypesPackage#getWindowing_Size()
	 * @model
	 * @generated
	 */
	double getSize();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.indirections.datatypes.Windowing#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(double value);

	/**
	 * Returns the value of the '<em><b>Shift</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shift</em>' attribute.
	 * @see #setShift(double)
	 * @see org.palladiosimulator.indirections.datatypes.DatatypesPackage#getWindowing_Shift()
	 * @model
	 * @generated
	 */
	double getShift();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.indirections.datatypes.Windowing#getShift <em>Shift</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shift</em>' attribute.
	 * @see #getShift()
	 * @generated
	 */
	void setShift(double value);

	/**
	 * Returns the value of the '<em><b>Grace Period</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grace Period</em>' attribute.
	 * @see #setGracePeriod(double)
	 * @see org.palladiosimulator.indirections.datatypes.DatatypesPackage#getWindowing_GracePeriod()
	 * @model default="0"
	 * @generated
	 */
	double getGracePeriod();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.indirections.datatypes.Windowing#getGracePeriod <em>Grace Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grace Period</em>' attribute.
	 * @see #getGracePeriod()
	 * @generated
	 */
	void setGracePeriod(double value);

} // Windowing
