package domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdditionTest {
    @Test
    void testAdditionPositiveNumbers() {
        Addition add = new Addition();
        assertEquals(7.0, add.execute(3, 4));
    }

    @Test
    void testAdditionNegativeNumbers() {
        Addition add = new Addition();
        assertEquals(-7.0, add.execute(-3, -4));
    }

    @Test
    void testAdditionWithZero() {
        Addition add = new Addition();
        assertEquals(3.0, add.execute(3, 0));
        assertEquals(0.0, add.execute(0, 0));
    }
}
