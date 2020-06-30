package org.palladiosimulator.indirections.scheduler.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.operators.JoiningOperator.KeyedChannel;
import org.palladiosimulator.pcm.core.PCMRandomVariable;

public class JoinedDate<T extends IndirectionDate> implements GroupingIndirectionDate<T> {
    public Map<KeyedChannel<DateWithConnector<T>, Object>, T> data;
    protected final Map<String, T> extraData;

    public JoinedDate(Map<KeyedChannel<DateWithConnector<T>, Object>, T> dataMap) {
        this.data = dataMap;
        this.extraData = new HashMap<>();
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> result = new HashMap<String, Object>();

        for (Entry<KeyedChannel<DateWithConnector<T>, Object>, T> t : data.entrySet()) {
            for (String key : t.getValue().getData().keySet()) {
                String newKey = t.getKey().toString() + "." + key;
                if (result.containsKey(newKey)) {
                    throw new IllegalStateException();
                }
                result.put(newKey, t.getValue().getData().get(key));
            }
        }

        return result;
    }

    @Override
    public Double getTime() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> getDataInGroup() {
        return Stream.concat(
        		data.values().stream(),
        		extraData.values().stream()).collect(Collectors.toList());
    }

	@Override
	public void addDate(String key, Object value) {
		this.extraData.put(key, (T) value);
	}
}
