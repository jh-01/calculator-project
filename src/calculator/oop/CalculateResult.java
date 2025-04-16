package calculator.oop;

public class CalculateResult {
    private final int firstNumber;
    private final int secondNumber;
    private final char operator;
    private final int result;

    public CalculateResult(int firstNumber, int secondNumber, char operator, int result) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
        this.result = result;
    }
    @Override
    public String toString() {
        return String.format("[%d %c %d] = %d", firstNumber, operator, secondNumber, result);
    }
}
