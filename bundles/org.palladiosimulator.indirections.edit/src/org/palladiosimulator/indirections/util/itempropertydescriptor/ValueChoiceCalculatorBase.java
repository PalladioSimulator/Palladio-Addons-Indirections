package org.palladiosimulator.indirections.util.itempropertydescriptor;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

public abstract class ValueChoiceCalculatorBase<T extends EObject, R extends EObject> implements ValueChoiceCalculator {

    private final Class<T> objectType;
    private final Class<R> childType;

    public ValueChoiceCalculatorBase(Class<T> objectType, Class<R> childType) {
        this.objectType = objectType;
        this.childType = childType;
    }

    @Override
    public Collection<?> getValueChoice(Object object, Collection<?> originalChoice) {
        var typedObject = Optional.ofNullable(object)
            .filter(objectType::isInstance)
            .map(objectType::cast);
        if (typedObject.isEmpty()) {
            return originalChoice;
        }
        var typedList = originalChoice.stream()
            .filter(v -> v == null || childType.isInstance(v))
            .map(childType::cast)
            .collect(Collectors.toList());
        return getValueChoiceTyped(typedObject.get(), typedList);
    }

    protected abstract Collection<?> getValueChoiceTyped(T object, List<R> typedList);

}
