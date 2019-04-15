package br.com.ithiago.springtesting.controller;

import br.com.ithiago.springtesting.component.ClientComponent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private ClientComponent clientComponent;

    @Before
    public void setUp() {
        BDDMockito.given(clientComponent.doSomething()).willReturn("Toledim");
    }

    @Test
    public void doSomething02() {
        String body = this.testRestTemplate.getForObject("/address", String.class);
        assertEquals("Toledim", body);
    }

    @Test
    public void mockBeanTest() {
        String body = this.testRestTemplate.getForObject("/address", String.class);
        assertEquals("Toledim", body);
    }

}