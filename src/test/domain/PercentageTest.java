package domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PercentageTest {
    @Test
    void testPercentagePositiveNumbers() {
        Percentage perc = new Percentage();
        assertEquals(2.0, perc.execute(20, 10)); // 10% de 20 = 2
    }

    @Test
    void testPercentageNegativeNumbers() {
        Percentage perc = new Percentage();
        assertEquals(-2.0, perc.execute(20, -10)); // -10% de 20 = -2
        assertEquals(2.0, perc.execute(-20, -10)); // -10% de -20 = 2
    }

    @Test
    void testPercentageWithZero() {
        Percentage perc = new Percentage();
        assertEquals(0.0, perc.execute(0, 10));
        assertEquals(0.0, perc.execute(20, 0));
    }
}
