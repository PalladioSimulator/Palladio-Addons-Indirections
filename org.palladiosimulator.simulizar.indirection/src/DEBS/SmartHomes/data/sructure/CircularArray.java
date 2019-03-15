package DEBS.SmartHomes.data.sructure;

import java.util.Arrays;

public class CircularArray {

    private int addPointer;
    private final float[] elementData;
    private boolean full;
    private final int maxCapacity;

    public CircularArray(final int maxCapacity) {
        elementData = new float[maxCapacity];
        this.maxCapacity = maxCapacity;
        addPointer = 0;
        full = false;
    }

    public CircularArray(final int maxCapacity, final float value) {
        this(maxCapacity);
        add(value);
    }

    public void add(final float value) {
        elementData[addPointer] = value;
        addPointer += 1;

        if (addPointer >= maxCapacity) {
            addPointer = 0;
            full = true;
        }
    }

    public float median() {
        final int capacity = full ? maxCapacity : addPointer - 1;
        final float[] copy = new float[capacity];

        System.arraycopy(elementData, 0, copy, 0, capacity);
        Arrays.parallelSort(copy);

        if ((copy.length % 2) == 0) {
            return (copy[copy.length / 2] + copy[(copy.length / 2) - 1]) / 2;
        }
        return copy[copy.length / 2];
    }

}
