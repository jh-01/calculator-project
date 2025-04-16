package calculator.basic;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int firstNumber;
        int secondNumber;
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

        System.out.print("사칙연산 기호를 입력하세요: ");
        char operator = sc.next().charAt(0);

        System.out.println("사칙연산 : " + operator);

        sc.close();
    }
}
