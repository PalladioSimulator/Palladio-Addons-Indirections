package org.palladiosimulator.simulizar.indirection.resources.queues;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import org.palladiosimulator.simulizar.indirection.resources.Frame;

public class SimulatedPriorityQueue extends AbstractSimulatedQueue {
    private PriorityQueue<Frame> backing;
    private long capacity;

    public SimulatedPriorityQueue(long capacity) {
        throw new IllegalArgumentException();
        /*this.backing = new PriorityQueue<Frame>(Math.toIntExact(capacity),
                Comparator
                .<Frame> comparingInt(it -> it.characteristic.getPriority())
                .thenComparingDouble(it -> -it.birth));*/
        
        //this.capacity = capacity;
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
        return this.backing.iterator();
    }

    @Override
    protected Stream<Frame> stream() {
        return this.backing.stream();
    }
}
