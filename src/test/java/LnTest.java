import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LnTest {
    @ParameterizedTest
    @ValueSource(doubles = {1, 2, 3, 5, 10, 0.1})
    public void generalTest(double x) {
        MyLn l = new MyLn();
        System.out.println(l.calculate(x));
    }
}
