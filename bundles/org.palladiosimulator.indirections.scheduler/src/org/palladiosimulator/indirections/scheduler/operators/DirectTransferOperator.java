package org.palladiosimulator.indirections.scheduler.operators;

import java.util.List;
import java.util.function.Consumer;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public class DirectTransferOperator<T extends IndirectionDate> extends SimStatefulOperator<T, T> {
    public DirectTransferOperator(List<Consumer<T>> emitsTo) {
        super(emitsTo);
    }

    @Override
    public void accept(T t) {
        this.emit(t);
    }

}