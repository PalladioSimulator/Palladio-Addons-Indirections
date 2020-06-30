package org.palladiosimulator.indirections.util;

import java.util.Optional;
import java.util.function.Supplier;

public final class ObjectUtil {
	private ObjectUtil() {
	}
	
	public static <U, T extends U> Optional<T> tryCast(U in, Class<T> type) {
		if (type.isInstance(in)) {
			return Optional.ofNullable(type.cast(in));
		} else {
			return Optional.empty();
		}
	}
	
	public static <X extends Throwable, U, T extends U> T tryCast(U in, Class<T> type, Supplier<? extends X> exceptionSupplier) throws X {
		if (type.isInstance(in)) {
			throw exceptionSupplier.get();
		}
		
		return type.cast(in);
	}

}
