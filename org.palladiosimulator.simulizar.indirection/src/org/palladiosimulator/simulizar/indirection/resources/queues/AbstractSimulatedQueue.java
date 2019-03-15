package org.palladiosimulator.simulizar.indirection.resources.queues;

import static org.palladiosimulator.simulizar.indirection.resources.CharacteristicsUtil.frameMatcher;
import static org.palladiosimulator.simulizar.indirection.resources.CharacteristicsUtil.matches;

import java.util.Iterator;
import java.util.stream.Stream;

import org.palladiosimulator.simulizar.indirection.characteristics.CharacteristicFilter;
import org.palladiosimulator.simulizar.indirection.resources.Frame;
import org.palladiosimulator.simulizar.indirection.resources.SimulatedQueue;

public abstract class AbstractSimulatedQueue implements SimulatedQueue {
    protected abstract Iterator<Frame> iterator();
    protected abstract Stream<Frame> stream();
    
    
    @Override
    public Frame pop(CharacteristicFilter filter) {
        Iterator<Frame> iter = iterator();
        while (iter.hasNext()) {
            Frame f = iter.next();
            if (matches(filter, f.characteristic)) {
                iter.remove();
                return f;
            }
        }

        return null;
    }

    @Override
    public long totalAvailable() {
        return this.totalCapacity() - stream().count();
    }


    @Override
    public Frame peek(CharacteristicFilter filter, long num) {
        return stream().filter(frameMatcher(filter)).skip(num).findFirst().orElse(null);
    }

    @Override
    public long canProvideHowManyOf(CharacteristicFilter filter) {
        return stream().filter(frameMatcher(filter)).count();
    }
    
    @Override
    public long canAcceptHowManyOf(CharacteristicFilter filter) {
        return totalAvailable();
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
