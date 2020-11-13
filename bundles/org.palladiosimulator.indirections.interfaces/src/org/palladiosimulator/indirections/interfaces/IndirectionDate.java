package org.palladiosimulator.indirections.interfaces;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.simulizar.utils.SimulatedStackHelper;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stoexvisitor.VariableMode;

public interface IndirectionDate {
    default void addData(final Map<String, Object> newEntries) {
        for (final Entry<String, Object> entry : newEntries.entrySet()) {
            this.addDate(entry.getKey(), entry.getValue());
        }
    }

    void addDate(String key, Object value);

    default Object evaluate(final String stoEx) {
        return StackContext.evaluateStatic(stoEx, SimulatedStackHelper.createFromMap(this.getData()),
                VariableMode.EXCEPTION_ON_NOT_FOUND);
    }

    default Object evaluate(final PCMRandomVariable pcmRandomVariable) {
        return evaluate(pcmRandomVariable.getSpecification());
    }

    Map<String, Object> getData();

    Collection<Double> getTime();
}
