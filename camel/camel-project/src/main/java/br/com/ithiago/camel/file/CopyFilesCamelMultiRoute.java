package br.com.ithiago.camel.file;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by thiago on 5/5/18.
 */
public class CopyFilesCamelMultiRoute {

    public static void main(String[] args) {
        CamelContext context = new DefaultCamelContext();

        try {
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:data/input?noop=true")
                            .to("log:?level=INFO&showBody=true&showHeaders=true")
                            .to("file:data/output")
                            .to("file:data/output03");

                    from("file:data/input02?noop=true")
                            .to("file:data/output02");
                }
            });

            context.start();

            Thread.sleep(5000);

            context.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
