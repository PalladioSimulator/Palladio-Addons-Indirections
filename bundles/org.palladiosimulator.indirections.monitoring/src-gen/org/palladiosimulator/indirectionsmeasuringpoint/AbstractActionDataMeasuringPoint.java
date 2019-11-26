/**
 */
package org.palladiosimulator.indirectionsmeasuringpoint;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint;
import org.palladiosimulator.pcm.seff.AbstractAction;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Abstract Action Data
 * Measuring Point</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirectionsmeasuringpoint.AbstractActionDataMeasuringPoint#getAbstractAction
 * <em>Abstract Action</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirectionsmeasuringpoint.IndirectionsmeasuringpointPackage#getAbstractActionDataMeasuringPoint()
 * @model
 * @generated
 */
public interface AbstractActionDataMeasuringPoint extends EObject, MeasuringPoint {
    /**
     * Returns the value of the '<em><b>Abstract Action</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Abstract Action</em>' reference.
     * @see #setAbstractAction(AbstractAction)
     * @see org.palladiosimulator.indirectionsmeasuringpoint.IndirectionsmeasuringpointPackage#getAbstractActionDataMeasuringPoint_AbstractAction()
     * @model required="true"
     * @generated
     */
    AbstractAction getAbstractAction();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirectionsmeasuringpoint.AbstractActionDataMeasuringPoint#getAbstractAction
     * <em>Abstract Action</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Abstract Action</em>' reference.
     * @see #getAbstractAction()
     * @generated
     */
    void setAbstractAction(AbstractAction value);

} // AbstractActionDataMeasuringPoint
