package br.com.ithiago.springtesting.controller;

import br.com.ithiago.springtesting.service.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ClientControllerTest {

    @Autowired
    public MockMvc mvc;

    @MockBean
    private ClientService clientService;

    @Test
    public void testMe() throws Exception {
        this.mvc.perform(get("/client"))
                .andExpect(status().isOk())
                .andExpect(content().string("This is a client"));
    }

    @Test
    public void MockBeanTest() throws Exception {
        BDDMockito.given(clientService.doSomething()).willReturn("This is a NEW client");

        this.mvc.perform(get("/client"))
                .andExpect(status().isOk())
                .andExpect(content().string("This is a NEW client"));
    }
}