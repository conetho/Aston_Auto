package junit5;

import lesson_7_junit5.Compare;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompareTest {

    private final Compare compareNumbers = new Compare();

    @Test
    public void compare() {
        assertEquals("5 > 4", compareNumbers.compare(5, 4));
        assertEquals("10 < 20", compareNumbers.compare(10, 20));
        assertEquals("Числа равны", compareNumbers.compare(10, 10));
    }
}
