package org.palladiosimulator.indirections.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

public final class IterableUtil {
    public static final <A extends Iterable<?>> A claimAtLeastOne(final A iterable) {
        final Iterator<?> iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            throw new IllegalStateException(
                    "It was claimed that the collection '" + iterable + "' contains at least one element!");
        }
        return iterable;
    }

    public static final <A extends Iterable<T>, T> T claimEqual(final A iterable) {
        final T first = iterable.iterator()
            .next();
        for (final T t : iterable) {
            if (!Objects.equals(t, first)) {
                throw new IllegalStateException("It was claimed that the collection '" + iterable
                        + "' contains only equal elements! Found " + first + " and " + t);
            }
        }
        return first;
    }

    public static final <A extends Iterable<T>, T, R> R claimEqualKey(final A iterable,
            final Function<T, R> keyFunction) {
        final T first = iterable.iterator()
            .next();
        for (final T t : iterable) {
            if (!Objects.equals(keyFunction.apply(t), keyFunction.apply(first))) {
                throw new IllegalStateException("It was claimed that the collection '" + iterable
                        + "' contains only elements with equal key! Found " + first + " and " + t);
            }
        }
        return keyFunction.apply(first);
    }

    public static final <A extends Iterable<T>, T> T claimOne(final A iterable) {
        final Iterator<T> iterator = iterable.iterator();
        if (iterator.hasNext()) {
            final T one = iterator.next();
            if (!iterator.hasNext()) {
                return one;
            }
        }
        throw new IllegalStateException(
                "It was claimed that the collection '" + iterable + "' contains exactly one element!");
    }

    @SuppressWarnings("unchecked")
    public static <U, T extends U> Collection<T> claimType(final Collection<U> collection,
            final Class<? extends T> claimedElementType) {
        // TODO actually check elements
        return (Collection<T>) ((Collection<?>) collection);
    }

    public static <T> Stream<T> stream(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }

    public static <T> EList<T> toEList(final Iterable<T> iterable) {
        return ECollections.asEList(stream(iterable).collect(Collectors.toList()));
    }

    public static <K, V> Map<K, V> toMap(final Iterable<Entry<K, V>> entries) {
        return IterableUtil.stream(entries)
            .collect(Collectors.toMap(it -> it.getKey(), it -> it.getValue()));
    }

    private IterableUtil() {

    }
}
