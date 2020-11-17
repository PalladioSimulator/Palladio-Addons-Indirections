package org.palladiosimulator.indirections.simulizar.rdseffswitch;

import org.eclipse.emf.ecore.util.Switch;
import org.palladiosimulator.simulizar.interpreter.ExplicitDispatchComposedSwitch;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.RepositoryComponentSwitchFactory;
import org.palladiosimulator.simulizar.runtimestate.SimulatedBasicComponentInstance;

public class IndirectionsAwareRDSeffSwitchFactory
        extends org.palladiosimulator.simulizar.interpreter.AbstractRDSeffSwitchFactory {

    @Override
    protected Switch<Object> createRDSeffSwitch(final InterpreterDefaultContext context,
            final SimulatedBasicComponentInstance basicComponentInstance,
            final ExplicitDispatchComposedSwitch<Object> parentSwitch,
            final RepositoryComponentSwitchFactory repositoryComponentSwitchFactory) {

        return new IndirectionsAwareRDSeffSwitch(context, basicComponentInstance, parentSwitch, repositoryComponentSwitchFactory);
    }

}
