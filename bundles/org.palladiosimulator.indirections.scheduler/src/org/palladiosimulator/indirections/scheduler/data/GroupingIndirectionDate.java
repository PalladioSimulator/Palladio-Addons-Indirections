package org.palladiosimulator.indirections.scheduler.data;

import java.util.List;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public interface GroupingIndirectionDate extends IndirectionDate {
    public List<IndirectionDate> getDataInGroup();
}
