package br.com.ithiago.web.rest;

import br.com.ithiago.SimulationApp;

import br.com.ithiago.domain.Simulation;
import br.com.ithiago.repository.SimulationRepository;
import br.com.ithiago.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import br.com.ithiago.domain.enumeration.FinancialInstituition;
/**
 * Test class for the SimulationResource REST controller.
 *
 * @see SimulationResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SimulationApp.class)
public class SimulationResourceIntTest {

    private static final FinancialInstituition DEFAULT_FINANCIAL_INSTITUITION = FinancialInstituition.BB;
    private static final FinancialInstituition UPDATED_FINANCIAL_INSTITUITION = FinancialInstituition.BRADESCO;

    private static final Integer DEFAULT_PROPERTY_VALUE = 1;
    private static final Integer UPDATED_PROPERTY_VALUE = 2;

    private static final Boolean DEFAULT_USING_FGTS = false;
    private static final Boolean UPDATED_USING_FGTS = true;

    private static final Integer DEFAULT_FINANCIAL_VALUE = 1;
    private static final Integer UPDATED_FINANCIAL_VALUE = 2;

    private static final Integer DEFAULT_INITIAL_VALUE = 1;
    private static final Integer UPDATED_INITIAL_VALUE = 2;

    private static final Integer DEFAULT_FGTS_VALUE = 1;
    private static final Integer UPDATED_FGTS_VALUE = 2;

    private static final Integer DEFAULT_MONTHS = 1;
    private static final Integer UPDATED_MONTHS = 2;

    private static final Double DEFAULT_TAX = 1D;
    private static final Double UPDATED_TAX = 2D;

    private static final Boolean DEFAULT_WITH_TR = false;
    private static final Boolean UPDATED_WITH_TR = true;

    private static final Double DEFAULT_SAC_INSTALLMENT = 1D;
    private static final Double UPDATED_SAC_INSTALLMENT = 2D;

    private static final Double DEFAULT_PRICE_INSTALLMENT = 1D;
    private static final Double UPDATED_PRICE_INSTALLMENT = 2D;

    @Autowired
    private SimulationRepository simulationRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    private MockMvc restSimulationMockMvc;

    private Simulation simulation;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        SimulationResource simulationResource = new SimulationResource(simulationRepository);
        this.restSimulationMockMvc = MockMvcBuilders.standaloneSetup(simulationResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Simulation createEntity() {
        Simulation simulation = new Simulation()
            .financialInstituition(DEFAULT_FINANCIAL_INSTITUITION)
            .propertyValue(DEFAULT_PROPERTY_VALUE)
            .usingFgts(DEFAULT_USING_FGTS)
            .financialValue(DEFAULT_FINANCIAL_VALUE)
            .initialValue(DEFAULT_INITIAL_VALUE)
            .fgtsValue(DEFAULT_FGTS_VALUE)
            .months(DEFAULT_MONTHS)
            .tax(DEFAULT_TAX)
            .withTR(DEFAULT_WITH_TR)
            .sacInstallment(DEFAULT_SAC_INSTALLMENT)
            .priceInstallment(DEFAULT_PRICE_INSTALLMENT);
        return simulation;
    }

    @Before
    public void initTest() {
        simulationRepository.deleteAll();
        simulation = createEntity();
    }

    @Test
    public void createSimulation() throws Exception {
        int databaseSizeBeforeCreate = simulationRepository.findAll().size();

        // Create the Simulation
        restSimulationMockMvc.perform(post("/api/simulations")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(simulation)))
            .andExpect(status().isCreated());

        // Validate the Simulation in the database
        List<Simulation> simulationList = simulationRepository.findAll();
        assertThat(simulationList).hasSize(databaseSizeBeforeCreate + 1);
        Simulation testSimulation = simulationList.get(simulationList.size() - 1);
        assertThat(testSimulation.getFinancialInstituition()).isEqualTo(DEFAULT_FINANCIAL_INSTITUITION);
        assertThat(testSimulation.getPropertyValue()).isEqualTo(DEFAULT_PROPERTY_VALUE);
        assertThat(testSimulation.isUsingFgts()).isEqualTo(DEFAULT_USING_FGTS);
        assertThat(testSimulation.getFinancialValue()).isEqualTo(DEFAULT_FINANCIAL_VALUE);
        assertThat(testSimulation.getInitialValue()).isEqualTo(DEFAULT_INITIAL_VALUE);
        assertThat(testSimulation.getFgtsValue()).isEqualTo(DEFAULT_FGTS_VALUE);
        assertThat(testSimulation.getMonths()).isEqualTo(DEFAULT_MONTHS);
        assertThat(testSimulation.getTax()).isEqualTo(DEFAULT_TAX);
        assertThat(testSimulation.isWithTR()).isEqualTo(DEFAULT_WITH_TR);
        assertThat(testSimulation.getSacInstallment()).isEqualTo(DEFAULT_SAC_INSTALLMENT);
        assertThat(testSimulation.getPriceInstallment()).isEqualTo(DEFAULT_PRICE_INSTALLMENT);
    }

    @Test
    public void createSimulationWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = simulationRepository.findAll().size();

        // Create the Simulation with an existing ID
        simulation.setId("existing_id");

        // An entity with an existing ID cannot be created, so this API call must fail
        restSimulationMockMvc.perform(post("/api/simulations")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(simulation)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<Simulation> simulationList = simulationRepository.findAll();
        assertThat(simulationList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    public void getAllSimulations() throws Exception {
        // Initialize the database
        simulationRepository.save(simulation);

        // Get all the simulationList
        restSimulationMockMvc.perform(get("/api/simulations?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(simulation.getId())))
            .andExpect(jsonPath("$.[*].financialInstituition").value(hasItem(DEFAULT_FINANCIAL_INSTITUITION.toString())))
            .andExpect(jsonPath("$.[*].propertyValue").value(hasItem(DEFAULT_PROPERTY_VALUE)))
            .andExpect(jsonPath("$.[*].usingFgts").value(hasItem(DEFAULT_USING_FGTS.booleanValue())))
            .andExpect(jsonPath("$.[*].financialValue").value(hasItem(DEFAULT_FINANCIAL_VALUE)))
            .andExpect(jsonPath("$.[*].initialValue").value(hasItem(DEFAULT_INITIAL_VALUE)))
            .andExpect(jsonPath("$.[*].fgtsValue").value(hasItem(DEFAULT_FGTS_VALUE)))
            .andExpect(jsonPath("$.[*].months").value(hasItem(DEFAULT_MONTHS)))
            .andExpect(jsonPath("$.[*].tax").value(hasItem(DEFAULT_TAX.doubleValue())))
            .andExpect(jsonPath("$.[*].withTR").value(hasItem(DEFAULT_WITH_TR.booleanValue())))
            .andExpect(jsonPath("$.[*].sacInstallment").value(hasItem(DEFAULT_SAC_INSTALLMENT.doubleValue())))
            .andExpect(jsonPath("$.[*].priceInstallment").value(hasItem(DEFAULT_PRICE_INSTALLMENT.doubleValue())));
    }

    @Test
    public void getSimulation() throws Exception {
        // Initialize the database
        simulationRepository.save(simulation);

        // Get the simulation
        restSimulationMockMvc.perform(get("/api/simulations/{id}", simulation.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(simulation.getId()))
            .andExpect(jsonPath("$.financialInstituition").value(DEFAULT_FINANCIAL_INSTITUITION.toString()))
            .andExpect(jsonPath("$.propertyValue").value(DEFAULT_PROPERTY_VALUE))
            .andExpect(jsonPath("$.usingFgts").value(DEFAULT_USING_FGTS.booleanValue()))
            .andExpect(jsonPath("$.financialValue").value(DEFAULT_FINANCIAL_VALUE))
            .andExpect(jsonPath("$.initialValue").value(DEFAULT_INITIAL_VALUE))
            .andExpect(jsonPath("$.fgtsValue").value(DEFAULT_FGTS_VALUE))
            .andExpect(jsonPath("$.months").value(DEFAULT_MONTHS))
            .andExpect(jsonPath("$.tax").value(DEFAULT_TAX.doubleValue()))
            .andExpect(jsonPath("$.withTR").value(DEFAULT_WITH_TR.booleanValue()))
            .andExpect(jsonPath("$.sacInstallment").value(DEFAULT_SAC_INSTALLMENT.doubleValue()))
            .andExpect(jsonPath("$.priceInstallment").value(DEFAULT_PRICE_INSTALLMENT.doubleValue()));
    }

    @Test
    public void getNonExistingSimulation() throws Exception {
        // Get the simulation
        restSimulationMockMvc.perform(get("/api/simulations/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateSimulation() throws Exception {
        // Initialize the database
        simulationRepository.save(simulation);
        int databaseSizeBeforeUpdate = simulationRepository.findAll().size();

        // Update the simulation
        Simulation updatedSimulation = simulationRepository.findOne(simulation.getId());
        updatedSimulation
            .financialInstituition(UPDATED_FINANCIAL_INSTITUITION)
            .propertyValue(UPDATED_PROPERTY_VALUE)
            .usingFgts(UPDATED_USING_FGTS)
            .financialValue(UPDATED_FINANCIAL_VALUE)
            .initialValue(UPDATED_INITIAL_VALUE)
            .fgtsValue(UPDATED_FGTS_VALUE)
            .months(UPDATED_MONTHS)
            .tax(UPDATED_TAX)
            .withTR(UPDATED_WITH_TR)
            .sacInstallment(UPDATED_SAC_INSTALLMENT)
            .priceInstallment(UPDATED_PRICE_INSTALLMENT);

        restSimulationMockMvc.perform(put("/api/simulations")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedSimulation)))
            .andExpect(status().isOk());

        // Validate the Simulation in the database
        List<Simulation> simulationList = simulationRepository.findAll();
        assertThat(simulationList).hasSize(databaseSizeBeforeUpdate);
        Simulation testSimulation = simulationList.get(simulationList.size() - 1);
        assertThat(testSimulation.getFinancialInstituition()).isEqualTo(UPDATED_FINANCIAL_INSTITUITION);
        assertThat(testSimulation.getPropertyValue()).isEqualTo(UPDATED_PROPERTY_VALUE);
        assertThat(testSimulation.isUsingFgts()).isEqualTo(UPDATED_USING_FGTS);
        assertThat(testSimulation.getFinancialValue()).isEqualTo(UPDATED_FINANCIAL_VALUE);
        assertThat(testSimulation.getInitialValue()).isEqualTo(UPDATED_INITIAL_VALUE);
        assertThat(testSimulation.getFgtsValue()).isEqualTo(UPDATED_FGTS_VALUE);
        assertThat(testSimulation.getMonths()).isEqualTo(UPDATED_MONTHS);
        assertThat(testSimulation.getTax()).isEqualTo(UPDATED_TAX);
        assertThat(testSimulation.isWithTR()).isEqualTo(UPDATED_WITH_TR);
        assertThat(testSimulation.getSacInstallment()).isEqualTo(UPDATED_SAC_INSTALLMENT);
        assertThat(testSimulation.getPriceInstallment()).isEqualTo(UPDATED_PRICE_INSTALLMENT);
    }

    @Test
    public void updateNonExistingSimulation() throws Exception {
        int databaseSizeBeforeUpdate = simulationRepository.findAll().size();

        // Create the Simulation

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restSimulationMockMvc.perform(put("/api/simulations")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(simulation)))
            .andExpect(status().isCreated());

        // Validate the Simulation in the database
        List<Simulation> simulationList = simulationRepository.findAll();
        assertThat(simulationList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    public void deleteSimulation() throws Exception {
        // Initialize the database
        simulationRepository.save(simulation);
        int databaseSizeBeforeDelete = simulationRepository.findAll().size();

        // Get the simulation
        restSimulationMockMvc.perform(delete("/api/simulations/{id}", simulation.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Simulation> simulationList = simulationRepository.findAll();
        assertThat(simulationList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Simulation.class);
        Simulation simulation1 = new Simulation();
        simulation1.setId("id1");
        Simulation simulation2 = new Simulation();
        simulation2.setId(simulation1.getId());
        assertThat(simulation1).isEqualTo(simulation2);
        simulation2.setId("id2");
        assertThat(simulation1).isNotEqualTo(simulation2);
        simulation1.setId(null);
        assertThat(simulation1).isNotEqualTo(simulation2);
    }
}
