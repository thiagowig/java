package br.ithiago.integration.cameltestingexample.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by thiago on 11/10/18.
 */
@Component
public class ValidateRoute extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("direct:validate-route")
                .log("BODY: ${body}");
    }
}
