package org.palladiosimulator.indirections.scheduler.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class SimStatefulOperator<T, U> implements Consumer<T> {
    private final List<Consumer<U>> emitsTo;

    public SimStatefulOperator() {
        this.emitsTo = new ArrayList<>();
    }

    public void addConsumer(final Consumer<U> emitTo) {
        this.emitsTo.add(emitTo);
    }

    protected final void emit(final U date) {
        this.emitsTo.forEach(it -> it.accept(date));
    }
}