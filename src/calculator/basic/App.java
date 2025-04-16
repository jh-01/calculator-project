package calculator.basic;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int firstNumber = -1;
        int secondNumber = -1;
        char operator = 0;
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
                System.out.println("첫 번째 숫자 : " + firstNumber);
                System.out.println("두 번째 숫자 : " + secondNumber);
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
        System.out.println("사칙연산 : " + operator);

        sc.close();
    }


}
