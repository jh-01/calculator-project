package calculator.basic;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int firstNumber = sc.nextInt();
        System.out.print("두 번째 숫자를 입력하세요: ");
        int secondNumber = sc.nextInt();
        System.out.print("사칙연산 기호를 입력하세요: ");
        char operator = sc.next().charAt(0);

        System.out.println("첫 번째 숫자 : " + firstNumber);
        System.out.println("두 번째 숫자 : " + secondNumber);
        System.out.println("사칙연산 : " + operator);

        sc.close();
    }
}
