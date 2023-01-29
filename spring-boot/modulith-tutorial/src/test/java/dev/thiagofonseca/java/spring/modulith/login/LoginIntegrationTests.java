package dev.thiagofonseca.java.spring.modulith.login;

import dev.thiagofonseca.java.spring.modulith.user.spi.UserSpi;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.modulith.test.ApplicationModuleTest;

@ApplicationModuleTest
public class LoginIntegrationTests {

    @MockBean
    private UserSpi userSpi;

    @Test
    void name() {
        System.out.println("");
    }
}
