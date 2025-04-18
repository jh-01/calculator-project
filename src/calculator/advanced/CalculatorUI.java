package calculator.advanced;

import java.util.List;
import java.util.Scanner;

public class CalculatorUI<T extends Number> {
    private final Scanner sc = new Scanner(System.in);
    private final CalculatorService<T> calculatorService = new CalculatorService<>();

    public void runCalculator(){
        while (true) {
            int menu = printMenu();
            if (menu == -1) break;
            else if(menu == 1) callCalculator();
            else if(menu == 2) printAllCalculateResult();
            else if(menu == 3) getResultsGreaterThan();
            else if(menu == 4) calculatorService.removeFirstCalculateResult();
            else if(menu == 5) calculatorService.clearCalculateResultList();
        }
        sc.close();
    }

    public int printMenu(){
        int inputNumber;

        System.out.println("**************************************************************************");
        System.out.println("계산기 프로그램");
        System.out.println("1. 사칙연산 수행");
        System.out.println("2. 연산 기록 출력");
        System.out.println("3. 입력한 값보다 큰 결과값을 가진 연산 기록 출력");
        System.out.println("4. 가장 오래된 연산 기록 삭제");
        System.out.println("5. 전체 연산 기록 삭제");

        while (true) {
            System.out.print("무엇을 도와드릴까요? (숫자로 입력. exit 입력 시 종료) : ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                return -1;
            }

            try {
                inputNumber = Integer.parseInt(input);
                if (inputNumber < 1 || inputNumber > 5) {
                    System.out.println("⚠️ 1, 2, 3, 4, 5 중 하나의 숫자를 입력해주세요.");
                    continue;
                }
                break; // 유효한 숫자 입력 시 루프 종료
            } catch (NumberFormatException e) {
                System.out.println("⚠️ 숫자를 입력해주세요!");
            }
        }
        return inputNumber;
    }

    public void callCalculator(){
        OperatorType operator;
        T firstNumber = (T) readNumber("첫 번째 숫자를 입력하세요: ");
        T secondNumber = (T) readNumber("두 번째 숫자를 입력하세요: ");
        operator = readOperator("사칙연산 기호(+, -, *, /)를 입력하세요: ");
        try {
            CalculateResult<T> calculateResult = calculatorService.calculate(firstNumber, secondNumber, operator);
            System.out.println(calculateResult.toString());
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
        OperatorType operatorType;

        while(true){
            System.out.print(message);
            String operatorInput = sc.nextLine().trim();
            if(operatorInput.length() == 1 && "+-*/".contains(operatorInput)){
                operatorType = OperatorType.getOperatorType(operatorInput.charAt(0));
                break;
            }
            else System.out.println("잘못된 입력입니다. 사칙연산 기호(+, -, *, /)만 입력해주세요!!");
        }
        return operatorType;
    }

    public void printAllCalculateResult(){
        List<CalculateResult<T>> calculateResultList = calculatorService.getResults();
        printResultList(calculateResultList);
    }

    public void printResultList(List<CalculateResult<T>> calculateResultList){
        if(calculateResultList.isEmpty()) System.out.println("연산 결과가 비어있습니다!");
        else {
            System.out.println("[연산 결과 목록]");
            for(CalculateResult result : calculateResultList) System.out.println(result.toString());
        }
    }

    public void getResultsGreaterThan(){
        T num = (T) readNumber("기준이 될 숫자를 입력하세요 : ");
        List<CalculateResult<T>> calculateResultList = calculatorService.getResultsGreaterThan(num);
        printResultList(calculateResultList);
    }
}
