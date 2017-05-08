package br.com.ithiago.mockito;

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
public class MockTest {

    private MathApplication mathApplication;
    private CalculatorService calculatorService;

    @Before
    public void setup() {
        mathApplication = new MathApplication();
        calculatorService = Mockito.mock(CalculatorService.class);
        mathApplication.setCalculatorService(calculatorService);
    }

    @Test
    public void testWithInOrder() {
        Mockito.when(calculatorService.add(20D, 10D)).thenReturn(30D);
        Mockito.when(calculatorService.subtract(20D, 10D)).thenReturn(10D);

        Assert.assertEquals(30D, calculatorService.add(20D, 10D), 0);
        Assert.assertEquals(10D, calculatorService.subtract(20D, 10D), 0);

        InOrder inOrder = Mockito.inOrder(calculatorService);

        inOrder.verify(calculatorService).add(20D, 10D);
        inOrder.verify(calculatorService).subtract(20D, 10D);
    }

    @Test
    public void testWithCallback() {
        Mockito.when(calculatorService.add(20D, 10D)).thenAnswer(new Answer<Double>() {
            @Override
            public Double answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object[] args = invocationOnMock.getArguments();
                Object mock = invocationOnMock.getMock();

                return 30D;
            }
        });

        Assert.assertEquals(mathApplication.add(20.0, 10.0),30.0,0);
    }
}
