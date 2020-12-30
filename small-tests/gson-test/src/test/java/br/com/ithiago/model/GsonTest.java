package br.com.ithiago.model;

import com.google.gson.Gson;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class GsonTest {

    private Gson gson = new Gson();

    @Test
    public void soundDeserialize() {
        String json = "{\"id\": 123, \"name\": \"Thiago Fonseca\", \"age\": 35, \"address\": \"Brasil Street\"}";

        Client client = gson.fromJson(json, Client.class);
        Assert.assertThat(client.getId(), CoreMatchers.is(123L));
    }
}
