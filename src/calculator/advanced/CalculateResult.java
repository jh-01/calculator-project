package calculator.advanced;

public class CalculateResult<T> {
    private final T firstNumber;
    private final T secondNumber;
    private final OperatorType operator;
    private final T result;

    public CalculateResult(T firstNumber, T secondNumber, OperatorType operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
        this.result = null;
    }

    public CalculateResult(T firstNumber, T secondNumber, OperatorType operator, T result) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
        this.result = result;
    }

    @Override
    public String toString() {
        return String.format("[" + firstNumber + " " + operator.getOperator() + " " + secondNumber + "] = " + result);
    }
}
