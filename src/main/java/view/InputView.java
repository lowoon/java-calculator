package view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int receiveOption() {
        System.out.println("기능을 선택해 주세요");
        System.out.println("1.더하기");
        System.out.println("2.빼기");
        System.out.println("3.곱하기");
        System.out.println("4.나누기");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String receiveNumbers() {
        System.out.println("숫자를 입력해 주세요 (ex: (1,2))");
        return scanner.nextLine();
    }
}
