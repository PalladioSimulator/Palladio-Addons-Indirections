package org.palladiosimulator.indirections.scheduler.data;

import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public class DataWithSource<T extends IndirectionDate> {
    public final DataChannelSourceConnector source;
    public final T date;

    public DataWithSource(DataChannelSourceConnector source, T date) {
        super();
        this.source = source;
        this.date = date;
    }
}