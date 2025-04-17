package calculator.advanced;

public class CalculateResult<T extends Number> {
    private final T firstNumber;
    private final T secondNumber;
    private final OperatorType operator;
    private final T result;

    public CalculateResult(T firstNumber, T secondNumber, OperatorType operator, T result) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
        this.result = result;
    }

    public CalculateResult(T firstNumber, T secondNumber, OperatorType operator, double result) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
        this.result = (T) (Number) result;
    }

    @Override
    public String toString() {
        return String.format("[%.0f %c %.0f] = %.0f",
                ((Number) firstNumber).doubleValue(),
                operator.getOperator(),
                ((Number) secondNumber).doubleValue(),
                ((Number) result).doubleValue());
    }

    public T getResult() {
        return this.result;
    }
}
