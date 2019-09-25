/**
 */
package org.palladiosimulator.indirections.partitioning;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.pcm.core.entity.NamedElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Partitioning</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.partitioning.Partitioning#getSpecification
 * <em>Specification</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.partitioning.PartitioningPackage#getPartitioning()
 * @model
 * @generated
 */
public interface Partitioning extends NamedElement {
    /**
     * Returns the value of the '<em><b>Specification</b></em>' containment reference list. The list
     * contents are of type {@link org.palladiosimulator.pcm.core.PCMRandomVariable}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Specification</em>' containment reference list.
     * @see org.palladiosimulator.indirections.partitioning.PartitioningPackage#getPartitioning_Specification()
     * @model containment="true" required="true"
     * @generated
     */
    EList<PCMRandomVariable> getSpecification();

} // Partitioning
