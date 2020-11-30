package org.palladiosimulator.indirections.simulizar.rdseffswitch;

import org.eclipse.emf.ecore.util.Switch;
import org.palladiosimulator.simulizar.SimuLizarCoreComponent;
import org.palladiosimulator.simulizar.extension.SimuLizarExtension;
import org.palladiosimulator.simulizar.interpreter.AbstractRDSeffSwitchFactory;
import org.palladiosimulator.simulizar.interpreter.ExplicitDispatchComposedSwitch;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.runtimestate.SimulatedBasicComponentInstance;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

public class IndirectionsExtension implements SimuLizarExtension {
    public static IndirectionsRDSeffSwitchFactory factory = null;

    @Override
    public void initialize(SimuLizarCoreComponent simuLizarComponent) {
        factory = DaggerIndirectionsExtension_IndirectionsComponent.builder()
            .simuLizarCoreComponent(simuLizarComponent)
            .build()
            .indirectionsRDSeffSwitchFactory();
    }

    @Override
    public void destroy() {
        factory = null;
    }

    @Component(dependencies = SimuLizarCoreComponent.class, modules = IndirectionsModule.class)
    public static interface IndirectionsComponent {
        IndirectionsRDSeffSwitchFactory indirectionsRDSeffSwitchFactory();
    }

    @Module
    public static interface IndirectionsModule {
        @Provides
        static IndirectionsRDSeffSwitch provideRDSeffSwitch(IndirectionsRDSeffSwitch rdSeffSwitch) {
            return rdSeffSwitch;
        }
    }

    public static class LegacyIndirectionsRDSeffSwitchFactory extends AbstractRDSeffSwitchFactory {

        @Override
        protected Switch<Object> createRDSeffSwitch(InterpreterDefaultContext context,
                SimulatedBasicComponentInstance basicComponentInstance,
                ExplicitDispatchComposedSwitch<Object> parentSwitch) {

            return IndirectionsExtension.factory.create(context, parentSwitch);
        }

    }
}
