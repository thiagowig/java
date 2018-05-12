package br.com.ithiago.springboot.camel.controller;

import br.com.ithiago.springboot.camel.model.Person;
import br.com.ithiago.springboot.camel.service.CurrentTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thiago on 5/2/18.
 */
@RestController
public class CurrentTimeController {

    @Autowired
    private CurrentTimeService service;

    @RequestMapping("/currentDateTime")
    public Object getCurrentDateTime() {
        List<Person> persons = new ArrayList<>();
        persons.add(this.generatePerson("Thiago Fonseca", "Quixada Street", 40));
        persons.add(this.generatePerson("Tania Ramos", "Engenheiros Avenue", 20));

        return persons;
    }

    private Person generatePerson(String name, String address, Integer age) {
        Person person = new Person();
        person.setName(name);
        person.setAddress(address);
        person.setAge(age);

        return person;
    }
}
