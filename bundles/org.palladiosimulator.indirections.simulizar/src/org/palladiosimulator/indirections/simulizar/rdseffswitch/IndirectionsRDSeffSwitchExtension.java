package org.palladiosimulator.indirections.simulizar.rdseffswitch;

import org.palladiosimulator.simulizar.SimuLizarSimulationComponent;
import org.palladiosimulator.simulizar.extension.InterpreterSwitchExtensionRegistry;
import org.palladiosimulator.simulizar.extension.facets.InterpreterExtension;
import org.palladiosimulator.simulizar.scopes.ExtensionScope;

import dagger.Component;

@Component(dependencies = SimuLizarSimulationComponent.class)
@ExtensionScope
public abstract class IndirectionsRDSeffSwitchExtension implements InterpreterExtension {
    abstract InterpreterSwitchExtensionRegistry extensionRegistry();
    abstract IndirectionsRDSeffSwitchFactory switchFactory();
    
    @Override
    public void preInitialize() {
        extensionRegistry().registerRDSeffSwitchFactory(switchFactory());
    }
    
    @Component.Factory
    interface Factory extends InterpreterExtension.Factory {
        IndirectionsRDSeffSwitchExtension create(SimuLizarSimulationComponent component);
    }
}
