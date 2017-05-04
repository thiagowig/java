package br.com.ithiago;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class AssertTests {

    @Test
    public void testAsserts() {
        assertArrayEquals("failure - byte arrays not same", "trial".getBytes(), "trial".getBytes());
        assertEquals("failure - string are not equal", "thiago", "thiago");
        assertFalse("failure - should be false", false);
        assertTrue("failure - should be true", true);
        assertNotNull("failure - should not be null", new Object());
        assertNull(null);
        assertNotSame(new Object(), new Object());
        assertSame("Thiago", "Thiago");
    }

    @Test
    public void testMatchers() {
        assertThat("Thiago", both(containsString("T")).and(containsString("h")));
        assertThat(Arrays.asList("one", "two", "three"), hasItems("three", "two"));
        assertThat(Arrays.asList("thiago", "santos", "fonseca"), everyItem(containsString(("a"))));
    }

}
