package org.palladiosimulator.indirections.simulizar.rdseffswitch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.palladiosimulator.simulizar.di.component.core.SimuLizarRuntimeComponent;
import org.palladiosimulator.simulizar.di.extension.ExtensionComponent;
import org.palladiosimulator.simulizar.scopes.RuntimeExtensionScope;

import dagger.Component;

@Component(dependencies = SimuLizarRuntimeComponent.class)
@RuntimeExtensionScope
public interface IndirectionsExtensionComponent extends ExtensionComponent {
    IndirectionsRDSeffSwitch.Factory rdseffExtensionFactory();

    @Component.Factory
    public static interface Factory extends ExtensionComponent.Factory {
    	IndirectionsExtensionComponent create(SimuLizarRuntimeComponent runtimeComponent);
    }

    public static class EclipseFactory implements IExecutableExtensionFactory {
        @Override
        public Object create() throws CoreException {
            //return DaggerIndirectionsExtensionComponent.factory();
            return null;
        }

    }
	
	/*
	 * public static IndirectionsRDSeffSwitchFactory factory = null;
	 * 
	 * @Override public void initialize(SimuLizarCoreComponent simuLizarComponent) {
	 * factory = DaggerIndirectionsExtension_IndirectionsComponent.builder()
	 * .simuLizarCoreComponent(simuLizarComponent) .build()
	 * .indirectionsRDSeffSwitchFactory(); }
	 * 
	 * @Override public void destroy() { factory = null; }
	 * 
	 * @Component(dependencies = SimuLizarCoreComponent.class, modules =
	 * IndirectionsModule.class) public static interface IndirectionsComponent {
	 * IndirectionsRDSeffSwitchFactory indirectionsRDSeffSwitchFactory(); }
	 * 
	 * @Module public static interface IndirectionsModule {
	 * 
	 * @Provides static IndirectionsRDSeffSwitch
	 * provideRDSeffSwitch(IndirectionsRDSeffSwitch rdSeffSwitch) { return
	 * rdSeffSwitch; } }
	 * 
	 * public static class LegacyIndirectionsRDSeffSwitchFactory extends
	 * AbstractRDSeffSwitchFactory {
	 * 
	 * @Override protected Switch<Object>
	 * createRDSeffSwitch(InterpreterDefaultContext context,
	 * SimulatedBasicComponentInstance basicComponentInstance,
	 * ExplicitDispatchComposedSwitch<Object> parentSwitch) {
	 * 
	 * return IndirectionsExtension.factory.create(context, parentSwitch); }
	 * 
	 * }
	 */
}
