import domain.Calculator;
import domain.NumberSentence;
import errors.InvalidInputException;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        NumberSentence numberSentence = createNumberSentence();

        Calculator calculator = new Calculator();
        int result = calculator.calculateNumberSentence(numberSentence);

        OutputView outputView = new OutputView();
        outputView.showCalculateResult(result);
    }

    private static NumberSentence createNumberSentence() {
        try {
            InputView inputView = new InputView(new Scanner(System.in));
            String sentence = inputView.receiveInput();

            return new NumberSentence(sentence);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            return createNumberSentence();
        }
    }
}
