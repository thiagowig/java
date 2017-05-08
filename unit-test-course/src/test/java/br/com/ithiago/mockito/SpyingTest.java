package br.com.ithiago.mockito;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

/**
 * Created by tfonseca on 08/05/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class SpyingTest {

    private MathApplication mathApplication;
    private CalculatorService calculatorService;

    @Before
    public void setup() {
        mathApplication = new MathApplication();
        Calculator calculator = new Calculator();
        calculatorService = Mockito.spy(calculator);
        mathApplication.setCalculatorService(calculatorService);
    }

    @Test
    public void testWithSpy() {
        Double result = mathApplication.add(20.0, 10.0);

        Assert.assertEquals(30.0, result, 0);
        Assert.assertThat(result, Matchers.is(30D));
    }
}
