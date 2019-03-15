package edu.kit.ipd.are.smarthomedata.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.DoubleStream;

import edu.kit.ipd.are.smarthomedata.dto.MutableInterval;
import edu.kit.ipd.are.smarthomedata.dto.SmartMeterReading;
import edu.kit.ipd.are.smarthomedata.dto.SmartMeterReading.ReadingType;
import edu.kit.ipd.are.smarthomedata.dto.WindowedValue;

public class WindowedAggregate implements Consumer<SmartMeterReading> {
	// holds the interval of the NEXT window to be emitted
	// the progression of this will look like this:
	//
	// s = 0, e = 0 + window_size - 1
	// s = window_shift, e = window_shift + window_size - 1
	// s = window_shift * 2, e = window_shift * 2 + window_size - 1
	private MutableInterval window;

	private final int windowSize; // in seconds
	private final int windowShift; // in seconds
	private final List<SmartMeterReading> buffer;

	private final Consumer<WindowedValue> callback;

	public WindowedAggregate(int windowSize, int windowShift, Consumer<WindowedValue> callback) {
		this.windowSize = windowSize;
		this.windowShift = windowShift;
		this.buffer = new ArrayList<>();

		this.window = new MutableInterval(0, this.windowSize - 1);

		this.callback = callback;
	}

	@Override
	public void accept(SmartMeterReading reading) {
		// special case, when we do not have a reading yet, but one is commited that is
		// not for the 0th timeslot
		if (window.start == 0L && reading.timestamp > 0L) {
			accept(new SmartMeterReading(-1L, 0, reading.value, ReadingType.LOAD, reading.plug_id, reading.household_id,
					reading.house_id, reading.origin));
		}

		buffer.add(reading);

		// TODO: multiple windows emitted at once mess up the algorithm

		/* while (reading.timestamp >= window.end) { */
		// scroll to correct window
		while (reading.timestamp >= window.end) {

			while (buffer.size() >= 2 && buffer.get(0).timestamp < window.start
					&& buffer.get(1).timestamp <= window.start) {
//				System.out.println("Removing " + buffer.get(0).toString() + ", window: " + window.toString());
				buffer.remove(0);
			}

			int lastIndex = 0;
			SmartMeterReading firstInfluencingWindow = buffer.get(0);
			SmartMeterReading lastInfluencingWindow = buffer.get(0);
			for (int i = 0; i < buffer.size(); i++) {
				SmartMeterReading currentSmr = buffer.get(i);

				if (currentSmr.timestamp > window.end)
					break;

				lastInfluencingWindow = currentSmr;
				lastIndex = i;
			}
			
			// we do not have to weigh, because there is currently one value for each point
			// of time
			double medianToEmit = lastIndex == 0 ? 0.d : median(buffer.subList(0, lastIndex));

			WindowedValue wm = new WindowedValue(reading.plugIdentifier, medianToEmit, window.asInterval(),
					new MutableInterval(firstInfluencingWindow.origin, lastInfluencingWindow.origin));
			callback.accept(wm);
			shiftWindow();
		}
	}

	private double median(List<SmartMeterReading> list) {
		DoubleStream stream = list.stream().sorted(SmartMeterReading.BY_VALUE).mapToDouble(smr -> smr.value);
		
		if (list.size() % 2 == 0) {
			return stream.skip(list.size() / 2 - 1).limit(2).average().getAsDouble();
		} else {
			return stream.skip(list.size() / 2).findFirst().getAsDouble();
		}
	}

	private void shiftWindow() {
		window.shift(windowShift);
	}
}