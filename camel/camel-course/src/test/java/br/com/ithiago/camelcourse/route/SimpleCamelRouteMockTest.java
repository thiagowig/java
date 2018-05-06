package br.com.ithiago.camelcourse.route;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by thiago on 5/5/18.
 */
@ActiveProfiles("mock")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(CamelSpringBootRunner.class)
@SpringBootTest
public class SimpleCamelRouteMockTest extends CamelTestSupport {

    @Autowired
    protected CamelContext camelContext;

    @Autowired
    private Environment environment;

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    protected CamelContext createCamelContext() {
        return camelContext;
    }

    @Test
    public void testMoveFileMock() throws InterruptedException {
        String message = "type,sku#,itemdescription,price\n" +
                "ADD, 100, Samsung TV, 501\n" +
                "ADD, 101, LG TV, 502;";

        String startRoute = environment.getProperty("startRoute");
        String toRoute = environment.getProperty("toRoute");
        String activeProfile = environment.getProperty("spring.profiles.active");

        MockEndpoint mockEndpoint = getMockEndpoint(toRoute);
        mockEndpoint.expectedMessageCount(1);
        mockEndpoint.expectedBodiesReceived(message);

        producerTemplate.sendBodyAndHeader(startRoute, message, "env", activeProfile);

        assertMockEndpointsSatisfied();
    }

}
