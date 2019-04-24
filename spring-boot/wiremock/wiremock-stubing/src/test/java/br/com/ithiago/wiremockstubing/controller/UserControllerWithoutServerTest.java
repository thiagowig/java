package br.com.ithiago.wiremockstubing.controller;

import br.com.ithiago.wiremockstubing.test.types.IntegrationTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWireMock(port = 0)
@AutoConfigureMockMvc
@Category(IntegrationTest.class)
public class UserControllerWithoutServerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testFullApp() throws Exception {
        this.mvc.perform(get("/api/user/info")).andExpect(content().string("{\"login\":\"cabuloso\"}"));
    }

}