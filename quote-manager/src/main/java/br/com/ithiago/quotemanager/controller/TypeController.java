package br.com.ithiago.quotemanager.controller;

import br.com.ithiago.quotemanager.model.Type;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by thiago on 5/13/17.
 */
@RestController("/type")
public class TypeController {

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public Type getType(@RequestBody Type type) {
        type.setName(type.getName() + " processed!!!");

        return type;
    }
}
