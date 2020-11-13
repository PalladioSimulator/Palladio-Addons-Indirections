package org.palladiosimulator.indirections.actions.provider.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.ResourceDemandingBehaviour;

import tools.mdsd.library.emfeditutils.itempropertydescriptor.ValueChoiceCalculatorBase;

public class AbstractActionValueChoiceCalculator extends ValueChoiceCalculatorBase<AbstractAction, AbstractAction> {

    public AbstractActionValueChoiceCalculator() {
        super(AbstractAction.class, AbstractAction.class);
    }

    @Override
    protected Collection<?> getValueChoiceTyped(AbstractAction object, List<AbstractAction> typedList) {
        var behaviourActions = Optional.ofNullable(object.getResourceDemandingBehaviour_AbstractAction())
            .map(ResourceDemandingBehaviour::getSteps_Behaviour)
            .map(c -> (List<AbstractAction>) c)
            .orElseGet(() -> Arrays.asList((AbstractAction) null));
        return typedList.stream()
            .filter(a -> a == null || behaviourActions.contains(a))
            .collect(Collectors.toList());
    }

}
