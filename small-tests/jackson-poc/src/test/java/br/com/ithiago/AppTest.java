package br.com.ithiago;

import org.junit.Test;


public class AppTest {

    private App app = new App();

    @Test
    public void shouldReturnValidValue() throws Exception {
        User user = new User();
        user.setName("Thiago");
        user.setAddress(new Address());
        user.getAddress().setStreet("Quixada");
        user.getAddress().setNumber(123456);

        app.writeValue(user);
    }

}
