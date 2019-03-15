package edu.kit.ipd.are.smarthomedata.old;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class OldEmitOnChangeFilter<TypeOfEntries, TypeOfKeys, TypeOfValues> implements Consumer<TypeOfEntries> {
	private final Map<TypeOfKeys, TypeOfValues> values = new HashMap<>();
	
	private final Function<TypeOfEntries, TypeOfKeys> keyExtractor;
	private final Function<TypeOfEntries, TypeOfValues> valueExtractor;
	private final Consumer<TypeOfEntries> callback;
	
	public OldEmitOnChangeFilter(Function<TypeOfEntries, TypeOfKeys> keyExtractor, Function<TypeOfEntries, TypeOfValues> valueExtractor, Consumer<TypeOfEntries> callback) {
		this.keyExtractor = keyExtractor;
		this.valueExtractor = valueExtractor;
		this.callback = callback;
	}

	@Override
	public void accept(TypeOfEntries entry) {
		TypeOfKeys key = keyExtractor.apply(entry);
		TypeOfValues value = valueExtractor.apply(entry);
		
		if (!values.containsKey(key) || (values.get(key) != value)) {
			values.put(key, value);
			emit(entry);
		}
	}

	private void emit(TypeOfEntries value) {
		callback.accept(value);
	}
}
