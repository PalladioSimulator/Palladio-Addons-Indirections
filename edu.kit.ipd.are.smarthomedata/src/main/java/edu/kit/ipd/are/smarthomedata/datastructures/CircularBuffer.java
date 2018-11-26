package edu.kit.ipd.are.smarthomedata.datastructures;

import java.util.Arrays;
import java.util.Comparator;

public class CircularBuffer {
	public static final class Element {
		public long timestamp;
		public float data;

		public Element(long timestamp, float data) {
			this.timestamp = timestamp;
			this.data = data;
		}

		public float data() {
			return data;
		}

		public static final Comparator<Element> COMPARE_DATA = Comparator.comparing(Element::data);
	}

	private int addPointer;

	private final Element[] elements;

	private boolean full;
	private final int maxCapacity;

	private final Element[] sortedCopy;

	public CircularBuffer(final int maxCapacity) {
		elements = new Element[maxCapacity];

		this.maxCapacity = maxCapacity;
		this.sortedCopy = new Element[maxCapacity];

		addPointer = 0;
		full = false;
	}

	public void add(long timestamp, float data) {
		elements[addPointer] = new Element(timestamp, data);
		addPointer++;

		if (addPointer >= maxCapacity) {
			addPointer = 0;
			full = true;
		}
	}

	public int correctIndex(int index) {
		return (index + (full ? addPointer : 0)) % maxCapacity;
	}

	public float median(long ts_start, long ts_end) {
		final int capacity = full ? maxCapacity : addPointer;
		int startIndex = -1;
		int endIndex = -1;

		for (int i = 0; i < capacity; i++)
			if (correctedAt(i).timestamp > ts_start) {
				startIndex = i - 1;
				break;
			} else if (correctedAt(i).timestamp == ts_start) {
				startIndex = i;
				break;
			}

		for (int i = capacity - 1; i >= 0; i--)
			if (correctedAt(i).timestamp <= ts_end) {
				endIndex = i;
				break;
			}

		int maxCopyIndex = endIndex - startIndex;

		if (startIndex == -1 || endIndex == -1 || maxCopyIndex < 0) {
			throw new IllegalStateException("The given window (" + ts_start + " - " + ts_end + ") is not in the buffer.");
		}

		long completeWeight = ts_end - ts_start + 1;

		// cap ends on the current time window
		if (maxCopyIndex == 0) {
			return correctedAt(startIndex).data;
//			sortedCopy[0] = new Element(ts_end - ts_start, elements[startIndex].data);
		} else {
			sortedCopy[0] = new Element(correctedAt(startIndex + 1).timestamp - ts_start, correctedAt(startIndex).data);
			sortedCopy[maxCopyIndex] = new Element(ts_end - correctedAt(endIndex).timestamp + 1,
					correctedAt(endIndex).data);
			for (int i = 1; i < maxCopyIndex + 1 - 1; i++) {
				sortedCopy[i] = new Element(
						correctedAt(startIndex + 1 + i).timestamp - correctedAt(startIndex + i).timestamp,
						correctedAt(startIndex + i).data);
			}
		}

		Arrays.parallelSort(sortedCopy, 0, maxCopyIndex + 1, Element.COMPARE_DATA);

		// TODO: replace by binary search?
		long weightedIndex = 0;
		for (int i = 0; i < maxCopyIndex + 1; i++) {
			weightedIndex += sortedCopy[i].timestamp;
			if ((completeWeight % 2 == 0) && (weightedIndex == completeWeight / 2)) {
				// we are right "on the edge"
				return (0.5f * sortedCopy[i].data + 0.5f * sortedCopy[i + 1].data);
			}
			if (weightedIndex > (completeWeight / 2)) {
				return sortedCopy[i].data;
			}
		}

		throw new IllegalStateException();
	}

	private Element correctedAt(int i) {
		return elements[correctIndex(i)];
	}

	public boolean isFull() {
		return full;
	}
}