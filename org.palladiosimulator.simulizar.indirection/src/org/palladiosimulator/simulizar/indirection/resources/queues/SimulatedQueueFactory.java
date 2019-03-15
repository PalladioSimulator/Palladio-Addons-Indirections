package org.palladiosimulator.simulizar.indirection.resources.queues;

import org.palladiosimulator.simulizar.indirection.datatypes.Scheduling;
import org.palladiosimulator.simulizar.indirection.resources.SimulatedQueue;

public interface SimulatedQueueFactory {
    SimulatedQueue createQueue(Scheduling scheduling, int capacity);

    public final static SimulatedQueueFactory INSTANCE = new SimulatedQueueFactoryImpl();

    class SimulatedQueueFactoryImpl implements SimulatedQueueFactory {
        private SimulatedQueueFactoryImpl() {
        }

        @Override
        public SimulatedQueue createQueue(Scheduling scheduling, int capacity) {
            switch (scheduling) {
            case FIRST_IN_FIRST_OUT:
                return new FairSimulatedFIFOQueue(capacity);
            case LAST_IN_FIRST_OUT:
                return new FairSimulatedStack(capacity);
            case PRIORITY:
                return new SimulatedPriorityQueue(capacity);
            case RANDOM:
                return new FairSimulatedFIFOQueue(capacity);
            default:
                throw new IllegalArgumentException();
            }
        }
    }
}