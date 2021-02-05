package org.palladiosimulator.indirections.scheduler.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.palladiosimulator.commons.eclipseutils.ExtensionHelper;
import org.palladiosimulator.indirections.repository.DataChannel;
import org.palladiosimulator.indirections.scheduler.IDataChannelResource;
import org.palladiosimulator.indirections.scheduler.IDataChannelResourceFactory;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.di.component.interfaces.SimulatedThreadComponent;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext.MainContext;
import org.palladiosimulator.simulizar.runtimestate.RuntimeStateEntityManager;
import org.palladiosimulator.simulizar.scopes.RuntimeExtensionScope;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

@RuntimeExtensionScope
public class DataChannelResourceRegistry implements RuntimeStateEntityManager {
    private static final String ATTRIBUTE_NAME = "dataChannelResourceFactory";
    private static final String EXTENSION_POINT_ID = "org.palladiosimulator.indirections.interfaces.datachannelresourcefactory";
    private SimulatedThreadComponent.Factory simulatedThreadComponentFactory;

    @Inject
    public DataChannelResourceRegistry(@MainContext InterpreterDefaultContext ctx, final SimuComModel myModel,
            SimulatedThreadComponent.Factory simulatedThreadComponentFactory) {
        this.context = ctx;
        this.model = myModel;
        this.simulatedThreadComponentFactory = simulatedThreadComponentFactory;
    }

    private final InterpreterDefaultContext context;
    private IDataChannelResourceFactory dataChannelResourceFactory;

    private final Map<AssemblyContext, Map<DataChannel, IDataChannelResource>> assemblyContextToDataChannelToDataChannelResource = new HashMap<>();

    private final SimuComModel model;

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
            dataChannelToDataChannelResource.put(dataChannel,
                    this.dataChannelResourceFactory.createDataChannelResource(dataChannel, assemblyContext, context,
                            model, simulatedThreadComponentFactory, this));
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