package org.palladiosimulator.indirections.simulizar.rdseffswitch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.palladiosimulator.indirections.scheduler.util.DataChannelResourceRegistry;
import org.palladiosimulator.simulizar.di.component.core.SimuLizarRuntimeComponent;
import org.palladiosimulator.simulizar.di.component.dependency.SimuComFrameworkComponent;
import org.palladiosimulator.simulizar.di.extension.ExtensionComponent;
import org.palladiosimulator.simulizar.scopes.RuntimeExtensionScope;

import dagger.Component;

@Component(dependencies = { //
        SimuLizarRuntimeComponent.class, //
        SimuComFrameworkComponent.class })
@RuntimeExtensionScope
public interface IndirectionsExtensionComponent extends ExtensionComponent {
    IndirectionsRDSeffSwitch.Factory rdseffExtensionFactory();

    DataChannelResourceRegistry dataChannelResourceRegistry();

    @Component.Factory
    public static interface Factory extends ExtensionComponent.Factory {
        IndirectionsExtensionComponent create(SimuLizarRuntimeComponent runtimeComponent,
                SimuComFrameworkComponent simucomComponent);
    }

    public static class EclipseFactory implements IExecutableExtensionFactory {
        @Override
        public Object create() throws CoreException {
            return DaggerIndirectionsExtensionComponent.factory();
        }

    }
}
