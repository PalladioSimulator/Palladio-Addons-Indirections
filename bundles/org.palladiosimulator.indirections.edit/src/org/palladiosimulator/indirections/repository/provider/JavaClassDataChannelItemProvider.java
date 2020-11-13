package org.palladiosimulator.indirections.repository.provider;

import java.util.Optional;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.palladiosimulator.indirections.repository.JavaClassDataChannel;

public class JavaClassDataChannelItemProvider extends JavaClassDataChannelItemProviderGen {

    /**
     * {@inheritDoc}
     */
    public JavaClassDataChannelItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getText(Object object) {
        if (object instanceof JavaClassDataChannel) {
            var dataChannel = (JavaClassDataChannel)object;
            var name = Optional.ofNullable(dataChannel.getEntityName()).orElse("");
            var id = Optional.ofNullable(dataChannel.getId()).orElse("");
            var type = getString("_UI_JavaClassDataChannel_type");
            return String.format("%s %s (%S)", type, name, id);
        }
        return super.getText(object);
    }

}
