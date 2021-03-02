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

    @Test
    public void oneNumberShouldReturnItseft() {
        assertEquals(3, calculator.add("3"));
    }

    @Test
    public void twoNumbersShouldBeAdded() {
        assertEquals(7, calculator.add("2,5"));
    }

    @Test
    public void numbersNewlineDelimitedShouldBeSummed() {
        assertEquals(calculator.add("5\n3"), 8);
        assertEquals(calculator.add("21\n23"), 44);
    }
}
