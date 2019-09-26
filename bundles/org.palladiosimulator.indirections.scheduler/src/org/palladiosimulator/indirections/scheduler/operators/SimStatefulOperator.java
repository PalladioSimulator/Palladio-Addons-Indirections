package org.palladiosimulator.indirections.scheduler.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public abstract class SimStatefulOperator<T extends IndirectionDate, U extends IndirectionDate> implements Consumer<T> {
    private final List<Consumer<U>> emitsTo;

    public SimStatefulOperator(List<Consumer<U>> emitsTo) {
        this.emitsTo = new ArrayList<>(emitsTo);
    }

    protected final void emit(U date) {
        emitsTo.forEach(it -> it.accept(date));
    }
}