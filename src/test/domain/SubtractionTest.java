package domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubtractionTest {
    @Test
    void testSubtractionPositiveNumbers() {
        Subtraction sub = new Subtraction();
        assertEquals(1.0, sub.execute(5, 4));
    }

    @Test
    void testSubtractionNegativeNumbers() {
        Subtraction sub = new Subtraction();
        assertEquals(1.0, sub.execute(-3, -4));
    }

    @Test
    void testSubtractionWithZero() {
        Subtraction sub = new Subtraction();
        assertEquals(3.0, sub.execute(3, 0));
        assertEquals(-3.0, sub.execute(0, 3));
    }
}
