package calculator.oop;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    private final ArrayList<CalculateResult> calculateResultList = new ArrayList<>();

    public int readNumber(Scanner sc, String message){
        int inputNumber = -1;
        boolean isValid = true;

        while (isValid) {
            System.out.print(message);
            String input = sc.nextLine();

            try {
                inputNumber = Integer.parseInt(input);
                isValid = false;
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요!!");
            }
        }
        return inputNumber;
    }

    public char readOperator(Scanner sc, String message){
        char operator;
        System.out.print(message);
        String operatorInput = sc.nextLine();

        while (!(operatorInput.equals("+") || operatorInput.equals("-") || operatorInput.equals("*") || operatorInput.equals("/"))) {
            System.out.println("⚠️ 잘못된 입력입니다. 사칙연산 기호(+, -, *, /)만 입력해주세요.");
            System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
            operatorInput = sc.next();
        }
        operator = operatorInput.charAt(0);
        return operator;
    }

    public boolean askContinue(Scanner sc){
        System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
        String input = sc.nextLine();
        return input.equals("exit");
    }
    public int doCalculate(int firstNumber, int secondNumber, char operator){
        int result = 0;

        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber != 0) result = firstNumber / secondNumber;
                else throw new ArithmeticException("0으로 나눌 수 없습니다.");
                break;
        }
        saveCalculateResult(firstNumber, secondNumber, operator, result);
        return result;
    }

    private void saveCalculateResult(int firstNumber, int secondNumber, char operator, int result){
        calculateResultList.add(new CalculateResult(firstNumber, secondNumber, operator, result));
    }
}
