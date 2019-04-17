package br.com.ithiago.githubreader.service;

import br.com.ithiago.githubreader.component.RestClientComponent;
import br.com.ithiago.githubreader.dto.UserInfoDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

/**
 * Created by thiago on 4/16/19.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private static RestClientComponent restClient;

    @Before
    public void setup() {
        ReflectionTestUtils.setField(userService, "url", "https://api.github.com/usuarios/%s");
    }

    @Test
    public void shouldTestSomething() {
        UserInfoDTO dto = new UserInfoDTO();
        dto.setId(123456);
        given(restClient.executeGetCall("https://api.github.com/usuarios/thiagowig", UserInfoDTO.class)).willReturn(dto);

        UserInfoDTO userInfoDTO = userService.getUserInformation("thiagowig");
        assertEquals(dto.getId(), userInfoDTO.getId());
    }

    @Test
    public void shouldTestSomething02() {
        UserInfoDTO dto = new UserInfoDTO();
        dto.setId(654321);
        given(restClient.executeGetCall("https://api.github.com/usuarios/camarguim", UserInfoDTO.class)).willReturn(dto);

        UserInfoDTO userInfoDTO = userService.getUserInformation("camarguim");
        assertEquals(dto.getId(), userInfoDTO.getId());
    }

}