package org.palladiosimulator.indirections.scheduler.data;

import java.util.List;
import java.util.Map;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public class WindowingIndirectionDate implements IndirectionDate {
    private final List<IndirectionDate> dataInWindow;

    public WindowingIndirectionDate(List<IndirectionDate> dataInWindow) {
        this.dataInWindow = dataInWindow;
    }

    @Override
    public Map<String, Object> getData() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Double getTime() {
        throw new UnsupportedOperationException();
    }

}
