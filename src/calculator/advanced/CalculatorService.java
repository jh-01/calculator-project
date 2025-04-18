package calculator.advanced;

import java.util.List;

public class CalculatorService<T extends Number> {
    private final ArithmeticCalculator<T> arithmeticCalculator = new ArithmeticCalculator();

    public CalculateResult<T> calculate(T firstNumber, T secondNumber, OperatorType operator){
        try {
            double result = arithmeticCalculator.doCalculate(firstNumber, secondNumber, operator);
            CalculateResult<T> calculateResult = new CalculateResult<>(firstNumber, secondNumber, operator, result);
            arithmeticCalculator.saveCalculateResult(calculateResult);
            return calculateResult;
        } catch (Exception e) {
            return null;
        }
    }

    public List<CalculateResult<T>> getResults() {
        return arithmeticCalculator.getCalculateResultList();
    }

    public List<CalculateResult<T>> getResultsGreaterThan(T num) {
        return arithmeticCalculator.getBiggerCase(num);
    }

    public void removeFirstCalculateResult(){
        arithmeticCalculator.removeFirstCalculateResult();
    }

    public void clearCalculateResultList(){
        arithmeticCalculator.clearCalculateResultList();
    }
}
