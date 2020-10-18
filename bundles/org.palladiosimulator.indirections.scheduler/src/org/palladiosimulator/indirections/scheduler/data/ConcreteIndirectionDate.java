package org.palladiosimulator.indirections.scheduler.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.simulizar.utils.SimulatedStackHelper;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stoexvisitor.VariableMode;

public class ConcreteIndirectionDate implements IndirectionDate {
    private final Map<String, Object> data;
    public final UUID uuid = UUID.randomUUID();
    private final List<IndirectionDate> referencedData = new ArrayList<>();

    public ConcreteIndirectionDate(final Map<String, Object> data) {
        this.data = Collections.unmodifiableMap(new HashMap<>(data));
    }

    @Override
    public void addDate(final String key, final Object value) {
        this.data.put(key, value);
    }

    @Override
    public Object evaluate(final PCMRandomVariable expression) {
        return StackContext.evaluateStatic(expression.getSpecification(),
                SimulatedStackHelper.createFromMap(this.getData()), VariableMode.EXCEPTION_ON_NOT_FOUND);
    }

    @Override
    public Map<String, Object> getData() {
        return this.data;
    }

    @Override
    public String toString() {
        final String dataToString = this.data.entrySet()
            .stream()
            .map(it -> it.getKey() + "->" + it.getValue())
            .collect(Collectors.joining(","));
        return "<" + this.getClass()
            .getSimpleName() + " (" + this.uuid + "): " + dataToString + ">";
    }

    @Override
    public void addReferencedDate(IndirectionDate indirectionDate) {
        this.referencedData.add(indirectionDate);
    }

    @Override
    public Stream<IndirectionDate> getReferencedData() {
        return this.referencedData.stream();
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

}
