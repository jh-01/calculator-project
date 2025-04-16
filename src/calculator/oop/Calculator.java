package calculator.oop;

import java.util.ArrayList;

public class Calculator {
    private final ArrayList<CalculateResult> calculateResultList = new ArrayList<>();

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
        return result;
    }

    public void saveCalculateResult(CalculateResult calculateResult){
        calculateResultList.add(calculateResult);
    }

    public void removeFirstCalculateResult(){
        calculateResultList.remove(0);
    }

    public ArrayList<CalculateResult> getCalculateResultList(){
        return calculateResultList;
    }
}
