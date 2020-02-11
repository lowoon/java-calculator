package domain;

import java.util.function.BiFunction;

enum Operator {
    PLUS("+", Integer::sum),
    MINUS("-", (first, second) -> first - second),
    MULTIPLICATION("*", (first, second) -> first * second),
    DIVISION("/", (first, second) -> first / second);

    String operator;
    BiFunction<Integer, Integer, Integer> computation;

    Operator(String operator, BiFunction<Integer, Integer, Integer> computation) {
        this.operator = operator;
        this.computation = computation;
    }

    @Override
    public String toString() {
        return operator;
    }
}
