package org.palladiosimulator.simulizar.indirection.resources.queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.palladiosimulator.simulizar.indirection.resources.Frame;

public class FairSimulatedStack extends AbstractSimulatedQueue {
    private Deque<Frame> backing;
    private long capacity;

    public FairSimulatedStack(long capacity) {
        this.backing = new ArrayDeque<Frame>();
        this.capacity = capacity;
    }

    @Override
    public long totalCapacity() {
        return this.capacity;
    }

    @Override
    public void push(Frame element) {
        Objects.requireNonNull(element);
        backing.add(element);
    }

    @Override
    protected Iterator<Frame> iterator() {
        return this.backing.descendingIterator();
    }

    @Override
    protected Stream<Frame> stream() {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator(), Spliterator.ORDERED), false);
    }
}
