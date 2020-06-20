package domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    void getFirstNumber() {
        String[] inputNumbers = Arrays.array("1", "2");
        Numbers numbers = Numbers.from(inputNumbers);
        assertThat(numbers.getFirstNumber()).isEqualTo(1);
    }

    @Test
    void getSecondNumber() {
        String[] inputNumbers = Arrays.array("1", "2");
        Numbers numbers = Numbers.from(inputNumbers);
        assertThat(numbers.getSecondNumber()).isEqualTo(2);
    }
}