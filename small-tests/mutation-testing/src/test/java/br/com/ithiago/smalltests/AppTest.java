package br.com.ithiago.smalltests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void whenPalindromThanAccept() {
        var app = new App();
        Assertions.assertTrue(app.isPalindrome("noon"));
    }

    @Test
    public void whenNotPalindromThanReject() {
        var app = new App();
        Assertions.assertFalse(app.isPalindrome("box"));
    }

    @Test
    public void whenNearPalindromThanReject() {
        var app = new App();
        Assertions.assertFalse(app.isPalindrome("neon"));
    }

}
