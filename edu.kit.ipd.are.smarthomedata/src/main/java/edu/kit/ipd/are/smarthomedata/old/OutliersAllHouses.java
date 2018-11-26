package edu.kit.ipd.are.smarthomedata.old;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.function.Consumer;

import edu.kit.ipd.are.smarthomedata.dto.SmartMeterReading;

/**
 * Accepts values for all houses and emits a median if the window shift is reached.
 * The first value is emited after the initial window size has been reached.
 * 
 * Window size and shift are given in seconds.
 * 
 * @author Dominik Werle
 *
 */
public class OutliersAllHouses implements Consumer<SmartMeterReading> {
    private final Map<Long, Float> houses;
	private Consumer<Double> callback;

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
    public void accept(SmartMeterReading t) {
        houses.put(t.house_id, t.value);
    }

    public OutliersAllHouses(Map<Long, Float> houses, Consumer<Double> callback) {
        this.houses = houses;
        this.callback = callback;
    }
}
