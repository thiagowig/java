package br.com.ithiago.camelresttest.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by thiago on 5/20/18.
 */
@Component
public class UsersRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        rest("/users")
                .description("Users API")
                .id("users-route")
                .produces("application/json")
                .get()
                .to("log:?level=INFO&showBody=true");

    }

}
