package edu.kit.ipd.are.smarthomedata.analysis;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

import edu.kit.ipd.are.smarthomedata.datastructures.WindowedAggregate;
import edu.kit.ipd.are.smarthomedata.dto.PlugIdentifier;
import edu.kit.ipd.are.smarthomedata.dto.SmartMeterReading;
import edu.kit.ipd.are.smarthomedata.dto.WindowedMedian;

public class MedianEachPlug implements Consumer<SmartMeterReading> {
	private Consumer<WindowedMedian> callback;
	private Map<PlugIdentifier, WindowedAggregate> aggregates = new HashMap<>();
	private int windowSize;
	private int windowShift;
	private final Predicate<PlugIdentifier> responsibilityCheck;

	public MedianEachPlug(Predicate<PlugIdentifier> responsibilityCheck, int windowSize, int windowShift, Consumer<WindowedMedian> callback) {
		this.windowSize = windowSize;
		this.windowShift = windowShift;
		this.responsibilityCheck = responsibilityCheck;
		
		this.callback = callback;
	}
	
	private WindowedAggregate createAggregate(PlugIdentifier plugIdentifier) {
		return new WindowedAggregate(windowSize, windowShift, callback);
	}

	@Override
	public void accept(SmartMeterReading t) {
		if (!responsibilityCheck.test(t.plugIdentifier)) {
			return;
		}
		
		WindowedAggregate aggregate = aggregates.computeIfAbsent(t.plugIdentifier, this::createAggregate);
		aggregate.accept(t);
	}

}