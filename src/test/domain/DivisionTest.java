package domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DivisionTest {
    @Test
    void testDivisionPositiveNumbers() {
        Division div = new Division();
        assertEquals(2.0, div.execute(8, 4));
    }

    @Test
    void testDivisionNegativeNumbers() {
        Division div = new Division();
        assertEquals(2.0, div.execute(-8, -4));
        assertEquals(-2.0, div.execute(8, -4));
    }

    @Test
    void testDivisionWithZeroNumerator() {
        Division div = new Division();
        assertEquals(0.0, div.execute(0, 4));
    }

    @Test
    void testDivisionByZero() {
        Division div = new Division();
        assertThrows(ArithmeticException.class, () -> div.execute(2, 0));
    }
}
