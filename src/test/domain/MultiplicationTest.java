package domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MultiplicationTest {
    @Test
    void testMultiplicationPositiveNumbers() {
        Multiplication mul = new Multiplication();
        assertEquals(12.0, mul.execute(3, 4));
    }

    @Test
    void testMultiplicationNegativeNumbers() {
        Multiplication mul = new Multiplication();
        assertEquals(12.0, mul.execute(-3, -4));
        assertEquals(-12.0, mul.execute(3, -4));
    }

    @Test
    void testMultiplicationWithZero() {
        Multiplication mul = new Multiplication();
        assertEquals(0.0, mul.execute(0, 4));
        assertEquals(0.0, mul.execute(3, 0));
    }
}
