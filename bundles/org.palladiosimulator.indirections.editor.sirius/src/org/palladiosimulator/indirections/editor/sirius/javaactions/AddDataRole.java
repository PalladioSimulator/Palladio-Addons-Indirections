package org.palladiosimulator.indirections.editor.sirius.javaactions;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.palladiosimulator.editors.commons.dialogs.selection.PalladioSelectEObjectDialog;
import org.palladiosimulator.indirections.repository.DataInterface;
import org.palladiosimulator.pcm.core.entity.InterfaceProvidingRequiringEntity;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.Role;

public abstract class AddDataRole<T extends Role> implements IExternalJavaAction {
    
    private static final String ROLE_PARAMETER_NAME = "instance";
    private static final Shell SHELL = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
    private final String namePostExtension;

    public AddDataRole(String namePostExtension) {
        this.namePostExtension = namePostExtension;
    }
    
    protected abstract void setInterface(T role, DataInterface dInterface);
    
    protected abstract Collection<T> getRelevantRoles(InterfaceProvidingRequiringEntity entity);
    
    @Override
    public boolean canExecute(final Collection<? extends EObject> arg0) {
        return true;
    }

    @Override
    public void execute(final Collection<? extends EObject> selection, final Map<String, Object> parameters) {
        @SuppressWarnings("unchecked")
        final var role = (T) parameters.get(ROLE_PARAMETER_NAME);
        final var container = (InterfaceProvidingRequiringEntity)role.eContainer();
        final var selectedInterface = this.getDataInterface(role);
        setInterface(role, selectedInterface);
        role.setEntityName(findRoleName(container, selectedInterface));
    }

    private String findRoleName(final InterfaceProvidingRequiringEntity entity,
            final DataInterface dInterface) {
        final var interfaceName = dInterface.getEntityName() + namePostExtension;
        var roleName = interfaceName;
        for (int i = 1; this.checkExistingNames(entity, roleName); i++) {
            roleName = interfaceName + i;
            if(i == Integer.MAX_VALUE) {
                throw new IllegalStateException("Role Name Extension too big");
            }
        }
        return roleName;
    }

    private boolean checkExistingNames(final InterfaceProvidingRequiringEntity entity, final String interfaceName) {
        return getRelevantRoles(entity).stream()
            .anyMatch(e -> interfaceName.equals(e.getEntityName()));
    }

    private DataInterface getDataInterface(final Role role) {
        final Collection<Object> filter = Arrays.asList(Repository.class, DataInterface.class);
        final Collection<EReference> additionalChildReferences = Collections.emptyList();

        // Creating the dialog
        final PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(SHELL, filter,
                additionalChildReferences, role.eResource().getResourceSet());

        // Setting the needed object type
        dialog.setProvidedService(DataInterface.class);

        dialog.open();

        return (DataInterface) dialog.getResult();
    }
    
}
