package br.com.ithiago.camelcourse.route;

import br.com.ithiago.camelcourse.exception.DataValidationException;
import br.com.ithiago.camelcourse.model.Item;
import br.com.ithiago.camelcourse.processor.ValidateDataProcessor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by thiago on 5/12/18.
 */
@Component
public class KafkaCamelRoute extends RouteBuilder {

    @Autowired
    private ValidateDataProcessor processor;

    @Override
    public void configure() throws Exception {
        GsonDataFormat itemFormat = new GsonDataFormat(Item.class);

        onException(DataValidationException.class)
                .log(LoggingLevel.ERROR, "Error validating data")
                .to("kafka:errorTopic?brokers=localhost:9092");

        from("kafka:inputItemTopic?brokers=localhost:9092&groupId=itemDev&autoOffsetReset=earliest&consumersCount=1")
        .unmarshal(itemFormat)
        .log("Unmarshelled message is: ${body}")
        .process(processor)
        .to("log:?level=INFO&showBody=true");
    }
}
