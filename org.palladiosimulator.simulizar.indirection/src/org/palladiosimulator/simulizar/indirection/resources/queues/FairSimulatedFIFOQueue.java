package org.palladiosimulator.simulizar.indirection.resources.queues;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.palladiosimulator.simulizar.indirection.resources.Frame;

public class FairSimulatedFIFOQueue extends AbstractSimulatedQueue {
    private List<Frame> backing;
    private final long capacity;

    public FairSimulatedFIFOQueue(long capacity) {
        this.backing = new ArrayList<>();
        this.capacity = capacity;
    }

    @Override
    public void push(Frame frame) {
        this.backing.add(frame);
    }

    @Override
    public long totalCapacity() {
        return capacity;
    }

    @Override
    protected Iterator<Frame> iterator() {
        return this.backing.iterator();
    }

    @Override
    protected Stream<Frame> stream() {
        return this.backing.stream();
    }

}
