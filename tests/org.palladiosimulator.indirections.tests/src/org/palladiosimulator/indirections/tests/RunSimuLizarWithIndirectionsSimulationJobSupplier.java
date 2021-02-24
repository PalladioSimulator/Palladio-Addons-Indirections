package org.palladiosimulator.indirections.tests;

import java.util.Collections;

import org.eclipse.ui.IFileEditorInput;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.palladiosimulator.indirections.simulizar.rdseffswitch.DaggerIndirectionsExtensionComponent;
import org.palladiosimulator.simulizar.di.component.dependency.SimEngineComponent.Factory;
import org.palladiosimulator.simulizar.di.modules.component.extensions.ExtensionComponentsModule;
import org.palladiosimulator.simulizar.di.modules.stateless.core.RootComponentFactoriesModule;
import org.palladiosimulator.simulizar.di.modules.stateless.mdsd.MDSDBlackboardProvidingModule;
import org.palladiosimulator.simulizar.test.commons.di.components.DaggerTestSimEngineComponent;
import org.palladiosimulator.simulizar.test.commons.di.components.DaggerTestSimuLizarRootComponent;
import org.palladiosimulator.simulizar.test.commons.util.RunSimuLizarSimulationJobSupplier;

import de.uka.ipd.sdq.workflow.jobs.IJob;

public class RunSimuLizarWithIndirectionsSimulationJobSupplier extends RunSimuLizarSimulationJobSupplier {

    public RunSimuLizarWithIndirectionsSimulationJobSupplier(ExtensionContext context) {
        super(context);
    }

    @Override
    public IJob get() {
        var component = DaggerTestSimuLizarRootComponent.factory()
            .create(configuration, 
                    new RootComponentFactoriesModule() {
                        @Override
                        public Factory providesSimEngineComponentFactory() {
                            return DaggerTestSimEngineComponent.factory();
                        }
                    }, 
                    new ExtensionComponentsModule(Collections.singleton(DaggerIndirectionsExtensionComponent.factory()), Collections.emptySet()), 
                    new MDSDBlackboardProvidingModule(blackboard));

        return component.runtimeComponentFactory().create().runtimeJob();
    }

}
