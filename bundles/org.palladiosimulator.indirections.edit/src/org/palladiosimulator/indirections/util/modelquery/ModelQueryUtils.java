package org.palladiosimulator.indirections.util.modelquery;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;

public final class ModelQueryUtils {

    private ModelQueryUtils() {
        // intentionally left blank
    }

    public static <T> Optional<T> findParentOfType(EObject startingPoint, Class<T> parentType) {
        EObject currentObject = startingPoint;
        while (currentObject != null) {
            if (parentType.isInstance(currentObject)) {
                return Optional.of(currentObject)
                    .map(parentType::cast);
            }
            currentObject = currentObject.eContainer();
        }
        return Optional.empty();
    }

}
