package org.palladiosimulator.indirections.tests;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import org.palladiosimulator.edp2.impl.RepositoryManager;
import org.palladiosimulator.edp2.models.Repository.Repository;
import org.palladiosimulator.edp2.repository.local.LocalDirectoryRepositoryHelper;
import org.palladiosimulator.pcm.allocation.util.AllocationResourceFactoryImpl;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.pcm.repository.util.RepositoryResourceFactoryImpl;
import org.palladiosimulator.pcm.resourceenvironment.util.ResourceenvironmentResourceFactoryImpl;
import org.palladiosimulator.pcm.resourcetype.ResourcetypePackage;
import org.palladiosimulator.pcm.resourcetype.util.ResourcetypeResourceFactoryImpl;
import org.palladiosimulator.pcm.system.util.SystemResourceFactoryImpl;
import org.palladiosimulator.pcm.usagemodel.util.UsagemodelResourceFactoryImpl;
import org.palladiosimulator.simulizar.launcher.SimulizarConstants;
import org.palladiosimulator.simulizar.runconfig.SimuLizarWorkflowConfiguration;

import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * Base class for tests that set up a SimuLizar run configuration and then execute it.
 * 
 * TODO: this is partially taken from
 * {@code org.palladiosimulator.simulizar.tests.SimulizarRunConfigTest}. Ideally,
 * SimulizarRunConfigTest should be changed so it can fulfill this role.
 * 
 * @author Dominik Werle
 */
public abstract class SimuLizarRunConfigTestBase {
    private static final String REPOSITORY_EXTENSION = "repository";
    private static final String RESOURCE_ENVIRONMENT_EXTENSION = "resourceenvironment";
    private static final String SYSTEM_EXTENSION = "system";
    private static final String ALLOCATION_EXTENSION = "allocation";
    private static final String RESOURCETYPE_EXTENSION = "resourcetype";
    private static final String USAGEMODEL_EXTENSION = "usagemodel";
    private static final String MONITORREPOSITORY_EXTENSION = "monitorrepository";

    private static final String PALLADIO_RESOURCETYPES_PATHMAP = "pathmap://PCM_MODELS/Palladio.resourcetype";
    private static final String PALLADIO_RESOURCETYPES_PATHMAP_TARGET = "platform:/plugin/org.palladiosimulator.pcm.resources/defaultModels/Palladio.resourcetype";
    private static final String PRIMITIVE_TYPES_REPO_PATHMAP = "pathmap://PCM_MODELS/PrimitiveTypes.repository";
    private static final String PRIMITIVE_TYPES_REPO_PATHMAP_TARGET = "platform:/plugin/org.palladiosimulator.pcm.resources/defaultModels/PrimitiveTypes.repository";

    private SimuLizarWorkflowConfiguration simulizarConfiguration;
    private SequentialBlackboardInteractingJob<MDSDBlackboard> simulizarJob;

    private Repository repo = null;

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @BeforeClass
    public static void setUpBeforeClass() {
        Registry.INSTANCE.put(RepositoryPackage.eNS_URI, RepositoryPackage.eINSTANCE);
        Registry.INSTANCE.put(ResourcetypePackage.eNS_URI, ResourcetypePackage.eINSTANCE);
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(REPOSITORY_EXTENSION,
                new RepositoryResourceFactoryImpl());
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(RESOURCE_ENVIRONMENT_EXTENSION,
                new ResourceenvironmentResourceFactoryImpl());
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(SYSTEM_EXTENSION,
                new SystemResourceFactoryImpl());
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(ALLOCATION_EXTENSION,
                new AllocationResourceFactoryImpl());
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(RESOURCETYPE_EXTENSION,
                new ResourcetypeResourceFactoryImpl());
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(USAGEMODEL_EXTENSION,
                new UsagemodelResourceFactoryImpl());

        final Map<URI, URI> uriMap = URIConverter.URI_MAP;
        uriMap.put(URI.createURI(PALLADIO_RESOURCETYPES_PATHMAP), URI.createURI(PALLADIO_RESOURCETYPES_PATHMAP_TARGET));
        uriMap.put(URI.createURI(PRIMITIVE_TYPES_REPO_PATHMAP), URI.createURI(PRIMITIVE_TYPES_REPO_PATHMAP_TARGET));
    }

    @Before
    public void setUp() throws IOException {
        this.repo = LocalDirectoryRepositoryHelper
                .initializeLocalDirectoryRepository(this.tempFolder.newFolder("testRepo"));
        RepositoryManager.addRepository(RepositoryManager.getCentralRepository(), this.repo);

        final Map<String, Object> properties = createSimulationProperties();

        this.simulizarConfiguration = new SimuLizarWorkflowConfiguration(properties);
        this.simulizarConfiguration.setMonitorRepositoryFile(SimulizarConstants.DEFAULT_MONITOR_REPOSITORY_FILE);
        this.simulizarConfiguration
                .setServiceLevelObjectivesFile(SimulizarConstants.DEFAULT_SERVICELEVELOBJECTIVE_FILE);
        this.simulizarConfiguration.setUsageEvolutionFile(SimulizarConstants.DEFAULT_USAGEEVOLUTION_FILE);
        this.simulizarConfiguration.setSimuComConfiguration(new SimuComConfig(properties, false));

        final MDSDBlackboard blackboard = new MDSDBlackboard();
        this.simulizarJob = new MinimalPCMInterpreterRootCompositeJob(this.simulizarConfiguration, blackboard);
    }

