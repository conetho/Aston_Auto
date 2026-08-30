package junit5;

import lesson_7_junit5.TriangleArea;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleAreaTest {

    private final TriangleArea triangleArea = new TriangleArea();

    @Test
    void testTriangleArea () {
        assertEquals(6.0, triangleArea.findArea(3, 4, 5), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> triangleArea.findArea(1, 2, 10));
    }
}
