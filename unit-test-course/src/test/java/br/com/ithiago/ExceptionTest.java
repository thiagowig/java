package br.com.ithiago;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class ExceptionTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldTestExceptionByRule() {
        List<Object> list = new ArrayList<Object>();

        exception.expect(IndexOutOfBoundsException.class);
        exception.expectMessage(Matchers.containsString("Size: 0"));

        list.get(0);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowAnException() {
        throw new NullPointerException();
    }

}
