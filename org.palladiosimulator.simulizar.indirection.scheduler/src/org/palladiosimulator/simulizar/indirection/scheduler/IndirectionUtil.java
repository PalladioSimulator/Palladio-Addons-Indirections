package org.palladiosimulator.simulizar.indirection.scheduler;

import java.util.Iterator;
import java.util.List;

public final class IndirectionUtil {
	private IndirectionUtil() {
		
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
			if (t != first)
				throw new IllegalStateException("It was claimed that the collection '" + iterable + "' contains only equal elements! Found " + first + " and " + t);
		}
		return first;
	}
}
