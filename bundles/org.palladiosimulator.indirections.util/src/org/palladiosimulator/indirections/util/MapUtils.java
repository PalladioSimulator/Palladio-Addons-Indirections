package org.palladiosimulator.indirections.util;

import java.util.Map;
import java.util.Optional;

public final class MapUtils {
    public static <K, V> Optional<V> tryGet(final Map<K, V> map, final K key) {
        return Optional.ofNullable(map.get(key));
    }

    private MapUtils() {
    }
}
