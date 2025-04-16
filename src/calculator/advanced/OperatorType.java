package calculator.advanced;

public enum OperatorType {
    ADD('+'){
        public int apply(int firstNumber, int secondNumber){
            return firstNumber + secondNumber;
        }
    },
    SUBTRACT('-'){
        public int apply(int firstNumber, int secondNumber){
            return firstNumber - secondNumber;
        }
    },
    MULTIPLY('*'){
        public int apply(int firstNumber, int secondNumber){
            return firstNumber * secondNumber;
        }
    },
    DIVIDE('/'){
        public int apply(int firstNumber, int secondNumber){
            if (secondNumber != 0) return firstNumber / secondNumber;
            else throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
    };

    private char symbol;

    OperatorType(char c) {
        this.symbol = c;
    }

    public char getOperator() {
        return symbol;
    }

    public static OperatorType getOperatorType(char operator){
        for (OperatorType operatorType : OperatorType.values()) {
            if (operatorType.getOperator() == operator) return operatorType;
        }
        throw new IllegalArgumentException("올바르지 않은 연산자입니다: " + operator);
    }

    public abstract int apply(int firstNumber, int secondNumber);
}