package br.ithiago.integration.cameltestingexample;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by thiago on 11/10/18.
 */
@Component
public class RestConfiguration extends RouteBuilder {

    @Value("${server.port}")
    public String serverPort;

    @Override
    public void configure() throws Exception {
        restConfiguration()
                .port(serverPort)
                .bindingMode(RestBindingMode.json)
                .dataFormatProperty("prettyPrint", "true");
    }


}
