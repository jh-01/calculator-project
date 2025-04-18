package calculator.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> implements Calculator<T> {
    private final List<CalculateResult<T>> calculateResultList = new ArrayList<>();

    public double doCalculate(T firstNumber, T secondNumber, OperatorType operator){
        double num1 = toDouble(firstNumber);
        double num2 = toDouble(secondNumber);
        return operator.apply(num1, num2);
    }

    private double toDouble(T num){
        return num.doubleValue();
    }

    public void saveCalculateResult(CalculateResult<T> calculateResult){
        calculateResultList.add(calculateResult);
    }

    public void removeFirstCalculateResult(){
        calculateResultList.remove(0);
    }

    public List<CalculateResult<T>> getCalculateResultList(){
        return calculateResultList;
    }

    public void clearCalculateResultList(){
        calculateResultList.clear();
    }

    public List<CalculateResult<T>> getBiggerCase(T num){
        List<CalculateResult<T>> biggerCaseList = calculateResultList
                .stream()
                .filter(result -> result.getResult() > toDouble(num))
                .collect(Collectors.toCollection(ArrayList::new));
        return biggerCaseList;
    }
}
