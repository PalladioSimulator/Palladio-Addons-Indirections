package org.palladiosimulator.simulizar.indirection.resources;

import java.util.Objects;
import java.util.function.Predicate;

import org.palladiosimulator.simulizar.indirection.characteristics.Characteristic;
import org.palladiosimulator.simulizar.indirection.characteristics.CharacteristicFilter;

public final class CharacteristicsUtil {
    private static boolean canMatch(String pattern) {
        return (pattern != null) && (!pattern.isEmpty());
    }
    
    // does not match, if pattern is empty or null
    private static boolean stringMatch(String pattern, String string) {
        Objects.requireNonNull(string);
        return canMatch(pattern) && (string.contentEquals(pattern));
    }
    
    public static boolean matches(CharacteristicFilter filter, Characteristic characteristic) {
        String ctx = filter.getMatchingContext();
        String topic = filter.getMatchingTopic();
        
        return stringMatch(ctx, characteristic.getContext())
                || stringMatch (topic, characteristic.getTopic())
                || !(canMatch(ctx) || canMatch(topic));
    }
    
    public static Predicate<Characteristic> matcher(CharacteristicFilter filter) {
        return (Characteristic c) -> matches(filter, c);
    }
    
    public static Predicate<Frame> frameMatcher(CharacteristicFilter filter) {
        return (Frame f) -> matches(filter, f.characteristic);
    }
}
