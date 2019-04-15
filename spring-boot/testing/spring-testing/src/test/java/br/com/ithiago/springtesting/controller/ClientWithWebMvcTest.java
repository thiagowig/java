package br.com.ithiago.springtesting.controller;

import br.com.ithiago.springtesting.service.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(ClientController.class)
public class ClientWithWebMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ClientService clientService;

    @Test
    public void testingMock() throws Exception {
        BDDMockito.given(clientService.doSomething()).willReturn("Testing");

        this.mvc.perform((MockMvcRequestBuilders.get("/client")))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Testing"));

    }
}
