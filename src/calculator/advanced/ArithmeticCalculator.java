package calculator.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    private final List<CalculateResult> calculateResultList = new ArrayList<>();

    public double doCalculate(T firstNumber, T secondNumber, OperatorType operator){
        double num1 = toDouble(firstNumber);
        double num2 = toDouble(secondNumber);
        return operator.apply(num1, num2);
    }

    private double toDouble(T num){
        return num.doubleValue();
    }

    public void saveCalculateResult(CalculateResult calculateResult){
        calculateResultList.add(calculateResult);
    }

    public void removeFirstCalculateResult(){
        calculateResultList.remove(0);
    }

    public List<CalculateResult> getCalculateResultList(){
        return calculateResultList;
    }

    public void clearCalculateResultList(){
        calculateResultList.clear();
    }

    public List<CalculateResult> getBiggerCase(T num){
        List<CalculateResult> biggerCaseList = calculateResultList
                .stream()
                .filter(result -> toDouble((T) result.getResult()) > toDouble(num))
                .collect(Collectors.toCollection(ArrayList::new));
        return biggerCaseList;
    }
}
