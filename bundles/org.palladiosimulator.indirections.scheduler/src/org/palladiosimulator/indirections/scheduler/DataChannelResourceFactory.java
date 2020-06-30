package org.palladiosimulator.indirections.scheduler;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.interfaces.IDataChannelResourceFactory;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.system.JavaClassDataChannel;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class DataChannelResourceFactory implements IDataChannelResourceFactory {
    @SuppressWarnings("unchecked")
    @Override
    public IDataChannelResource createDataChannelResource(final DataChannel dataChannel,
            final InterpreterDefaultContext context, final SchedulerModel model) {

        if (!(dataChannel instanceof JavaClassDataChannel)) {
            throw new PCMModelInterpreterException("Currently only " + JavaClassDataChannel.class
                    + " data channels are supported. Got: " + dataChannel);
        }

        final var javaClassDataChannel = (JavaClassDataChannel) dataChannel;

        final var fqn = javaClassDataChannel.getRealizingClassFqn();

        // might not work if class is not in current plugin.
        Class<IDataChannelResource> clazz;
        try {
            clazz = (Class<IDataChannelResource>) this.getClass()
                .getClassLoader()
                .loadClass(fqn);
        } catch (final ClassNotFoundException e) {
            throw new PCMModelInterpreterException("Could not find realizing class " + fqn + " for " + dataChannel, e);
        }

        // AbstractSimDataChannelResource(final DataChannel dataChannel, final
        // InterpreterDefaultContext context, final SchedulerModel model)
        Constructor<IDataChannelResource> constructor;
        try {
            constructor = clazz.getDeclaredConstructor(DataChannel.class, InterpreterDefaultContext.class,
                    SchedulerModel.class);
            final IDataChannelResource instance = constructor.newInstance(dataChannel, context, model);
            return instance;
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            throw new PCMModelInterpreterException("Could not create instance of class " + fqn + " for " + dataChannel,
                    e);
        }

    }

}