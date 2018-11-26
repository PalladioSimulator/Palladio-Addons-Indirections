package edu.kit.ipd.are.smarthomedata.old;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import edu.kit.ipd.are.smarthomedata.datastructures.WindowedAggregate;
import edu.kit.ipd.are.smarthomedata.dto.SmartMeterReading;

public class OutliersHouse implements Consumer<SmartMeterReading> {

	private final long houseId;
	private final int windowSize;
	private final int windowShift;
	private final Map<Long, WindowedAggregate> plugs;
	private int add;
	private double outliers;
	private Consumer<Double> callback;

	public OutliersHouse(final long house_id, final int windowSize, final int windowShift, Consumer<Double> callback) {
		this.houseId = house_id;
		this.plugs = new HashMap<>();
		this.windowSize = windowSize;
		this.windowShift = windowShift;
		this.add = 0;

		this.callback = callback;
	}

	@Override
	public void accept(final SmartMeterReading in) {
		if (houseId != -1 && houseId != in.house_id) {
			return;
		}

		final Long plugId = Long.valueOf(in.plug_id);
		final float value = in.value;
		if (!plugs.containsKey(plugId)) {
			plugs.put(plugId, new WindowedAggregate(windowSize, windowShift, System.out::println));
		}
//		plugs.get(plugId).accept(value);
		add++;
	}

	public float[] medians() {
//		final Collection<CircularArray> values = plugs.values();
//		float[] medians = new float[values.size()];
//		int addPointer = 0;
//		for (CircularArray array : values) {
//			medians[addPointer] = array.median();
//		}
//		Arrays.parallelSort(medians);
//		return medians;
		return null;
	}

	public float outliers() {
		float[] medians = medians();
		float median = 0.0F;
		if ((medians.length % 2) == 0) {
			median = (medians[medians.length / 2] + medians[(medians.length / 2) - 1]) / 2;
		} else {
			median = medians[medians.length / 2];
		}

		int count = 0;
		for (int i = (medians.length / 2) - 1; i < medians.length; i++) {
			if (medians[i] > median) {
				count++;
			}
		}

		return (float) count / medians.length;
	}

	public void emitIfWindowShifted() {
		if (add >= windowShift) {
			outliers = outliers();
			add = 0;
			callback.accept(outliers);
		}
	}

}
