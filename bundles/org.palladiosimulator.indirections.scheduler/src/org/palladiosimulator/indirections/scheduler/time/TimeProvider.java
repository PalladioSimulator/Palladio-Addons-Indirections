package org.palladiosimulator.indirections.scheduler.time;

import java.util.Map;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;

@FunctionalInterface
public interface TimeProvider {
    public double getTime(ISchedulableProcess schedulableProcess, Map<String, Object> data);
}
