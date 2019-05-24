package org.palladiosimulator.simulizar.indirection.resources.queues;

import java.util.Iterator;
import java.util.stream.Stream;

import org.palladiosimulator.simulizar.indirection.resources.Frame;
import org.palladiosimulator.simulizar.indirection.resources.SimulatedQueue;

public abstract class AbstractSimulatedQueue implements SimulatedQueue {
    protected abstract Iterator<Frame> iterator();

    protected abstract Stream<Frame> stream();

    @Override
    public Frame pop() {
        Iterator<Frame> iter = iterator();
        if (iter.hasNext()) {
            Frame f = iter.next();
            iter.remove();
            return f;
        }
        return null;
    }

    @Override
    public long totalAvailable() {
        return this.totalCapacity() - stream().count();
    }

    @Override
    public Frame peek(long num) {
        return stream().skip(num).findFirst().orElse(null);
    }

    @Override
    public long canProvideHowMany() {
        return stream().count();
    }

    @Override
    public long canAcceptHowMany() {
        return totalAvailable();
    }
}
