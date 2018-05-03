package br.com.ithiago.camel.file;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by thiago on 5/2/18.
 */
public class CopyFilesCamel {

    public static void main(String[] args) {
        CamelContext context = new DefaultCamelContext();

        try {
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:data/input")
                    .to("file:data/output");
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
