package org.palladiosimulator.indirections.interfaces;

import java.util.Map;
import java.util.Map.Entry;

import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.simulizar.utils.SimulatedStackHelper;

import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.variables.stoexvisitor.VariableMode;

public interface IndirectionDate {
	Map<String, Object> getData();

	Double getTime();

	void addDate(String key, Object value);

	default void addData(Map<String, Object> newEntries) {
		for (Entry<String, Object> entry : newEntries.entrySet()) {
			addDate(entry.getKey(), entry.getValue());
		}
	}

	default Object evaluate(PCMRandomVariable pcmRandomVariable) {
		return Context.evaluateStatic(pcmRandomVariable.getSpecification(),
				SimulatedStackHelper.createFromMap(this.getData()), VariableMode.EXCEPTION_ON_NOT_FOUND);
	}
}