    @After
    public void tearDown() {
        RepositoryManager.removeRepository(RepositoryManager.getCentralRepository(), this.repo);
    }

    public SimuLizarWorkflowConfiguration getSimulizarConfiguration() {
        return simulizarConfiguration;
    }

    private void setModelIfApplicable(Path path) {
        List<String> allocationFiles = simulizarConfiguration.getAllocationFiles();
        String usageModelFile = simulizarConfiguration.getUsageModelFile();
        String monitorRepositoryFile = simulizarConfiguration.getMonitorRepositoryFile();

        System.out.println("checking " + path.toString());

        if (path.endsWith("." + REPOSITORY_EXTENSION)) {
            System.out.println("Repository model found at " + path.toString() + " (ignored)");
        } else if (path.endsWith("." + RESOURCE_ENVIRONMENT_EXTENSION)) {
            System.out.println("Resource environment found at " + path.toString() + " (ignored)");
        } else if (path.endsWith("." + SYSTEM_EXTENSION)) {
            System.out.println("System found at " + path.toString() + "(ignored)");
        } else if (path.endsWith("." + ALLOCATION_EXTENSION)) {
            System.out.println("Allocation found at " + path.toString());
            if (!allocationFiles.isEmpty()) {
                throw new IllegalStateException("Allocation already set: "
                        + allocationFiles.stream().map(it -> it.toString()).collect(Collectors.joining(", ")));
            }
            simulizarConfiguration.setAllocationFiles(List.of(path.toString()));
        } else if (path.endsWith("." + USAGEMODEL_EXTENSION)) {
            System.out.println("Usage model found at " + path.toString());
            if (usageModelFile != null && !usageModelFile.isEmpty()) {
                throw new IllegalStateException("Usage model already set: " + usageModelFile);
            }
            simulizarConfiguration.setUsageModelFile(path.toString());
        } else if (path.endsWith("." + MONITORREPOSITORY_EXTENSION)) {
            System.out.println("Monitor repository found at " + path.toString());
            if (monitorRepositoryFile != null && !monitorRepositoryFile.isEmpty()) {
                throw new IllegalStateException("Monitor repository already set: " + monitorRepositoryFile);
            }
            simulizarConfiguration.setMonitorRepositoryFile(path.toString());
        }
    }

    private Map<String, Object> createSimulationProperties() {
        final Map<String, Object> properties = new HashMap<>();

        properties.put(SimuComConfig.SIMULATE_FAILURES, false);
        properties.put(SimuComConfig.SIMULATE_LINKING_RESOURCES, false);
        properties.put(SimuComConfig.USE_FIXED_SEED, false);
        properties.put(SimuComConfig.PERSISTENCE_RECORDER_NAME,
                org.palladiosimulator.recorderframework.edp2.Activator.EDP2_ID);
        properties.put("EDP2RepositoryID", this.repo.getId());
        properties.put(SimuComConfig.SIMULATOR_ID, "de.uka.ipd.sdq.codegen.simucontroller.simulizar");
        properties.put(SimuComConfig.EXPERIMENT_RUN, SimuComConfig.DEFAULT_EXPERIMENT_RUN);
        properties.put(SimuComConfig.SIMULATION_TIME, "2000");
        properties.put(SimuComConfig.MAXIMUM_MEASUREMENT_COUNT, SimuComConfig.DEFAULT_MAXIMUM_MEASUREMENT_COUNT);
        properties.put(SimuComConfig.VERBOSE_LOGGING, false);
        properties.put(SimuComConfig.VARIATION_ID, SimuComConfig.DEFAULT_VARIATION_NAME);
        properties.put(SimulizarConstants.RECONFIGURATION_RULES_FOLDER,
                SimulizarConstants.DEFAULT_RECONFIGURATION_RULES_FOLDER);
        properties.put("de.uka.ipd.sdq.workflowengine.debuglevel", "1"); // Log level DEBUG

        return properties;
    }

    protected final void runSuccessfulSimulation() {
        final IProgressMonitor progressMonitor = new NullProgressMonitor();
        try {
            this.simulizarJob.execute(progressMonitor);
        } catch (final Throwable anyException) {
            failDueToException(anyException);
        }
    }

    private static void failDueToException(final Throwable unexpectedException) {
        fail("Unexpected exception thrown by test case:\n---------------------\nType: " + unexpectedException
                + "\nStack Trace: " + stacktraceToString(unexpectedException) + "\n---------------------");
    }

    private static String stacktraceToString(final Throwable exception) {
        final StringBuilder result = new StringBuilder();
        if (exception.getStackTrace() != null) {
            for (final StackTraceElement element : exception.getStackTrace()) {
                result.append(element.toString() + "\n");
            }
        }
        return result.toString().trim();
    }
}
