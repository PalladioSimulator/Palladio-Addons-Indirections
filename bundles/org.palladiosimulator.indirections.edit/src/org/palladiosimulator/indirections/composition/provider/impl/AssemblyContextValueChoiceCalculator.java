package org.palladiosimulator.indirections.composition.provider.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.util.itempropertydescriptor.ValueChoiceCalculatorBase;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.ComposedStructure;
import org.palladiosimulator.pcm.core.composition.Connector;

public class AssemblyContextValueChoiceCalculator extends ValueChoiceCalculatorBase<Connector, AssemblyContext> {

    public AssemblyContextValueChoiceCalculator() {
        super(Connector.class, AssemblyContext.class);
    }

    @Override
    protected Collection<?> getValueChoiceTyped(Connector object, List<AssemblyContext> typedList) {
        var candidates = Optional.ofNullable(object.getParentStructure__Connector())
            .map(ComposedStructure::getAssemblyContexts__ComposedStructure)
            .map(l -> (List<AssemblyContext>) l)
            .orElse(Collections.<AssemblyContext> emptyList());
        return typedList.stream()
            .filter(ac -> ac == null || candidates.contains(ac))
            .collect(Collectors.toList());
    }

}
