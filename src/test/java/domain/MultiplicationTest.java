package domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MultiplicationTest {
    @Test
    void testMultiplicationPositiveNumbers() {
        Multiplication mul = new Multiplication();
        assertEquals(6.0, mul.execute(2, 3));
    }

    @Test
    void testMultiplicationByZero() {
        Multiplication mul = new Multiplication();
        assertEquals(0.0, mul.execute(2, 0));
    }

    @Test
    void testMultiplicationNegativeNumbers() {
        Multiplication mul = new Multiplication();
        assertEquals(-6.0, mul.execute(2, -3));
    }
}
