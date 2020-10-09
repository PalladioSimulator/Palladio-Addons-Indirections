package org.palladiosimulator.indirections.util.itempropertydescriptor;

import java.util.Collection;

@FunctionalInterface
public interface ValueChoiceCalculator {

    Collection<?> getValueChoice(Object object, Collection<?> originalChoice);
    
}
