package br.com.ithiago;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 */
public class App {

    public void writeValue(Object object) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(System.out, object);
    }
}
