package calculator.advanced;

import java.util.ArrayList;
import java.util.Scanner;

public class CalculatorUI<T> {
    private final Scanner sc = new Scanner(System.in);

    public void runCalculator(){
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();

        while (true) {
            int menu = printMenu();
            if (menu == -1) break;
            else if(menu == 1) callCalculator(arithmeticCalculator);
            else if(menu == 2) printResultList(arithmeticCalculator);
            else if(menu == 3) arithmeticCalculator.removeFirstCalculateResult();
        }
        sc.close();
    }

    public int printMenu(){
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
                    System.out.println("⚠️ 1, 2, 3 중 하나의 숫자를 입력해주세요.");
                    continue;
                }
                break; // 유효한 숫자 입력 시 루프 종료
            } catch (NumberFormatException e) {
                System.out.println("⚠️ 숫자를 입력해주세요!");
            }
        }
        return inputNumber;
    }

    public void callCalculator(ArithmeticCalculator<T> arithmeticCalculator){
        OperatorType operator;
        T firstNumber = (T) readNumber("첫 번째 숫자를 입력하세요: ");
        T secondNumber = (T) readNumber("두 번째 숫자를 입력하세요: ");
        operator = readOperator("사칙연산 기호(+, -, *, /)를 입력하세요: ");
        try {
            double result = arithmeticCalculator.doCalculate(firstNumber, secondNumber, operator);
            System.out.printf("[결과] %s %c %s = %s\n", firstNumber, operator.getOperator(), secondNumber, result);
            CalculateResult calculateResult = new CalculateResult(firstNumber, secondNumber, operator, result);
            arithmeticCalculator.saveCalculateResult(calculateResult);
        } catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage());
        }
    }

    public Number readNumber(String message){
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            try {
                if(isInteger(input)) return Integer.parseInt(input);
                else return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요!!");
            }
        }
    }

    public boolean isInteger(String str){
        return !str.contains(".");
    }

    public OperatorType readOperator(String message){
        System.out.print(message);
        OperatorType operatorType = null;

        while (true) {
            System.out.print(message);
            String operatorInput = sc.nextLine();

            if (operatorInput.length() == 1) {
                try{
                    operatorType = OperatorType.getOperatorType(operatorInput.charAt(0));
                    break;
                } catch (Exception e) {
                    System.out.println("잘못된 입력입니다.");
                }
            }
            else System.out.println("잘못된 입력입니다.");
        }
        return operatorType;
    }


    public void printResultList(ArithmeticCalculator arithmeticCalculator){
        ArrayList<CalculateResult> resultList = arithmeticCalculator.getCalculateResultList();
        for(CalculateResult result : resultList){
            System.out.println(result.toString());
        }
    }
}
