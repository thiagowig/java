package br.com.ithiago.mockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by tfonseca on 05/05/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTest {

    @InjectMocks
    private MathApplication mathApplication;

    @Mock
    private CalculatorService calculatorService;

    @Test
    public void testAdd() {
        Mockito.when(calculatorService.add(10D, 20D)).thenReturn(30D);

        Assert.assertEquals(30D, mathApplication.add(10D, 20D), 0);
        Assert.assertEquals(30D, mathApplication.add(10D, 20D), 0);
        Assert.assertEquals(30D, mathApplication.add(10D, 20D), 0);

        Mockito.verify(calculatorService, Mockito.times(3)).add(10D, 20D);
        Mockito.verify(calculatorService, Mockito.never()).multiply(10D, 20D);
        Mockito.verify(calculatorService, Mockito.never()).add(88D, 99D);
        Mockito.verify(calculatorService, Mockito.atLeast(3)).add(10D, 20D);
        Mockito.verify(calculatorService, Mockito.atMost(3)).add(10D, 20D);
    }

    @Test(expected = RuntimeException.class)
    public void testThrow() {
        Mockito.doThrow(new RuntimeException()).when(calculatorService.add(10D, 20D));

        Assert.assertEquals(mathApplication.add(10D, 20D),30D,0);
    }
}
