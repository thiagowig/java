package dev.thiagofonseca.java.spring.modulith;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

public class ApplicationModuleTests {

    @Test
    public void shouldValidateApplicationModules() {
        var modules = ApplicationModules.of(Application.class);
        modules.forEach(System.out::println);

        modules.verify();
    }
}
