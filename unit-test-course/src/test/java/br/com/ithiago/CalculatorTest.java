package br.com.ithiago;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CalculatorTest {

    private Integer firstNumber;

    private Integer secondNumber;

    private Integer expected;

    private Calculator calculator = new Calculator();

    public CalculatorTest(Integer firstNumber, Integer secondNumber, Integer expected) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.expected = expected;
    }

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