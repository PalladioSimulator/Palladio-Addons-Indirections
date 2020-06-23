package org.palladiosimulator.indirections.scheduler.data.dev;

import java.util.List;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public interface GroupingIndirectionDate<T extends IndirectionDate> extends IndirectionDate {
    public List<T> getDataInGroup();
}
