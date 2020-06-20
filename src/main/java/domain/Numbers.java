package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private final List<Integer> numbers;

    private Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers from(String[] inputNumbers) {
        List<Integer> numbers = Arrays.stream(inputNumbers)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        return new Numbers(numbers);
    }

    public int getFirstNumber() {
        return numbers.get(0);
    }

    public int getSecondNumber() {
        return numbers.get(1);
    }
}
