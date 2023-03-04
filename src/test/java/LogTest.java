import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LogTest {
    @ParameterizedTest
    @ValueSource(doubles = {1, 2, 3, 5, 10, 0.1})
    public void generalTest(double x) {
        MyLog l = new MyLog();
        System.out.println(l.log(x, 2));
    }
}
