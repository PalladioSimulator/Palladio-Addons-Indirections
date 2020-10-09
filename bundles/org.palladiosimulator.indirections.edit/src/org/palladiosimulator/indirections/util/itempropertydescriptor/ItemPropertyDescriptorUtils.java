package org.palladiosimulator.indirections.util.itempropertydescriptor;

import java.util.List;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

public final class ItemPropertyDescriptorUtils {

    private ItemPropertyDescriptorUtils() {
        // intentionally left blank
    }

    public static ItemPropertyDescriptorDecorator decorateLastDescriptor(List<IItemPropertyDescriptor> descriptors) {
        if (descriptors.isEmpty()) {
            throw new IllegalArgumentException(
                    "In order to replace a descriptor, there has to be at least one descriptor available.");
        }
        var delegate = descriptors.remove(descriptors.size() - 1);
        var decorator = new ItemPropertyDescriptorDecoratorImpl(delegate);
        descriptors.add(decorator);
        return decorator;
    }

}
