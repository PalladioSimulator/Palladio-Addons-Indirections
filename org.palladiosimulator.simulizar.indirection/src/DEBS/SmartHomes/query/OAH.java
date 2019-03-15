package DEBS.SmartHomes.query;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;
import DEBS.SmartHomes.data.In;
import DEBS.SmartHomes.data.Out3;

public class OAH implements Consumer<In>, Supplier<Out3> {

    private final Map<Long, Float> houses;

    public float outliers() {
        final Collection<Float> values = houses.values();
        Float[] medians = new Float[values.size()];
        Arrays.parallelSort(values.toArray(medians));

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
    public void accept(In t) {
        houses.put(t.getHouse_id(), t.getValue());

    }

    public OAH(Map<Long, Float> houses) {
        this.houses = houses;
    }

    @Override
    public Out3 get() {
        // TODO Auto-generated method stub
        return null;
    }

}
