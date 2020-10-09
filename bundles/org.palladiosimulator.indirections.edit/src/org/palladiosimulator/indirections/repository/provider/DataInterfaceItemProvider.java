package org.palladiosimulator.indirections.repository.provider;

import java.util.Optional;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.palladiosimulator.indirections.repository.DataInterface;

public class DataInterfaceItemProvider extends DataInterfaceItemProviderGen {

    /**
     * {@inheritDoc}
     */
    public DataInterfaceItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getText(Object object) {
        if (object instanceof DataInterface) {
            var dataInterface = (DataInterface) object;
            var typeName = getString("_UI_DataInterface_type");
            var entityName = Optional.ofNullable(dataInterface.getEntityName())
                .map(name -> " " + name)
                .orElse("");
            var entityId = Optional.ofNullable(dataInterface.getId())
                .map(id -> " (" + id + ")")
                .orElse("");
            return String.format("%s%s%s", typeName, entityName, entityId);
        }
        return super.getText(object);
    }

}
