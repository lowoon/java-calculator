package domain;

import java.util.List;
import java.util.Queue;

public class Calculator {
    public int calculateNumberSentence(NumberSentence numberSentence) {
        Queue<Operator> operators = numberSentence.getOperators();
        List<Integer> numbers = numberSentence.getNumbers();
        int size = operators.size();
        int result = numbers.get(NumberSentence.FIRST_INDEX);

        for (int i = NumberSentence.FIRST_INDEX; i < size; i++) {
            result = operators.poll().computation.apply(result, numbers.get(i + 1));
        }

        return result;
    }
}
