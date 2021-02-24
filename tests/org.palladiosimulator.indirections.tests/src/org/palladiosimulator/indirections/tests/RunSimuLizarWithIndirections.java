package org.palladiosimulator.indirections.tests;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.palladiosimulator.simulizar.test.commons.annotation.RunSimulationJob;
import org.palladiosimulator.simulizar.test.commons.annotation.SimuLizarTest;
import org.palladiosimulator.simulizar.test.commons.annotation.SimulationConfig;
import org.palladiosimulator.simulizar.test.commons.annotation.SimulationJobSupplier;

@Retention(RUNTIME)
@Target(METHOD)
@SimuLizarTest
@SimulationConfig
@SimulationJobSupplier(RunSimuLizarWithIndirectionsSimulationJobSupplier.class)
@RunSimulationJob
public @interface RunSimuLizarWithIndirections {

}
