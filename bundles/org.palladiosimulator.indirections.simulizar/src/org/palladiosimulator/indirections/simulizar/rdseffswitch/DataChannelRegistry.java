package org.palladiosimulator.indirections.simulizar.rdseffswitch;

import java.util.HashMap;
import java.util.Map;

import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.interfaces.IDataChannelResourceFactory;
import org.palladiosimulator.indirections.scheduler.DataChannelResourceFactory;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class DataChannelRegistry {
    private final Map<DataChannel, IDataChannelResource> dataChannelToDataChannelResource = new HashMap<DataChannel, IDataChannelResource>();
    private IDataChannelResourceFactory dataChannelResourceFactory;
    private final SimuComModel myModel;

    private static Map<InterpreterDefaultContext, DataChannelRegistry> registries = new HashMap<>();

    public static DataChannelRegistry getInstanceFor(final InterpreterDefaultContext context) {
        registries.computeIfAbsent(context, (ctx) -> new DataChannelRegistry(ctx.getModel()));

        return registries.get(context);
    }

    private DataChannelRegistry(final SimuComModel myModel) {
        this.myModel = myModel;
    }

    public IDataChannelResource getOrCreateDataChannelResource(final DataChannel dataChannel) {
        this.createDataChannelResourceFactoryIfAbsent();

        if (!this.dataChannelToDataChannelResource.containsKey(dataChannel)) {
            this.dataChannelToDataChannelResource.put(dataChannel,
                    this.dataChannelResourceFactory.createDataChannelResource(dataChannel, this.myModel));
        }
        return this.dataChannelToDataChannelResource.get(dataChannel);
    }

    private void createDataChannelResourceFactoryIfAbsent() {
        if (this.dataChannelResourceFactory == null) {
            this.dataChannelResourceFactory = new DataChannelResourceFactory();
        }
    }

}
