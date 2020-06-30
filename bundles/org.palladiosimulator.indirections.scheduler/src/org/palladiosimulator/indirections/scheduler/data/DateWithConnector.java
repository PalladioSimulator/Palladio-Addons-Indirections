package org.palladiosimulator.indirections.scheduler.data;

import org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public class DateWithConnector<T extends IndirectionDate> {
    public final T date;
    public final DataSourceSinkConnector source;

    public DateWithConnector(final DataSourceSinkConnector source, final T date) {
        this.source = source;
        this.date = date;
    }
}