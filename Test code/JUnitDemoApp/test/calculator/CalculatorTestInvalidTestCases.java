package calculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTestInvalidTestCases {
    
    Calculator c = new Calculator();
    
    @Test
    public void testSumLowBondary() throws SumException {
        int res = c.sum(1, 1);
        assertEquals("tester med 1 og 1 ", 2, res);
    }

    @Test
    public void testSumHighBoundary() throws SumException {
        int res = c.sum(100, 100);
        assertEquals("tester med 1 og 1 ", 200, res);
    }

    @Test(expected = SumException.class)
    public void testSumFirstTooLow() throws SumException {
        c.sum(0, 1);
    }

    @Test(expected = SumException.class)
    public void testSumLastTooLow() throws SumException {
        c.sum(1, 0);
    }

    @Test(expected = SumException.class)
    public void testSumFirstTooHigh() throws SumException {
        c.sum(101, 100);
    }

    @Test(expected = SumException.class)
    public void testSumLastTooHigh() throws SumException {
        c.sum(100, 101);
    }

    @Test(expected = SumException.class)
    public void testSumBothTooHigh() throws SumException {
        c.sum(101, 101);
    }
}
