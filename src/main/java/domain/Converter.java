package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import errors.InvalidInputException;

public class Converter {
    public static final int FIRST_INDEX = 0;
    public static final int SECOND_INDEX = 1;

    public NumberSentence getNumberSentence(String sentence) throws InvalidInputException {
        String[] arguments = sentence.split(" ");
        List<String> arg = Arrays.asList(arguments);

        validate(arg);

        return creatNumberSentence(arg);
    }

    private void validate(List<String> arguments) throws InvalidInputException {
        for (int i = 0; i < arguments.size(); i++) {
            validateEachString(i, arguments.get(i));
        }
    }

    private void validateEachString(int index, String argument) throws InvalidInputException {
        if (index % 2 == 0) {
            int num = Integer.parseInt(argument);
        }
        if (index % 2 != 0 && !isOperator(argument)) {
            throw new InvalidInputException("There something not operator in operator place");
        }
    }

    private boolean isOperator(String operator) {
        return Operator.PLUS.toString().equals(operator) || Operator.MINUS.toString().equals(operator) ||
                Operator.MULTIPLIFICATION.toString().equals(operator) || Operator.DIVISION.toString().equals(operator);
    }

    private NumberSentence creatNumberSentence(List<String> arguments) {
        List<Number> numbers = new ArrayList<>();
        Queue<Operator> operators = new LinkedList<>();

        for (int i = FIRST_INDEX; i < arguments.size(); i += 2) {
            numbers.add(new Number(Integer.parseInt(arguments.get(i))));
        }

        for (int i = SECOND_INDEX; i < arguments.size(); i += 2) {
            Operator operator = getOperator(arguments.get(i));
            operators.add(operator);
        }

        return new NumberSentence(numbers, operators);
    }

    private Operator getOperator(String operator) {
        if (Operator.PLUS.toString().equals(operator)) {
            return Operator.PLUS;
        } else if (Operator.MINUS.toString().equals(operator)) {
            return Operator.MINUS;
        } else if (Operator.MULTIPLIFICATION.toString().equals(operator)) {
            return Operator.MULTIPLIFICATION;
        } else {
            return Operator.DIVISION;
        }
    }
}
