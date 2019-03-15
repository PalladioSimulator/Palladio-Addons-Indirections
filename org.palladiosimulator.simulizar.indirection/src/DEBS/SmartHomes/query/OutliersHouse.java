package DEBS.SmartHomes.query;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;
import DEBS.SmartHomes.data.In;
import DEBS.SmartHomes.data.Out3;
import DEBS.SmartHomes.data.sructure.CircularArray;

public class OutliersHouse implements Consumer<In>, Supplier<Out3> {

    private final long house_id;
    private final int window_size;
    private final int window_shift;
    private final Map<Long, CircularArray> plugs;
    private int add;
    private float outliers;



    public OutliersHouse(final long house_id, final int window_size, final int window_shift) {
        this.house_id = house_id;
        plugs = new HashMap<>();
        this.window_size = window_size;
        this.window_shift = window_shift;
        add = 0;
    }

    @Override
    public void accept(final In in) {
        if (house_id != -1 && house_id != in.getHouse_id()) {
            return;
        }

        final Long plugId = Long.valueOf(in.getPlug_id());
        final float value = in.getValue();
        if (plugs.containsKey(plugId)) {
            plugs.get(plugId).add(value);
        } else {
            plugs.put(plugId, new CircularArray(window_size, value));
        }
        add++;
    }

    public float[] medians() {
        final Collection<CircularArray> values = plugs.values();
        float[] medians = new float[values.size()];
        int addPointer = 0;
        for (CircularArray array : values) {
            medians[addPointer] = array.median();
        }
        Arrays.parallelSort(medians);
        return medians;
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


    @Override
    public Out3 get() {
        if (add >= window_shift) {
            outliers = outliers();
            add = 0;
        }
        return null;
    }

}
