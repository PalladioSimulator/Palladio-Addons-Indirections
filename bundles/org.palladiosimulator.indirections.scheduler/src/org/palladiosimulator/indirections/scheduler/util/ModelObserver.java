package org.palladiosimulator.indirections.scheduler.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.palladiosimulator.simulizar.modelobserver.IModelObserver;
import org.palladiosimulator.simulizar.runtimestate.AbstractSimuLizarRuntimeState;

public class ModelObserver implements IModelObserver {
    public static BufferedWriter csvWriter2;
    private static Map<String, Map.Entry<Double, Double>> uuidToCurrentTimeToDelay;

    public static void measureWindowSize(final int windowSize) {
        try {
            csvWriter2.append(Integer.toString(windowSize) + "\n");
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void writeLine(final String line) {
        throw new UnsupportedOperationException();
//        try {
//            csvWriter.append(line + "\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void initialize(final AbstractSimuLizarRuntimeState runtimeState) {
        if (csvWriter2 != null) {
            try {
                csvWriter2.close();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }

        {
            File f = null;
            int counter = 0;
            try {
                while (f == null || f.exists()) {
                    f = new File("C:\\git-diss\\dev-simulizar-dataevents\\" + "Palladio-Addons-Indirections\\examples\\"
                            + "edu.kit.ipd.are.smarthomedata.model\\" + "101_events\\results-window-size-" + (counter++)
                            + ".csv");
                }
                csvWriter2 = new BufferedWriter(new FileWriter(f));
            } catch (final IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    @Override
    public void unregister() {
//        Comparator<Entry<Double, Double>> comparator = Comparator.comparingDouble(it -> it.getKey());
//        try {
//            for (Entry<String, Entry<Double, Double>> entry : uuidToCurrentTimeToDelay.entrySet()) {
//                Entry<Double, Double> timeToDelay = entry.getValue();
//                csvWriter.append(entry.getKey() + "," + timeToDelay.getKey() + "," + timeToDelay.getValue() + "\n");
//            }
//
////            for (Entry<String, Map<Double, Double>> entry : uuidToCurrentTimeToDelay.entrySet()) {
////                Entry<Double, Double> timeToDelay = entry.getValue().entrySet().stream().sorted(comparator).findFirst()
////                        .get();
////                csvWriter.append(entry.getKey() + "," + timeToDelay.getKey() + "," + timeToDelay.getValue() + "\n");
////            }
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

        try {
            csvWriter2.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
