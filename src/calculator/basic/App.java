package calculator.basic;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int firstNumber = 0;
        int secondNumber = 0;
        int result = 0;
        char operator;
        boolean isVaild = true;
        Scanner sc = new Scanner(System.in);

        while (isVaild){
            System.out.print("첫 번째 숫자를 입력하세요: ");
            String fistInput = sc.nextLine();
            System.out.print("두 번째 숫자를 입력하세요: ");
            String secondInput = sc.nextLine();

            try{
                firstNumber = Integer.parseInt(fistInput);
                secondNumber = Integer.parseInt(secondInput);
                isVaild = false;
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요!!");
            }
        }

        System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
        String operatorInput = sc.next();

        while (!(operatorInput.equals("+") || operatorInput.equals("-") || operatorInput.equals("*") || operatorInput.equals("/"))) {
            System.out.println("⚠️ 잘못된 입력입니다. 사칙연산 기호(+, -, *, /)만 입력해주세요.");
            System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
            operatorInput = sc.next();
        }
        operator = operatorInput.charAt(0);
        isVaild = true;

        switch (operator) {
            case '+': result = firstNumber + secondNumber;
                break;
            case '-': result = firstNumber - secondNumber;
                break;
            case '*': result = firstNumber * secondNumber;
                break;
            case '/': if(secondNumber != 0) result = firstNumber / secondNumber;
            else {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                isVaild = false;
            }
                break;
        }
        if(isVaild) {
            System.out.println("결과: ");
            System.out.printf("%d %c %d = %d", firstNumber, operator, secondNumber, result);
        }

        sc.close();
    }
}
