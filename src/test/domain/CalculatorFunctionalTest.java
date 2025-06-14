package domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorFunctionalTest {
    @Test
    void testAddition() {
        Calculator calc = new Calculator();
        assertEquals(7.0, calc.calculate("+", 3, 4)); // positivos
        assertEquals(-7.0, calc.calculate("+", -3, -4)); // negativos
        assertEquals(3.0, calc.calculate("+", 3, 0)); // zero
        assertEquals(0.0, calc.calculate("+", 0, 0)); // ambos zero
    }

    @Test
    void testSubtraction() {
        Calculator calc = new Calculator();
        assertEquals(1.0, calc.calculate("-", 5, 4)); // positivos
        assertEquals(1.0, calc.calculate("-", -3, -4)); // negativos
        assertEquals(3.0, calc.calculate("-", 3, 0)); // zero
        assertEquals(-3.0, calc.calculate("-", 0, 3)); // zero - positivo
    }

    @Test
    void testMultiplication() {
        Calculator calc = new Calculator();
        assertEquals(12.0, calc.calculate("×", 3, 4)); // positivos
        assertEquals(12.0, calc.calculate("×", -3, -4)); // negativos
        assertEquals(-12.0, calc.calculate("×", 3, -4)); // misto
        assertEquals(0.0, calc.calculate("×", 0, 4)); // zero
        assertEquals(0.0, calc.calculate("×", 3, 0)); // zero
    }

    @Test
    void testDivision() {
        Calculator calc = new Calculator();
        assertEquals(2.0, calc.calculate("/", 8, 4)); // positivos
        assertEquals(2.0, calc.calculate("/", -8, -4)); // negativos
        assertEquals(-2.0, calc.calculate("/", 8, -4)); // misto
        assertEquals(0.0, calc.calculate("/", 0, 4)); // zero no numerador
        assertThrows(ArithmeticException.class, () -> calc.calculate("/", 2, 0)); // divisão por zero
    }

    @Test
    void testPercentage() {
        Calculator calc = new Calculator();
        assertEquals(2.0, calc.calculate("%", 20, 10)); // positivos
        assertEquals(-2.0, calc.calculate("%", 20, -10)); // negativo no percentual
        assertEquals(2.0, calc.calculate("%", -20, -10)); // ambos negativos
        assertEquals(0.0, calc.calculate("%", 0, 10)); // zero no valor
        assertEquals(0.0, calc.calculate("%", 20, 0)); // zero no percentual
    }

    @Test
    void testInvalidOperator() {
        Calculator calc = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calc.calculate("^", 2, 3));
    }

    @Test
    void testMixedOperationsPositive() {
        Calculator calc = new Calculator();
        double add = calc.calculate("+", 2, 3); // 5
        double sub = calc.calculate("-", add, 1); // 4
        double mul = calc.calculate("×", sub, 2); // 8
        double div = calc.calculate("/", mul, 4); // 2
        assertEquals(2.0, div);
    }

    @Test
    void testMixedOperationsWithZero() {
        Calculator calc = new Calculator();
        double add = calc.calculate("+", 0, 0); // 0
        double mul = calc.calculate("×", add, 5); // 0
        double sub = calc.calculate("-", mul, 3); // -3
        double perc = calc.calculate("%", sub, 50); // -1.5
        assertEquals(-1.5, perc);
    }

    @Test
    void testMixedOperationsNegative() {
        Calculator calc = new Calculator();
        double add = calc.calculate("+", -2, -3); // -5
        double mul = calc.calculate("×", add, -2); // 10
        double div = calc.calculate("/", mul, -5); // -2
        double perc = calc.calculate("%", div, 25); // -0.5
        assertEquals(-0.5, perc);
    }

    @Test
    void testDivisionByZeroInSequence() {
        Calculator calc = new Calculator();
        double add = calc.calculate("+", 2, 2); // 4
        assertThrows(ArithmeticException.class, () -> calc.calculate("/", add, 0));
    }
}
