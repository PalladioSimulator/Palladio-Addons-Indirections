package org.palladiosimulator.indirections.util;

import java.util.Optional;
import java.util.function.Supplier;

public final class ObjectUtil {
    public static <U, T extends U> Optional<T> tryCast(final U in, final Class<T> type) {
        if (type.isInstance(in)) {
            return Optional.ofNullable(type.cast(in));
        } else {
            return Optional.empty();
        }
    }

    public static <X extends Throwable, U, T extends U> T tryCast(final U in, final Class<T> type,
            final Supplier<? extends X> exceptionSupplier) throws X {
        if (type.isInstance(in)) {
            throw exceptionSupplier.get();
        }

        return type.cast(in);
    }

    private ObjectUtil() {
    }

}
