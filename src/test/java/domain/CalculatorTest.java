package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void plus() {
        assertThat(Calculator.valueOf("PLUS").calculate(1,2)).isEqualTo(3);
    }
}