package calculator.advanced;

import java.util.List;

public class CalculatorService<T extends Number> {
    private final ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();

    public CalculateResult<T> calculate(T firstNumber, T secondNumber, OperatorType operator){
        try {
            double result = arithmeticCalculator.doCalculate(firstNumber, secondNumber, operator);
            T typedResult = (T) (Number) result;
            CalculateResult<T> calculateResult = new CalculateResult<>(firstNumber, secondNumber, operator, typedResult);
            arithmeticCalculator.saveCalculateResult(calculateResult);
            return calculateResult;
        } catch (Exception e) {
            return null;
        }
    }

    public List<CalculateResult> getResults() {
        return arithmeticCalculator.getCalculateResultList();
    }

    public List<CalculateResult> getResultsGreaterThan(T num) {
        return arithmeticCalculator.getBiggerCase(num);
    }

    public void removeFirstCalculateResult(){
        arithmeticCalculator.removeFirstCalculateResult();
    }

    public void clearCalculateResultList(){
        arithmeticCalculator.clearCalculateResultList();
    }
}
