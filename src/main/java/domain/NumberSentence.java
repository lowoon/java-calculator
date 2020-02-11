package domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

import errors.InvalidInputException;

public class NumberSentence {
    /**
     *  NumberSentence는 계산식을 의미합니다.
     */
    public static final int FIRST_INDEX = 0;
    public static final int SECOND_INDEX = 1;
    public static final int COUNT_UNIT = 2;
    public static final String DELIMITER = " ";

    private List<Integer> numbers;
    private Queue<Operator> operators = new LinkedList<>();

    public NumberSentence(String sentence) throws InvalidInputException {
        String[] arguments = sentence.split(DELIMITER);
        List<String> arg = Arrays.asList(arguments);

        validate(arg);

        createNumberSentence(arg);
    }

    private void validate(List<String> arguments) throws InvalidInputException {
        for (int i = FIRST_INDEX; i < arguments.size(); i++) {
            validateEachString(i, arguments.get(i));
        }
    }

    private void validateEachString(int index, String argument) throws InvalidInputException {
        if (index % COUNT_UNIT == 0) {
            try {
                int num = Integer.parseInt(argument);
            } catch (NumberFormatException e) {
                throw new InvalidInputException("There something not number in number place");
            }

        }
        if (index % COUNT_UNIT != 0 && !isOperator(argument)) {
            throw new InvalidInputException("There something not operator in operator place");
        }
    }

    private boolean isOperator(String operator) {
        return Arrays.stream(Operator.values())
                .anyMatch(o -> o.toString().equals(operator));
    }

    private void createNumberSentence(List<String> arguments) {
        List<Integer> numbers = new ArrayList<>();
        Queue<Operator> operators = new LinkedList<>();

        for (int i = FIRST_INDEX; i < arguments.size(); i += COUNT_UNIT) {
            numbers.add(Integer.parseInt(arguments.get(i)));
        }

        for (int i = SECOND_INDEX; i < arguments.size(); i += COUNT_UNIT) {
            Operator operator = getOperator(arguments.get(i));
            operators.add(operator);
        }

        this.numbers = numbers;
        this.operators = operators;
    }

    private Operator getOperator(String operator) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.toString().equals(operator))
                .findFirst()
                .get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberSentence that = (NumberSentence) o;
        return Objects.equals(numbers, that.numbers) &&
                Objects.equals(operators, that.operators);
    }

    Queue<Operator> getOperators() {
        return operators;
    }

    List<Integer> getNumbers() {
        return numbers;
    }
}
