package domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum  Calculator {
    PLUS(1, Integer::sum),
    MINUS(2, (a, b) -> a - b),
    MULTIPLICATION(3, (a, b) -> a * b),
    DIVISION(4, (a, b) -> a / b);

    private final int option;
    private final BiFunction<Integer, Integer, Integer> calculator;

    Calculator(int option, BiFunction<Integer, Integer, Integer> calculator) {
        this.option = option;
        this.calculator = calculator;
    }

    public static Calculator from(int option) {
        return Arrays.stream(Calculator.values())
            .filter(calculator -> calculator.option == option)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("잘못된 선택 옵션입니다."));
    }

    public int calculate(int first, int second) {
        return calculator.apply(first, second);
    }
}
