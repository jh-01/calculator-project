package calculator.basic;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int firstNumber;
        int secondNumber;
        int result;
        char operator;
        Scanner sc = new Scanner(System.in);

        do {
            firstNumber = readNumber(sc, "첫 번째 숫자를 입력하세요: ");
            secondNumber = readNumber(sc, "두 번째 숫자를 입력하세요: ");
            operator = readOperator(sc, "사칙연산 기호(+, -, *, /)를 입력하세요: ");
            try {
                result = doCalculate(firstNumber, secondNumber, operator);
                System.out.printf("[결과] %d %c %d = %d\n", firstNumber, operator, secondNumber, result);
            } catch (Exception e) {
                System.out.println("오류 발생: " + e.getMessage());
            }
        } while (!askContinue(sc));
        sc.close();
    }
    public static int readNumber(Scanner sc, String message){
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

    public static char readOperator(Scanner sc, String message){
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

    public static int doCalculate(int firstNumber, int secondNumber, char operator){
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
        return result;
    }

    public static boolean askContinue(Scanner sc){
        System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
        String input = sc.nextLine();
        return input.equals("exit");
    }
}
