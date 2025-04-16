package calculator.advanced;

import java.util.ArrayList;

public class ArithmeticCalculator {
    private final ArrayList<CalculateResult> calculateResultList = new ArrayList<>();

    public int doCalculate(int firstNumber, int secondNumber, OperatorType operator){
        return operator.apply(firstNumber, secondNumber);
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
