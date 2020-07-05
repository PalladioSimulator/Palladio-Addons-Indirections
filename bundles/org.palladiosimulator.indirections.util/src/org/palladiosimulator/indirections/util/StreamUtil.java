package org.palladiosimulator.indirections.util;

import java.util.Collection;
import java.util.function.BinaryOperator;

public final class StreamUtil {
    private StreamUtil() {
    }

    public final static <T> BinaryOperator<T> reduceToMaximumOne() {
        return (a, b) -> {
            throw new RuntimeException("Must be exactly one element.");
        };
    }

    public final static double minimumOrNegativeInfinity(Collection<Double> numbers) {
        return numbers.stream()
            .mapToDouble(it -> (double) it)
            .min()
            .orElse(Double.NEGATIVE_INFINITY);
    }
}