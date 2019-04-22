package br.com.ithiago.wiremockstubing.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.*;

/**
 * Created by thiago on 4/21/19.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testFullApp() {
        String response = this.testRestTemplate.getForObject("/api/user/info", String.class);

        assertEquals("{\"login\":\"cabuloso\"}", response);
    }

}