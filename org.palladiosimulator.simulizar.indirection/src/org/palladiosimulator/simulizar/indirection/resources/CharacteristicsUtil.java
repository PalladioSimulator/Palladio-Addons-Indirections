package org.palladiosimulator.simulizar.indirection.resources;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.palladiosimulator.simulizar.indirection.characteristics.Characteristic;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;

public final class CharacteristicsUtil {
    // TODO: move to model
    public static Map<Characteristic, String> splitSpecification(Collection<Characteristic> characteristics,
            String overallSpecification) {
        Map<Characteristic, String> result = new HashMap<>();

        String[] split = overallSpecification.split(";");
        for (String part : split) {
            int positionOfEqualsSign = part.indexOf("=");
            String nameOfCharacteristic = part.substring(0, positionOfEqualsSign);
            String specification = part.substring(positionOfEqualsSign + 1);
            Characteristic characteristic = characteristics.stream()
                    .filter(it -> it.getEntityName().equals(nameOfCharacteristic)).findFirst()
                    .orElseThrow(IllegalStateException::new);

            result.put(characteristic, specification);
        }

        return result;
    }

    public static Map<Characteristic, Double> evaluateSpecification(Map<Characteristic, String> specifications) {
        Map<Characteristic, Double> characteristicValues = new HashMap<>();
        for (Entry<Characteristic, String> entry : specifications.entrySet()) {
            Double characteristicValue = (Double) StackContext.evaluateStatic(entry.getValue());
            characteristicValues.put(entry.getKey(), characteristicValue);
        }
        return characteristicValues;
    }

    public static Map<Characteristic, Double> splitAndEvaluateSpecification(Collection<Characteristic> characteristics, String overallSpecification) {
        return evaluateSpecification(splitSpecification(characteristics, overallSpecification));
    }

    /*
     * private static boolean canMatch(String pattern) { return (pattern != null) &&
     * (!pattern.isEmpty()); }
     * 
     * // does not match, if pattern is empty or null private static boolean stringMatch(String
     * pattern, String string) { Objects.requireNonNull(string); return canMatch(pattern) &&
     * (string.contentEquals(pattern)); }
     * 
     * public static boolean matches(CharacteristicFilter filter, Characteristic characteristic) {
     * String ctx = filter.getMatchingContext(); String topic = filter.getMatchingTopic();
     * 
     * return stringMatch(ctx, characteristic.getContext()) || stringMatch (topic,
     * characteristic.getTopic()) || !(canMatch(ctx) || canMatch(topic)); }
     * 
     * public static Predicate<Characteristic> matcher(CharacteristicFilter filter) { return
     * (Characteristic c) -> matches(filter, c); }
     * 
     * public static Predicate<Frame> frameMatcher(CharacteristicFilter filter) { return (Frame f)
     * -> matches(filter, f.characteristic); }
     */
}
