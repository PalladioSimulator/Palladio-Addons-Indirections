package org.palladiosimulator.indirections.scheduler;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.interfaces.IDataChannelResourceFactory;
import org.palladiosimulator.indirections.repository.DataChannel;
import org.palladiosimulator.indirections.repository.JavaClassDataChannel;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.di.component.interfaces.SimulatedThreadComponent;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class DataChannelResourceFactory implements IDataChannelResourceFactory {
    @SuppressWarnings("unchecked")
    @Override
    public IDataChannelResource createDataChannelResource(DataChannel dataChannel, AssemblyContext assemblyContext,
            InterpreterDefaultContext context, SchedulerModel model,
            SimulatedThreadComponent.Factory simulatedThreadComponentFactory) {

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
            throw new PCMModelInterpreterException(
                    "Could not find realizing class " + fqn + " for " + javaClassDataChannel, e);
        }

        // public AbstractSimDataChannelResource(
        // DataChannel dataChannel,
        // AssemblyContext assemblyContext,
        // InterpreterDefaultContext mainContext,
        // SchedulerModel model,
        // SimulatedThreadComponent.Factory simulatedThreadComponentFactory)
        Constructor<IDataChannelResource> constructor;
        try {
            constructor = clazz.getDeclaredConstructor(//
                    JavaClassDataChannel.class, //
                    AssemblyContext.class, //
                    InterpreterDefaultContext.class, //
                    SchedulerModel.class, //
                    SimulatedThreadComponent.Factory.class);
            final IDataChannelResource instance = constructor.newInstance(javaClassDataChannel, assemblyContext,
                    context, model, simulatedThreadComponentFactory);
            return instance;
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            throw new PCMModelInterpreterException(
                    "Could not create instance of class " + fqn + " for " + javaClassDataChannel, e);
        }

    }

}