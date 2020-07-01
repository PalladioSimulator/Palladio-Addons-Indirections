package org.palladiosimulator.indirections.scheduler.data;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public class TaggedDate<T extends IndirectionDate, TAG> {
    public final T date;
    public final TAG tag;

    public TaggedDate(final TAG tag, final T date) {
        this.tag = tag;
        this.date = date;
    }
}
