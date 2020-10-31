package org.palladiosimulator.indirections.editor.sirius.javaactions;

import java.util.Collection;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.repository.DataInterface;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.pcm.core.entity.InterfaceProvidingRequiringEntity;

public class AddDataSourceRole extends AddDataRole<DataSourceRole> {

    public AddDataSourceRole() {
        super("DataSourceRole");
    }

    @Override
    protected void setInterface(DataSourceRole role, DataInterface dInterface) {
        role.setDataInterface(dInterface);
    }

    @Override
    protected Collection<DataSourceRole> getRelevantRoles(InterfaceProvidingRequiringEntity entity) {
        return entity.getRequiredRoles_InterfaceRequiringEntity()
            .stream()
            .filter(DataSourceRole.class::isInstance)
            .map(DataSourceRole.class::cast)
            .collect(Collectors.toList());
    }

}
