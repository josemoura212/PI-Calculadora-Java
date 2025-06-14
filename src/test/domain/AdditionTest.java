package domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdditionTest {
    @Test
    void testAdditionPositiveNumbers() {
        Addition add = new Addition();
        assertEquals(5.0, add.execute(2, 3));
    }

    @Test
    void testAdditionNegativeNumbers() {
        Addition add = new Addition();
        assertEquals(-1.0, add.execute(2, -3));
    }

    @Test
    void testAdditionWithZero() {
        Addition add = new Addition();
        assertEquals(2.0, add.execute(2, 0));
    }
}
