package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void plus() {
        assertThat(Calculator.valueOf("PLUS").calculate(1, 2)).isEqualTo(3);
    }

    @Test
    void minus() {
        assertThat(Calculator.valueOf("MINUS").calculate(2, 1)).isEqualTo(1);
    }

    @Test
    void multiplication() {
        assertThat(Calculator.valueOf("MULTIPLICATION").calculate(2, 1)).isEqualTo(2);
    }

    @Test
    void division() {
        assertThat(Calculator.valueOf("DIVISION").calculate(4, 2)).isEqualTo(2);
    }
}