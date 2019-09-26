package org.palladiosimulator.indirections.scheduler.operators;

import java.util.List;
import java.util.function.Consumer;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public class JoiningOperator extends SimStatefulOperator<IndirectionDate, IndirectionDate> {
    public JoiningOperator(List<Consumer<IndirectionDate>> emitsTo) {
        super(emitsTo);
    }

    @Override
    public void accept(IndirectionDate t) {
    }
}