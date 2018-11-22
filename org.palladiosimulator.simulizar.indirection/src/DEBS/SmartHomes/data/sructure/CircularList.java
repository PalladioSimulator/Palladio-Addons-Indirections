package DEBS.SmartHomes.data.sructure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class CircularList implements List<Float>, RandomAccess, Cloneable, Serializable {

    private static final Float NULL = Float.valueOf(0);
    private static final long serialVersionUID = 853058699269295475L;

    private static float quickSelect(final ArrayList<Float> array, final int index) {
        final ArrayList<Float> underPivot = new ArrayList<>();
        final ArrayList<Float> overPivot = new ArrayList<>();
        final ArrayList<Float> equalPivot = new ArrayList<>();

        final float pivot = array.get(index / 2);

        for (final float number : array) {
            if (number < pivot) {
                underPivot.add(number);
            } else if (number > pivot) {
                overPivot.add(number);
            } else {
                equalPivot.add(number);
            }
        }

        if (index < underPivot.size()) {
            return quickSelect(underPivot, index);
        } else if (index < (underPivot.size() + equalPivot.size())) {
            return pivot;
        }

        return quickSelect(overPivot, index - underPivot.size() - equalPivot.size());
    }

    private final ArrayList<Float> elementData;
    private final int maxCapacity;
    private int addPointer;

    public CircularList(final int maxCapacity) {
        elementData = newList(maxCapacity);
        this.maxCapacity = maxCapacity;
        addPointer = 0;
    }

    private ArrayList<Float> newList(final int maxCapacity) {
        ArrayList<Float> list = new ArrayList<>(maxCapacity);
        list.ensureCapacity(maxCapacity);
        for (int i = 0; i < maxCapacity; i++) {
            list.add(NULL);
        }
        list.trimToSize();
        return list;
    }

    public CircularList(final int maxCapacity, Float e) {
        this(maxCapacity);
        add(e);
    }

    public float median() {
        final int index = elementData.size() / 2;

        if ((elementData.size() % 2) == 0) {
            return ((quickSelect(elementData, index - 1) + quickSelect(elementData, index)) / 2.0F);
        }

        return quickSelect(elementData, index);
    }

    @Override
    public int size() {
        return elementData.size();
    }

    @Override
    public boolean isEmpty() {
        return elementData.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return elementData.contains(o);
    }

    @Override
    public Iterator<Float> iterator() {
        return elementData.iterator();
    }

    @Override
    public Object[] toArray() {
        return elementData.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return elementData.toArray(a);
    }

    @Override
    public boolean add(Float e) {
        elementData.add(addPointer, e);
        addPointer += 1;

        if (addPointer >= maxCapacity) {
            addPointer = 0;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return elementData.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return elementData.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Float> c) {
        c.forEach(this::add);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Float> c) {
        return elementData.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return elementData.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return elementData.removeAll(c);
    }

    @Override
    public void clear() {
        addPointer = 0;
    }

    @Override
    public Float get(int index) {
        return elementData.get(index);
    }

    @Override
    public Float set(int index, Float element) {
        return elementData.set(index, element);
    }

    @Override
    public void add(int index, Float element) {
        elementData.add(index, element);

    }

    @Override
    public Float remove(int index) {
        return elementData.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return elementData.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return elementData.lastIndexOf(o);
    }

    @Override
    public ListIterator<Float> listIterator() {
        return elementData.listIterator();
    }

    @Override
    public ListIterator<Float> listIterator(int index) {
        return elementData.listIterator(index);
    }

    @Override
    public List<Float> subList(int fromIndex, int toIndex) {
        return elementData.subList(fromIndex, toIndex);
    }

}
