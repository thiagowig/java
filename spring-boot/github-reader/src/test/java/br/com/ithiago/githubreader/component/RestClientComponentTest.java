package br.com.ithiago.githubreader.component;

import br.com.ithiago.githubreader.dto.UserInfoDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * Created by thiago on 4/16/19.
 */
@RestClientTest(RestClientComponent.class)
@RunWith(SpringRunner.class)
public class RestClientComponentTest {

    @Autowired
    private RestClientComponent client;

    @Autowired
    private MockRestServiceServer server;

    @Before
    public void setup() {
        this.server.expect(requestTo("http://localhost"))
                .andRespond(withSuccess("{\"id\":123456}", MediaType.APPLICATION_JSON));
    }

    @Test
    public void shouldTestSomething() {
        UserInfoDTO dto = (UserInfoDTO) client.executeGetCall("http://localhost", UserInfoDTO.class);
        assertEquals(dto.getId().toString(), "123456");
    }

}