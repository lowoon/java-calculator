import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import domain.Calculator;
import domain.Numbers;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        int option = InputView.receiveOption();
        Calculator calculator = Calculator.from(option);

        String inputNumbers = InputView.receiveNumbers();
        String[] eachNumbers = inputNumbers.substring(1, 4).split(",");
        Numbers numbers = Numbers.from(eachNumbers);

        int result = calculator.calculate(numbers.getFirstNumber(), numbers.getSecondNumber());
        OutputView.printResult(result);
    }
}
