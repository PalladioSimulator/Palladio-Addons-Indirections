package org.palladiosimulator.indirections.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

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