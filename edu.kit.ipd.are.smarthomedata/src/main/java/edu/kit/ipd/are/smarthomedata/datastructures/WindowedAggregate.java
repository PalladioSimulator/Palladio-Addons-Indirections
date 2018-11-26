package edu.kit.ipd.are.smarthomedata.datastructures;

import java.util.function.Consumer;

import edu.kit.ipd.are.smarthomedata.dto.SmartMeterReading;
import edu.kit.ipd.are.smarthomedata.dto.WindowedMedian;
import edu.kit.ipd.are.smarthomedata.dto.SmartMeterReading.ReadingType;

public class WindowedAggregate implements Consumer<SmartMeterReading> {
	// holds the interval of the NEXT window to be emitted
	// the progression of this will look like this:
	//
	// s = 0, e = 0 + window_size - 1
	// s = window_shift, e = window_shift + window_size - 1
	// s = window_shift * 2, e = window_shift * 2 + window_size - 1
	private long startTimestamp;
	private long endTimestamp;

	private final int windowSize; // in seconds
	private final int windowShift; // in seconds
	private final CircularBuffer buffer;

	private final Consumer<WindowedMedian> callback;

	public WindowedAggregate(int windowSize, int windowShift, Consumer<WindowedMedian> callback) {
		this.windowSize = windowSize;
		this.windowShift = windowShift;
		this.buffer = new CircularBuffer(this.windowSize + 2);

		this.startTimestamp = 0;
		this.endTimestamp = startTimestamp + this.windowSize - 1;

		this.callback = callback;
	}

	@Override
	public void accept(SmartMeterReading reading) {
		// special case, when we do not have a reading yet, but one is commited that is
		// not for the 0th timeslot
		if (startTimestamp == 0L && reading.timestamp > 0L) {
			accept(new SmartMeterReading(-1L, 0, reading.value, ReadingType.LOAD, reading.plug_id, reading.household_id,
					reading.house_id));
		}

		// we have to calculate and emit, if this is passed.
		// while loop, if multiple windows are skipped by a newly arriving reading
		buffer.add(reading.timestamp, reading.value);
		while (reading.timestamp >= this.endTimestamp) {
			float medianToEmit = buffer.median(this.startTimestamp, this.endTimestamp);
			WindowedMedian wm = new WindowedMedian(reading.plugIdentifier, medianToEmit, this.startTimestamp, this.endTimestamp);
//			System.out.println("Emitting: " + wm);
			callback.accept(wm);
			shiftWindow();
		}
	}

	private void shiftWindow() {
		startTimestamp += windowShift;
		endTimestamp += windowShift;
	}
}
