package br.com.ithiago.githubreader.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

@AutoConfigureWireMock(port = 0, stubs = "classpath:/mappings")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WiremockTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    /*@Before
    public void setup() {
        stubFor(get(urlEqualTo("https://api.github.com/users/thiagowig"))
                .willReturn(aResponse().withBody("Hello World!")));
    }*/

    @Test
    public void shouldTestSomething() {
        String body = testRestTemplate.getForObject("/api/users/thiagowig/info", String.class);
        assertEquals("{}", body);
    }

}
