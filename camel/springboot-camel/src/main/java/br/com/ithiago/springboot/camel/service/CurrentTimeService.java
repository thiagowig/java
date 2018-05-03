package br.com.ithiago.springboot.camel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by thiago on 5/2/18.
 */
@Service
public class CurrentTimeService {

    @Autowired
    private Environment environment;

    public String getCurrentDateTime() {
        String message = environment.getProperty("message");
        return message.concat(LocalDateTime.now().toString());
    }



}
