package calculator.oop;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            int menu = printMenu(sc);
            if (menu == -1) break;
            else if(menu == 1) callCalculator(sc, calculator);
            else if(menu == 2) printResultList(calculator);
            else if(menu == 3) {
                String resultString = calculator.removeFirstCalculateResult();
                System.out.println(resultString);
            }
        }
        sc.close();
    }

    private static int printMenu(Scanner sc){
        int inputNumber;

        System.out.println("**************************************************************************");
        System.out.println("계산기 프로그램");
        System.out.println("1. 사칙연산 수행");
        System.out.println("2. 연산 기록 출력");
        System.out.println("3. 가장 오래된 연산 기록 삭제");
        while (true) {
            System.out.print("무엇을 도와드릴까요? (숫자로 입력. exit 입력 시 종료) : ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                return -1;
            }

            try {
                inputNumber = Integer.parseInt(input);
                if (inputNumber < 1 || inputNumber > 3) {
                    System.out.println("1, 2, 3 중 하나의 숫자를 입력해주세요.");
                    continue;
                }
                break; // 유효한 숫자 입력 시 루프 종료
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요!");
            }
        }
        return inputNumber;
    }

    private static void callCalculator(Scanner sc, Calculator calculator){
        int firstNumber;
        int secondNumber;
        int result;
        char operator;

        firstNumber = readNumber(sc, "첫 번째 숫자를 입력하세요: ");
        secondNumber = readNumber(sc, "두 번째 숫자를 입력하세요: ");
        operator = readOperator(sc);
        try {
            result = calculator.doCalculate(firstNumber, secondNumber, operator);
            System.out.printf("[결과] %d %c %d = %d\n", firstNumber, operator, secondNumber, result);
            CalculateResult calculateResult = new CalculateResult(firstNumber, secondNumber, operator, result);
            calculator.saveCalculateResult(calculateResult);
        } catch (Exception e) {
            System.out.printf("[오류] %d %c %d 계산 중 오류: %s\n", firstNumber, operator, secondNumber, e.getMessage());
        }
    }

    private static int readNumber(Scanner sc, String message){
        int inputNumber = -1;
        boolean isValid = true;

        while (isValid) {
            System.out.print(message);
            String input = sc.nextLine();

            try {
                inputNumber = Integer.parseInt(input);
                isValid = false;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요!!");
            }
        }
        return inputNumber;
    }

    private static char readOperator(Scanner sc){
        while(true){
            System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
            String operatorInput = sc.nextLine().trim();
            if(operatorInput.length() == 1 && "+-*/".contains(operatorInput)) return operatorInput.charAt(0);
            else System.out.println("잘못된 입력입니다. 사칙연산 기호(+, -, *, /)만 입력해주세요!!");
        }
    }

    private static void printResultList(Calculator calculator){
        List<CalculateResult> resultList = calculator.getCalculateResultList();
        for(CalculateResult result : resultList){
            System.out.println(result.toString());
        }
    }
}
