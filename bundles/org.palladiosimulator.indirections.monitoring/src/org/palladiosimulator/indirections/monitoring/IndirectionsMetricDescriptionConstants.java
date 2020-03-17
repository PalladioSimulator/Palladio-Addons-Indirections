package org.palladiosimulator.indirections.monitoring;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.palladiosimulator.metricspec.BaseMetricDescription;
import org.palladiosimulator.metricspec.MetricSetDescription;

public class IndirectionsMetricDescriptionConstants {
    public static final String INDIRECTIONS_METRICSPEC_URI = "platform:/plugin/org.palladiosimulator.indirections.monitoring/model/indirectionMetrics.metricspec";
    private static final Map<?, ?> OPTIONS = Collections.emptyMap();

    public final static BaseMetricDescription DATA_AGE_METRIC;
    public final static MetricSetDescription DATA_AGE_METRIC_TUPLE;

    public final static BaseMetricDescription SIZE_OF_GROUPED_DATE_METRIC;
    public final static MetricSetDescription SIZE_OF_GROUPED_DATE_METRIC_TUPLE;

    public final static BaseMetricDescription DATA_CHANNEL_QUEUE_LENGTH_METRIC;
    public final static MetricSetDescription DATA_CHANNEL_QUEUE_LENGTH_METRIC_TUPLE;
    
    public final static BaseMetricDescription NUMBER_OF_DISCARDED_ELEMENTS_METRIC;
    public final static MetricSetDescription NUMBER_OF_DISCARDED_ELEMENTS_METRIC_TUPLE;
    public final static MetricSetDescription TOTAL_NUMBER_OF_DISCARDED_ELEMENTS_METRIC_TUPLE;

    static {
        final ResourceSet resourceSet = new ResourceSetImpl();
        final Resource resource = resourceSet.createResource(URI.createURI(INDIRECTIONS_METRICSPEC_URI, true));
        try {
            resource.load(OPTIONS);
        } catch (final IOException e) {
            // TODO Auto-generated catch block. Use eclipse error log instead?
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        DATA_AGE_METRIC = (BaseMetricDescription) resource.getEObject("_3OsfYQyNEeqfSKC3_n36pA");
        DATA_AGE_METRIC_TUPLE = (MetricSetDescription) resource.getEObject("_EM6pUQyOEeqfSKC3_n36pA");

        SIZE_OF_GROUPED_DATE_METRIC = (BaseMetricDescription) resource.getEObject("_NMOiMhzrEeqj8qwut4kBiw");
        SIZE_OF_GROUPED_DATE_METRIC_TUPLE = (MetricSetDescription) resource.getEObject("_qVG84RzrEeqj8qwut4kBiw");

        DATA_CHANNEL_QUEUE_LENGTH_METRIC = (BaseMetricDescription) resource.getEObject("_ijKZchCIEeqqi6TqVNRPhw");
        DATA_CHANNEL_QUEUE_LENGTH_METRIC_TUPLE = (MetricSetDescription) resource.getEObject("_fapT4RCJEeqqi6TqVNRPhw");

        NUMBER_OF_DISCARDED_ELEMENTS_METRIC = (BaseMetricDescription) resource.getEObject("_6zV-AloBEeqic-uc8rDY3Q");
        NUMBER_OF_DISCARDED_ELEMENTS_METRIC_TUPLE = (MetricSetDescription) resource.getEObject("_jSXxkVoCEeqic-uc8rDY3Q");
        TOTAL_NUMBER_OF_DISCARDED_ELEMENTS_METRIC_TUPLE = (MetricSetDescription) resource.getEObject("_rVWwkVoCEeqic-uc8rDY3Q");
    }

    /**
     * Private constructor to forbid instantiation.
     */
    private IndirectionsMetricDescriptionConstants() {
    }
}