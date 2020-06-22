package br.com.ithiago.restfulwebservices;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {

    @Test
    public void shouldEncryptPassword() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPass = encoder.encode("admin");

        System.out.println(encodedPass);

    }
}
