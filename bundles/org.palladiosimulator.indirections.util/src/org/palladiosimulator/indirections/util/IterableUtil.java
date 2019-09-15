package org.palladiosimulator.indirections.util;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Function;

public final class IterableUtil {
	private IterableUtil() {
		
	}
	
	public static final <A extends Iterable<T>, T> T claimOne(A iterable) {
		Iterator<T> iterator = iterable.iterator();
		if (iterator.hasNext()) {
			T one = iterator.next();
	        if (!iterator.hasNext()) {
	        	return one;
	        }
		}
		throw new IllegalStateException("It was claimed that the collection '" + iterable + "' contains exactly one element!");
	}

	public static final <A extends Iterable<T>, T> T claimEqual(A iterable) {
		T first = iterable.iterator().next();
		for (T t : iterable) {
			if (!Objects.equals(t, first))
				throw new IllegalStateException("It was claimed that the collection '" + iterable + "' contains only equal elements! Found " + first + " and " + t);
		}
		return first;
	}
	
	public static final <A extends Iterable<T>, T, R> R claimEqualKey(A iterable, Function<T, R> keyFunction) {
		T first = iterable.iterator().next();
		for (T t : iterable) {
			if (!Objects.equals(keyFunction.apply(t), keyFunction.apply(first)))
				throw new IllegalStateException("It was claimed that the collection '" + iterable + "' contains only elements with equal key! Found " + first + " and " + t);
		}
		return keyFunction.apply(first);
	}
}
