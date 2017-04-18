package calculator;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorTestValidTestCases {

    Calculator c = new Calculator();
    int expected, value1, value2;

    @Parameters
    public static Collection getTestParameters() {
        return Arrays.asList(new Object[][]{
            {100, 50, 50}, {2, 1, 1}, {200, 100, 100}});
    }

    public CalculatorTestValidTestCases(int n1, int n2, int n3) {
        expected = n1;
        value1 = n2;
        value2 = n3;
    }

    @Test
    public void testSumMid() throws SumException {
        int res = c.sum(value1, value2);
        assertEquals(expected, res);
    }
    
  
     
}
