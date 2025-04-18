package calculator.advanced;

import java.util.ArrayList;
import java.util.List;

public interface Calculator<T extends Number> {
    double doCalculate(T first, T second, OperatorType operator);

    void saveCalculateResult(CalculateResult<T> result);

    List<CalculateResult<T>> getCalculateResultList();

    void removeFirstCalculateResult();

    void clearCalculateResultList();

    List<CalculateResult<T>> getBiggerCase(T num);
}