package br.com.ithiago.wiremockstubing.controller;

import br.com.ithiago.wiremockstubing.test.types.IntegrationTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
@Category(IntegrationTest.class)
public class UserControllerWithServerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testFullApp() {
        String response = this.testRestTemplate.getForObject("/api/user/info", String.class);

        assertEquals("{\"login\":\"cabuloso\"}", response);
    }

}