package br.com.ithiago.wiremockstubing.controller;

import br.com.ithiago.wiremockstubing.service.UserService;
import br.com.ithiago.wiremockstubing.test.types.UnitTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
@Category(UnitTest.class)
public class UserControllerUnitTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Test
    public void shouldTestSomething() {
        given(userService.getUserInformation()).willReturn("thiago");

        String userInfo = userController.getUserInfo();

        assertEquals("thiago", userInfo);
    }
}
