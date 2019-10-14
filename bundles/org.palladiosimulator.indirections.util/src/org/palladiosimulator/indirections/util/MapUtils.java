package org.palladiosimulator.indirections.util;

import java.util.Map;
import java.util.Optional;

public final class MapUtils {
    private MapUtils() {
    }

    public static <K, V> Optional<V> tryGet(Map<K, V> map, K key) {
        return Optional.ofNullable(map.get(key));
    }
}
