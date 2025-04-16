package calculator.oop;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int firstNumber;
        int secondNumber;
        int result;
        char operator;
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        do {
            firstNumber = calculator.readNumber(sc, "첫 번째 숫자를 입력하세요: ");
            secondNumber = calculator.readNumber(sc, "두 번째 숫자를 입력하세요: ");
            operator = calculator.readOperator(sc, "사칙연산 기호(+, -, *, /)를 입력하세요: ");
            try {
                result = calculator.doCalculate(firstNumber, secondNumber, operator);
                System.out.printf("[결과] %d %c %d = %d\n", firstNumber, operator, secondNumber, result);
            } catch (Exception e) {
                System.out.println("오류 발생: " + e.getMessage());
            }
        } while (!calculator.askContinue(sc));
        sc.close();
    }

}
