package org.palladiosimulator.indirections.scheduler.data;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.simulizar.utils.SimulatedStackHelper;

import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.variables.stoexvisitor.VariableMode;

public class ConcreteGroupingIndirectionDate<T extends IndirectionDate> implements GroupingIndirectionDate<T> {
    private final List<T> dataInGroup;
    protected final Map<String, Object> extraData;
    public final UUID uuid = UUID.randomUUID();

    public ConcreteGroupingIndirectionDate(List<T> dataInGroup, Map<String, Object> extraData) {
        this.dataInGroup = dataInGroup;
        this.extraData = extraData;
    }

    public ConcreteGroupingIndirectionDate(List<T> dataInGroup) {
        this(dataInGroup, new HashMap<>());
    }

    @Override
    public List<T> getDataInGroup() {
        return Collections.unmodifiableList(dataInGroup);
    }

    @Override
    public Map<String, Object> getData() {
        HashMap<String, Object> result = new HashMap<>(extraData);
        result.put("NUMBER_OF_ELEMENTS.VALUE", dataInGroup.size());
        result.put("INNER_ELEMENTS.VALUE", dataInGroup);
        return result;
    }

    @Override
    public Double getTime() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        String dataToString = dataInGroup.stream().map(it -> "(" + it.getData().entrySet().stream().map(e -> {
            return e.getKey() + "->" + e.getValue();
        }).collect(Collectors.joining(";")) + ")").collect(Collectors.joining(","));
        String extraDataString = extraData.entrySet().stream().map(it -> "(" + it.getKey() + "->" + it.getValue())
                .collect(Collectors.joining(";"));
        return "<" + this.getClass().getSimpleName() + " (" + uuid + "): " + dataToString + ", extra: "
                + extraDataString + ">";
    }

    @Override
    public Object evaluate(PCMRandomVariable expression) {
        return Context.evaluateStatic(expression.getSpecification(), SimulatedStackHelper.createFromMap(this.getData()),
                VariableMode.EXCEPTION_ON_NOT_FOUND);
    }

	@Override
	public void addDate(String key, Object value) {
		extraData.put(key, value);
	}
}
