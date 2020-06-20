package domain;

import java.util.function.BiFunction;

public enum  Calculator {
    PLUS(Integer::sum),
    MINUS((a, b) -> a - b),
    MULTIPLICATION((a, b) -> a * b);

    private final BiFunction<Integer, Integer, Integer> calculator;

    Calculator(BiFunction<Integer, Integer, Integer> calculator) {
        this.calculator = calculator;
    }

    public int calculate(int first, int second) {
        return calculator.apply(first, second);
    }
}
