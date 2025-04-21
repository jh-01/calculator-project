package calculator.oop;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final List<CalculateResult> calculateResultList = new ArrayList<>();

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

    public String removeFirstCalculateResult(){
        if(!calculateResultList.isEmpty()){
            calculateResultList.remove(0);
            return "첫번째 기록 삭제 완료!";
        } else {
            return "삭제할 기록이 없습니다!";
        }
    }

    public List<CalculateResult> getCalculateResultList(){
        return calculateResultList;
    }
}
