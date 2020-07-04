package org.palladiosimulator.indirections.util;

import java.util.Optional;
import java.util.function.Supplier;

import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;

public final class ObjectUtil {
    public static <U, T extends U> Optional<T> tryCast(final U in, final Class<T> type) {
        if (!type.isAssignableFrom(in.getClass())) {
            return Optional.empty();
        }

        return Optional.ofNullable(type.cast(in));
    }

    public static <X extends Throwable, U, T extends U> T forceCast(final U in, final Class<T> type,
            final Supplier<? extends X> exceptionSupplier) throws X {
        if (!type.isAssignableFrom(in.getClass())) {
            throw exceptionSupplier.get();
        }

        return type.cast(in);
    }

    public static <U, T extends U> T forceCast(final U in, final Class<T> type) {
        if (!type.isAssignableFrom(in.getClass())) {
            throw new PCMModelInterpreterException("Expected " + type.getName() + " but got " + in);
        }

        return type.cast(in);
    }

    private ObjectUtil() {
    }

}
