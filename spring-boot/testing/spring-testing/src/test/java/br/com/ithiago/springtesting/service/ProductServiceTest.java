package br.com.ithiago.springtesting.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;

@RunWith(SpringRunner.class)
@RestClientTest({ProductService.class})
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private MockRestServiceServer server;

    @Test
    public void shouldTest() {
        String url = "https://localhost/users/thiagowig";

        this.server.expect(MockRestRequestMatchers.requestTo(url))
                .andRespond(MockRestResponseCreators.withSuccess("TESTE", MediaType.TEXT_PLAIN));

        ResponseEntity<String> response = productService.doSomething();

        Assert.assertEquals("TESTE", response.getBody());
    }
}
