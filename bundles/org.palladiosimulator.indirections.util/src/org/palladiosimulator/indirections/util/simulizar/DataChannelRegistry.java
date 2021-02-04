package org.palladiosimulator.indirections.util.simulizar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.palladiosimulator.commons.eclipseutils.ExtensionHelper;
import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.interfaces.IDataChannelResourceFactory;
import org.palladiosimulator.indirections.repository.DataChannel;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.RepositoryComponentSwitch;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class DataChannelRegistry {
    private static final String ATTRIBUTE_NAME = "dataChannelResourceFactory";
    private static final String EXTENSION_POINT_ID = "org.palladiosimulator.indirections.interfaces.datachannelresourcefactory";

    private static Map<SimuComModel, DataChannelRegistry> registries = new HashMap<>();

    public static DataChannelRegistry getInstanceFor(InterpreterDefaultContext context,
    		RepositoryComponentSwitch.Factory repositoryComponentSwitchFactory) {
        registries.computeIfAbsent(context.getModel(),
                (model) -> new DataChannelRegistry(context, model, repositoryComponentSwitchFactory));

        return registries.get(context.getModel());
    }

    private final InterpreterDefaultContext context;
    private IDataChannelResourceFactory dataChannelResourceFactory;

    private final Map<AssemblyContext, Map<DataChannel, IDataChannelResource>> assemblyContextToDataChannelToDataChannelResource = new HashMap<>();

    private final SimuComModel model;
    private final RepositoryComponentSwitch.Factory repositoryComponentSwitchFactory;

    private DataChannelRegistry(final InterpreterDefaultContext ctx, final SimuComModel myModel,
    		RepositoryComponentSwitch.Factory repositoryComponentSwitchFactory) {
        this.context = ctx;
        this.model = myModel;
        this.repositoryComponentSwitchFactory = repositoryComponentSwitchFactory;
    }

    public IDataChannelResource getOrCreateDataChannelResource(DataChannel dataChannel,
            AssemblyContext assemblyContext) {
        if (this.dataChannelResourceFactory == null) {
            this.initializeDataChannelResourceFactory();
        }

        if (!assemblyContextToDataChannelToDataChannelResource.containsKey(assemblyContext)) {
            assemblyContextToDataChannelToDataChannelResource.put(assemblyContext, new HashMap<>());
        }

        var dataChannelToDataChannelResource = assemblyContextToDataChannelToDataChannelResource.get(assemblyContext);
        if (!dataChannelToDataChannelResource.containsKey(dataChannel)) {
            dataChannelToDataChannelResource.put(dataChannel, this.dataChannelResourceFactory.createDataChannelResource(
                    dataChannel, assemblyContext, context, model, repositoryComponentSwitchFactory));
        }

        return dataChannelToDataChannelResource.get(dataChannel);
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
