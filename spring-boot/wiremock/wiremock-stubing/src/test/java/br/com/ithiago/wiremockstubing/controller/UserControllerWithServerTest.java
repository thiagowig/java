package br.com.ithiago.wiremockstubing.controller;

import org.junit.Test;
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
public class UserControllerWithServerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testFullApp() {
        String response = this.testRestTemplate.getForObject("/api/user/info", String.class);

        assertEquals("{\"login\":\"cabuloso\"}", response);
    }

}