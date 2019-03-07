package br.ithiago.integration.cameltestingexample.route;

import br.ithiago.integration.cameltestingexample.service.ClientService;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by thiago on 11/10/18.
 */
@Component
public class ClientRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        rest("/client")
                .id("users-route")
                .produces("application/json")
                .get()
                    .route()
                    .to("direct:validate-route")
                    .bean(ClientService.class, "findAllClients");

    }
}
