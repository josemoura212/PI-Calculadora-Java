package domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DivisionTest {
    @Test
    void testDivisionPositiveNumbers() {
        Division div = new Division();
        assertEquals(2.0, div.execute(6, 3));
    }

    @Test
    void testDivisionNegativeNumbers() {
        Division div = new Division();
        assertEquals(-2.0, div.execute(6, -3));
    }

    @Test
    void testDivisionByZero() {
        Division div = new Division();
        assertThrows(ArithmeticException.class, () -> div.execute(2, 0));
    }
}
