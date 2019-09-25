package org.palladiosimulator.indirections.util;

import java.util.function.BinaryOperator;

public final class StreamUtil {
    public final static <T> BinaryOperator<T> reduceToMaximumOne() {
        return (a, b) -> {
            throw new RuntimeException("Must be exactly one element.");
        };
    }
}