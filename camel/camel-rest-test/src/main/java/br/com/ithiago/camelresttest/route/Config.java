package br.com.ithiago.camelresttest.route;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by thiago on 5/20/18.
 */
@Component
public class Config extends RouteBuilder{

    @Value("${camel.api.path}")
    private String contextPath;

    @Value("${camel.api.server.port}")
    private String serverPort;

    @Autowired
    private CamelContext camelContext;


    @Override
    public void configure() throws Exception {
        restConfiguration()
                .contextPath(contextPath)
                .port(serverPort)
                .enableCORS(true)
                .apiContextPath("/api-doc")
                .apiProperty("api.title", "Test REST API")
                .apiProperty("api.version", "v1")
                .apiProperty("cors", "true")
                .apiContextRouteId("doc-api")
                .component("servlet")
                .bindingMode(RestBindingMode.json)
                .dataFormatProperty("prettyPrint", "true");
    }
}
