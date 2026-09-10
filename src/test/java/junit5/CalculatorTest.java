package junit5;

import lesson_7_junit5.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(10, calculator.add(5, 5));
    }

    @Test
    public void testSubtract() {
        assertEquals(5, calculator.subtract(15, 10));
    }

    @Test
    public void testMultiply() {
        assertEquals(20, calculator.multiply(5, 4));
    }

    @Test
    public void testDivide() {
        assertEquals(2.5, calculator.divide(5, 2), 0.0001);
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
    }
}
