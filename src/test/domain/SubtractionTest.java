package domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubtractionTest {
    @Test
    void testSubtractionPositiveNumbers() {
        Subtraction sub = new Subtraction();
        assertEquals(1.0, sub.execute(3, 2));
    }

    @Test
    void testSubtractionNegativeResult() {
        Subtraction sub = new Subtraction();
        assertEquals(-1.0, sub.execute(2, 3));
    }

    @Test
    void testSubtractionWithZero() {
        Subtraction sub = new Subtraction();
        assertEquals(2.0, sub.execute(2, 0));
    }
}
