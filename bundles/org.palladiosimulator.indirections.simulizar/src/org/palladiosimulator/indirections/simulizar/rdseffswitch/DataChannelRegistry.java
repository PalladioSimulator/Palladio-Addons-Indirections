package org.palladiosimulator.indirections.simulizar.rdseffswitch;

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
    private static final String DATA_CHANNEL_RESOURCE_FACTORY_EXTENSION_POINT_ID = "org.palladiosimulator.indirections.interfaces.datachannelresourcefactory";
    private static final String DATA_CHANNEL_RESOURCE_FACTORY_ATTRIBUTE_NAME = "dataChannelResourceFactory";

    private final Map<DataChannel, IDataChannelResource> dataChannelToDataChannelResource = new HashMap<DataChannel, IDataChannelResource>();
    private IDataChannelResourceFactory dataChannelResourceFactory;
    private final SimuComModel myModel;

    private static Map<InterpreterDefaultContext, DataChannelRegistry> registries = new HashMap<>();

    // TODO: really static?
    public static DataChannelRegistry getInstanceFor(final InterpreterDefaultContext context) {
        registries.computeIfAbsent(context, (ctx) -> new DataChannelRegistry(ctx.getModel()));

        return registries.get(context);
    }

    private DataChannelRegistry(final SimuComModel myModel) {
        this.myModel = myModel;
    }

    public IDataChannelResource getOrCreateDataChannelResource(final DataChannel dataChannel) {
        if (this.dataChannelResourceFactory == null) {
            this.initializeDataChannelResourceFactory();
        }

        if (!this.dataChannelToDataChannelResource.containsKey(dataChannel)) {
            this.dataChannelToDataChannelResource.put(dataChannel,
                    this.dataChannelResourceFactory.createDataChannelResource(dataChannel, this.myModel));
        }
        return this.dataChannelToDataChannelResource.get(dataChannel);
    }

    private void initializeDataChannelResourceFactory() {
        final List<Object> executableExtensions = ExtensionHelper.getExecutableExtensions(
                DATA_CHANNEL_RESOURCE_FACTORY_EXTENSION_POINT_ID, DATA_CHANNEL_RESOURCE_FACTORY_ATTRIBUTE_NAME);
        this.dataChannelResourceFactory = executableExtensions.stream().map((it) -> (IDataChannelResourceFactory) it)
                .findFirst().orElseThrow(() -> new IllegalStateException(
                        "No " + IDataChannelResourceFactory.class.getName() + " found."));
    }

}
