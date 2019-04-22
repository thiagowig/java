package br.com.ithiago.githubreader.controller;

import br.com.ithiago.githubreader.dto.UserInfoDTO;
import br.com.ithiago.githubreader.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest({UserController.class})
public class UserControllerWebMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void shouldTestSomething() throws Exception {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setLogin("thiagowig");
        userInfoDTO.setId(1);

        given(userService.getUserInformation("thiagowig")).willReturn(userInfoDTO);

        this.mvc.perform(get("/api/users/thiagowig/info"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"login\":\"thiagowig\",\"id\":1}"))
                .andExpect(jsonPath("$.login").value("thiagowig"));
    }

}


