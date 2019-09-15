package org.palladiosimulator.indirections.util;

import java.util.Map;
import java.util.Map.Entry;

import org.palladiosimulator.pcm.repository.EventGroup;
import org.palladiosimulator.pcm.repository.Parameter;
import org.palladiosimulator.simulizar.simulationevents.PeriodicallyTriggeredSimulationEntity;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public final class IndirectionUtil {
    private IndirectionUtil() {

    }

    public static void validateStackframeStructure(final Map<String, Object> dataMap, final String parameterName) {
        final String parameterCharacterisationPrefix = parameterName + ".";

        for (final Entry<String, Object> entry : dataMap.entrySet()) {
            if (!entry.getKey().startsWith(parameterCharacterisationPrefix)) {
                throw new IllegalArgumentException("Invalid characteristation for data frame: " + entry.getKey()
                        + ", expected characteristations for " + parameterName);
            }
        }
    }

    public static Parameter getOneParameter(final EventGroup eventGroup) {
        return IterableUtil.claimOne(eventGroup.getEventTypes__EventGroup()).getParameter__EventType();
    }

    /**
     * Changes the prefix in the given variable name from the parameter name of the incoming event
     * type to the one of the outgoing event type.
     */
    public static String rewriteVariableNamePrefix(final String variableName, final String incomingParameterName,
            final String outgoingParameterName) {
        if (variableName.startsWith(incomingParameterName)) {
            return outgoingParameterName + variableName.substring(incomingParameterName.length());
        } else {
            throw new AssertionError("Variable '" + variableName + "' does not start with incoming paramete name: "
                    + incomingParameterName);
        }
    }

    public static PeriodicallyTriggeredSimulationEntity triggerPeriodically(SimuComModel model, double firstOccurrence, double delay,
            Runnable taskToRun) {
        
        return new PeriodicallyTriggeredSimulationEntity(model, firstOccurrence, delay) {
            @Override
            protected void triggerInternal() {
                taskToRun.run();
            }
        };
    }
}
