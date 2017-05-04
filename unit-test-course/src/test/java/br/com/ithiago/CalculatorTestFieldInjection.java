package br.com.ithiago;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class CalculatorTestFieldInjection {

    @Parameterized.Parameter(value = 0)
    public Integer firstNumber;

    @Parameterized.Parameter(value = 1)
    public Integer secondNumber;

    @Parameterized.Parameter(value = 2)
    public Integer expected;

    private Calculator calculator = new Calculator();

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {1, 1, 2},
                {2, 2, 4},
                {8, 2, 10},
                {4, 5, 9},
                {5, 5, 10},
                {200, 50, 250}
        });
    }

    @Test
    public void testSum() {
        assertThat(calculator.sum(firstNumber, secondNumber), is(expected));
    }

}