import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

class FunctionTest {

    Map<Double, Double> parameterAnswer = new HashMap<>();
    {
        parameterAnswer.put(-1.5, 0.0);
        parameterAnswer.put(-3.545, 4.683);
        parameterAnswer.put(-2.543, 0.0);
        parameterAnswer.put(-2.392, 0.061);
        parameterAnswer.put(-5.534, -0.061);
        parameterAnswer.put(-5.684, 0.0);
        parameterAnswer.put(-4.5, 0.0);
        parameterAnswer.put(-9.828, 4.683);
        parameterAnswer.put(0.0, Double.NEGATIVE_INFINITY);
        parameterAnswer.put(0.695, -1.192);
        parameterAnswer.put(3.822, 0.0);
        parameterAnswer.put(1.15, 2.974);
        parameterAnswer.put(2.0, 1.212);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1.5, -3.545, -2.543, -2.392, -5.534, -5.684, -4.5, -9.828, 0.0, 0.695, 3.822, 1.15, 2.0})
    public void generalTest(double x) {
        MyFunction func = new MyFunction();
        Assertions.assertEquals(parameterAnswer.get(x), func.calculate(x), 0.001);
    }
}