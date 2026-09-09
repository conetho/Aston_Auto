package junit5;

import lesson_7_junit5.Factorial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    private final Factorial factorial = new Factorial();

    @Test
    void testFactorial() {
        assertEquals(1, factorial.findFactorial(0));
        assertEquals(1, factorial.findFactorial(1));
        assertEquals(120, factorial.findFactorial(5));
        assertThrows(IllegalArgumentException.class, () -> factorial.findFactorial(-1));
    }
}
