package test;

import main.StringCalculator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.rules.ExpectedException;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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

    @Test
    public void threeNumberWithDifferentDelimitedToBeSummed() {
        assertEquals(calculator.add("3,4,5"), 12);
        assertEquals(calculator.add("1\n2\n3"), 6);
    }

    @Test
    public void negativeInputReturnsException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Negative input!");
        calculator.add("-5");
        calculator.add("-8,10\n-25");
    }

    @Test
    public void numbersGreaterThan1000AreIgnored() {
        assertEquals(calculator.add("5,15,1001"), 20);
        assertEquals(calculator.add("1456,25\n5,2101"), 30);
    }
}
