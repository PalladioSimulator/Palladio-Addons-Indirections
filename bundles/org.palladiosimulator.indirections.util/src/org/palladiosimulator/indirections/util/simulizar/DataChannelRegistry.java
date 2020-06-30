package org.palladiosimulator.indirections.util.simulizar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.palladiosimulator.commons.eclipseutils.ExtensionHelper;
import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.interfaces.IDataChannelResourceFactory;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class DataChannelRegistry {
    private static final String ATTRIBUTE_NAME = "dataChannelResourceFactory";
    private static final String EXTENSION_POINT_ID = "org.palladiosimulator.indirections.interfaces.datachannelresourcefactory";

    private static Map<SimuComModel, DataChannelRegistry> registries = new HashMap<>();
    public static DataChannelRegistry getInstanceFor(final InterpreterDefaultContext context) {
        registries.computeIfAbsent(context.getModel(), (model) -> new DataChannelRegistry(context, model));

        return registries.get(context.getModel());
    }

    private final InterpreterDefaultContext context;
    private IDataChannelResourceFactory dataChannelResourceFactory;

    private final Map<DataChannel, IDataChannelResource> dataChannelToDataChannelResource = new HashMap<DataChannel, IDataChannelResource>();

    private final SimuComModel model;

    private DataChannelRegistry(final InterpreterDefaultContext ctx, final SimuComModel myModel) {
        this.context = ctx;
        this.model = myModel;
    }

    public IDataChannelResource getOrCreateDataChannelResource(final DataChannel dataChannel) {
        if (this.dataChannelResourceFactory == null) {
            this.initializeDataChannelResourceFactory();
        }

        if (!this.dataChannelToDataChannelResource.containsKey(dataChannel)) {
            this.dataChannelToDataChannelResource.put(dataChannel,
                    this.dataChannelResourceFactory.createDataChannelResource(dataChannel, this.context, this.model));
        }
        return this.dataChannelToDataChannelResource.get(dataChannel);
    }

    private void initializeDataChannelResourceFactory() {
        final List<Object> executableExtensions = ExtensionHelper.getExecutableExtensions(EXTENSION_POINT_ID,
                ATTRIBUTE_NAME);
        this.dataChannelResourceFactory = executableExtensions.stream()
            .map((it) -> (IDataChannelResourceFactory) it)
            .findFirst()
            .orElseThrow(
                    () -> new IllegalStateException("No " + IDataChannelResourceFactory.class.getName() + " found."));
    }

}
