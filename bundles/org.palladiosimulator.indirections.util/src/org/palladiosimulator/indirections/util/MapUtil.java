package org.palladiosimulator.indirections.util;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public final class MapUtil {
    private MapUtil() {
    }

    public static <K, V> Map<K, V> toMap(final List<Entry<K, V>> entryList) {
        return entryList.stream().collect(Collectors.toMap(it -> it.getKey(), it -> it.getValue()));
    }
}
