package org.palladiosimulator.indirections.editor.sirius.javaactions;

import java.util.Collection;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.repository.DataInterface;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.pcm.core.entity.InterfaceProvidingRequiringEntity;

public class AddDataSinkRole extends AddDataRole<DataSinkRole> {

    public AddDataSinkRole() {
        super("DataSinkRole");
    }

    @Override
    protected void setInterface(DataSinkRole role, DataInterface dInterface) {
        role.setDataInterface(dInterface);
    }

    @Override
    protected Collection<DataSinkRole> getRelevantRoles(InterfaceProvidingRequiringEntity entity) {
        return entity.getProvidedRoles_InterfaceProvidingEntity()
            .stream()
            .filter(DataSinkRole.class::isInstance)
            .map(DataSinkRole.class::cast)
            .collect(Collectors.toList());
    }

}
