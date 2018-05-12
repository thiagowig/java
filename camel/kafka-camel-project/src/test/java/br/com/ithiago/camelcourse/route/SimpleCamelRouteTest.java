package br.com.ithiago.camelcourse.route;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by thiago on 5/5/18.
 */
@ActiveProfiles("dev")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(CamelSpringBootRunner.class)
@SpringBootTest
public class SimpleCamelRouteTest {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private Environment environment;

    @BeforeClass
    public static void cleanUp() throws IOException {
        FileUtils.cleanDirectory(new File("data/input"));
        FileUtils.deleteDirectory(new File("data/dev/output"));
    }

    @Test
    public void testMoveFile() throws InterruptedException {
        String message = "type,sku#,itemdescription,price\n" +
                "ADD, 100, Samsung TV, 501\n" +
                "ADD, 101, LG TV, 502;";

        String fileName = "fileTest.txt";

        String fromRoute = environment.getProperty("fromRoute");

        producerTemplate.sendBodyAndHeader(fromRoute, message, Exchange.FILE_NAME, fileName);

        Thread.sleep(3000);

        File outFile = new File("data/dev/output/" + fileName);

        assertTrue(outFile.exists());
    }

}
