package test;

import main.StringCalculator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @Before
    public void initialize() {
        calculator = new StringCalculator();
    }

    @Test
    public void emptyStringShouldReturn0() {
        assertEquals(calculator.add(""), 0);
    }
}
