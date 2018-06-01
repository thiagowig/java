package br.com.ithiago.greendog.controller;

import br.com.ithiago.greendog.model.Property;
import br.com.ithiago.greendog.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by thiago on 5/31/18.
 */
@RestController
@RequestMapping("/api")
public class PropertyController {

    @Autowired
    private PropertyRepository propertyRepository;

    @RequestMapping(value = "/find/{filter}", method = RequestMethod.GET)
    public List<Property> findByFilter(@PathVariable("filter") String filter) {
        return propertyRepository.findByFilter(filter);
    }
}
