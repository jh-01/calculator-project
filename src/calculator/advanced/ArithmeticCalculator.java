package calculator.advanced;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T> {
    private final ArrayList<CalculateResult> calculateResultList = new ArrayList<>();

    public double doCalculate(T firstNumber, T secondNumber, OperatorType operator){
        double num1 = toDouble(firstNumber);
        double num2 = toDouble(secondNumber);
        return operator.apply(num1, num2);
    }

    private double toDouble(T num){
        if(num instanceof Integer) return (int) num;
        else if(num instanceof Double) return (double) num;
        throw new IllegalArgumentException("지원하지 않는 타입입니다.");
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

    public void clearCalculateResultList(){
        calculateResultList.clear();
    }

    public ArrayList<CalculateResult> getBiggerCase(T num){
        ArrayList<CalculateResult> biggerCaseList = calculateResultList
                .stream()
                .filter(result -> toDouble((T) result.getResult()) > toDouble(num))
                .collect(Collectors.toCollection(ArrayList::new));
        return biggerCaseList;
    }
}
