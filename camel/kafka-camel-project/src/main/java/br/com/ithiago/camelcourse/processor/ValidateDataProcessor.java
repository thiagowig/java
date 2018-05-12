package br.com.ithiago.camelcourse.processor;

import br.com.ithiago.camelcourse.exception.DataValidationException;
import br.com.ithiago.camelcourse.model.Item;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * Created by thiago on 5/12/18.
 */
@Component
public class ValidateDataProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Item item = (Item) exchange.getIn().getBody();

        if (ObjectUtils.isEmpty(item.getPrice())) {
            throw new DataValidationException("The price is null for: " + item.getDescription());
        }
    }
}
