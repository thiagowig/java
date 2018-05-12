package br.com.ithiago.camelcourse.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by thiago on 5/6/18.
 */
@Component
public class TestRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:myOwnTimer?period=10s")
                .to("http://localhost:8080/currentDateTime").convertBodyTo(String.class)
                .log("Executed and de body is ${body}");
    }
}
