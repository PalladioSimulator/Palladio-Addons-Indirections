package org.palladiosimulator.indirections.simulizar.rdseffswitch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.interfaces.IDataChannelResourceFactory;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

import org.palladiosimulator.commons.eclipseutils.ExtensionHelper;


public class DataChannelRegistry {
    private Map<DataChannel, IDataChannelResource> dataChannelToDataChannelResource = new HashMap<DataChannel, IDataChannelResource>();
    private IDataChannelResourceFactory dataChannelResourceFactory;
	private SimuComModel myModel;
	
	private static Map<InterpreterDefaultContext, DataChannelRegistry> registries = new HashMap<>();
    
	// TODO: really static?
	public static DataChannelRegistry getInstanceFor(InterpreterDefaultContext context) {
		registries.computeIfAbsent(context, (ctx) -> new DataChannelRegistry(ctx.getModel()));
		
		return registries.get(context);
	}
	
    private DataChannelRegistry(final SimuComModel myModel) {
		this.myModel = myModel;
    }
    
    public IDataChannelResource getOrCreateDataChannelResource(final DataChannel dataChannel) {
    	if (dataChannelResourceFactory == null) {
    		initializeDataChannelResourceFactory();
    	}
    	
    	if (!dataChannelToDataChannelResource.containsKey(dataChannel)) {
    		dataChannelToDataChannelResource.put(dataChannel, dataChannelResourceFactory.createDataChannelResource(dataChannel, this.myModel));
    	}
    	return dataChannelToDataChannelResource.get(dataChannel);
    }
    
	private void initializeDataChannelResourceFactory() {
		List<Object> executableExtensions = ExtensionHelper.getExecutableExtensions("org.palladiosimulator.simulizar.indirection.interfaces.datachannelresourcefactory",
		    		"dataChannelResourceFactoy");
		dataChannelResourceFactory = executableExtensions.stream()
			.map((it) -> (IDataChannelResourceFactory) it)
			.findFirst()
			.orElseThrow(() -> new IllegalStateException("No  " + IDataChannelResourceFactory.class.getName() + " found.")); 
	}

}
