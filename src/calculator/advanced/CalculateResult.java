package calculator.advanced;

public class CalculateResult<T extends Number> {
    private final T firstNumber;
    private final T secondNumber;
    private final OperatorType operator;
    private final double result;

    public CalculateResult(T firstNumber, T secondNumber, OperatorType operator, double result) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
        this.result = result;
    }

    @Override
    public String toString() {
        return String.format("[%f %c %f] = %f",
                firstNumber.doubleValue(),
                operator.getOperator(),
                secondNumber.doubleValue(),
                result);
    }

    public double getResult() {
        return this.result;
    }
}
