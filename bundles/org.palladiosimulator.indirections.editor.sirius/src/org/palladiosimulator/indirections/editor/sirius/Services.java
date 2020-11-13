package org.palladiosimulator.indirections.editor.sirius;

import org.palladiosimulator.indirections.IndirectionsPackage;

import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.VariableReference;

/**
 * The services class used by VSM for the {@link IndirectionsPackage}.
 */
public class Services {

    /**
     * Transforms a {@link VariableReference} to a textual representation.
     * 
     * @param variableReference
     *            The reference to get the full name from.
     * @return The full name.
     */
    public String getFullName(VariableReference variableReference) {
        String out = "";
        AbstractNamedReference current = variableReference;
        while (current != null) {
            out += current.getReferenceName();
            if ((current instanceof NamespaceReference)) {
                current = ((NamespaceReference) current).getInnerReference_NamespaceReference();
                out += ".";
            } else {
                current = null;
            }
        }
        return out;
    }

}
