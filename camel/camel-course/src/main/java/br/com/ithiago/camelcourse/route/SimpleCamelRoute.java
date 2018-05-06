package br.com.ithiago.camelcourse.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by thiago on 5/5/18.
 */
@Component
public class SimpleCamelRoute extends RouteBuilder {

    @Autowired
    private Environment env;

    @Override
    public void configure() throws Exception {
        String message = env.getProperty("message");

        from("{{startRoute}}")
                .log("Timer invoked and the message is " + message)
                .choice()
                    .when((header("env").isNotEqualTo("mock")))
                        .pollEnrich("{{fromRoute}}")
                    .otherwise()
                        .log("Mock env flow and the body is ${body}")
                .end()
                .to("{{toRoute}}");
    }
}
