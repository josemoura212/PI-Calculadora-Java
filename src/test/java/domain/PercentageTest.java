package domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PercentageTest {
    @Test
    void testPercentageNormal() {
        Percentage perc = new Percentage();
        assertEquals(2.0, perc.execute(20, 10));
    }

    @Test
    void testPercentageZero() {
        Percentage perc = new Percentage();
        assertEquals(0.0, perc.execute(20, 0));
    }

    @Test
    void testPercentageNegative() {
        Percentage perc = new Percentage();
        assertEquals(-2.0, perc.execute(20, -10));
    }
}
