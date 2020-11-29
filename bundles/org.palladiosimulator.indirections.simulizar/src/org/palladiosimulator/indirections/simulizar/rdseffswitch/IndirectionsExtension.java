package org.palladiosimulator.indirections.simulizar.rdseffswitch;

import java.util.Set;

import org.palladiosimulator.simulizar.extension.AbstractSimuLizarExtension;
import org.palladiosimulator.simulizar.extension.SimuLizarExtension;

public class IndirectionsExtension extends AbstractSimuLizarExtension {
    
    @Override
    public Set<org.palladiosimulator.simulizar.extension.facets.InterpreterExtension.Factory> getInterpreterExtensions() {
        return Set.of(DaggerIndirectionsRDSeffSwitchExtension.factory());
    }

    
    public static class Factory implements SimuLizarExtension.Factory<IndirectionsExtension> {
        @Override
        public IndirectionsExtension create() {
            return new IndirectionsExtension();
        }
    }
}
