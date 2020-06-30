package org.palladiosimulator.indirections.scheduler.operators;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public class DirectTransferOperator<T extends IndirectionDate> extends SimStatefulOperator<T, T> {
    public DirectTransferOperator() {
        super();
    }

    @Override
    public void accept(final T t) {
        this.emit(t);
    }

}