package calculator.basic;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int firstNumber = 0;
        int secondNumber = 0;
        int result = 0;
        char operator;
        boolean isValid = true;
        Scanner sc = new Scanner(System.in);

        while (true){
            while (isValid) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                String fistInput = sc.nextLine();
                System.out.print("두 번째 숫자를 입력하세요: ");
                String secondInput = sc.nextLine();

                try {
                    firstNumber = Integer.parseInt(fistInput);
                    secondNumber = Integer.parseInt(secondInput);
                    isValid = false;
                } catch (NumberFormatException e) {
                    System.out.println("숫자를 입력해주세요!!");
                }
            }

            System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
            String operatorInput = sc.nextLine();

            while (!(operatorInput.equals("+") || operatorInput.equals("-") || operatorInput.equals("*") || operatorInput.equals("/"))) {
                System.out.println("⚠️ 잘못된 입력입니다. 사칙연산 기호(+, -, *, /)만 입력해주세요.");
                System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
                operatorInput = sc.next();
            }
            operator = operatorInput.charAt(0);
            isValid = true;

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
                    else {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        isValid = false;
                    }
                    break;
            }
            if (isValid) {
                System.out.println("결과: ");
                System.out.printf("%d %c %d = %d\n", firstNumber, operator, secondNumber, result);
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
            String input = sc.nextLine();
            if (input.equals("exit")) {
                break;
            }
        }

        sc.close();
    }
}
