import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TrigonometryTest {

  private static double DELTA;
  private static Trigonometry tr;

  @BeforeAll
  static void init() {
    DELTA = 0.0001;
    tr = new Trigonometry();
  }

  @ParameterizedTest
  @ValueSource(doubles = {-10.0, -1.01, -1, -0.99, -0.01, 0, 10.0, 1.01, 1, 0.99, 0.01, Double.NaN,
      Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
  public void generalTest(double param) {
    Assertions.assertEquals(Math.sin(param), tr.sin(param, DELTA), DELTA);
    Assertions.assertEquals(Math.cos(param), tr.cos(param, DELTA), DELTA);
    Assertions.assertEquals(Math.tan(param), tr.tan(param, DELTA), DELTA);
    Assertions.assertEquals(1 / Math.cos(param), tr.sec(param, DELTA), DELTA);
    Assertions.assertEquals(1 / Math.tan(param), tr.cot(param, DELTA), DELTA);
  }

  @ParameterizedTest
  @ValueSource(doubles = {-0.99, -0.01, 0})
  public void symmetricalTest(double param) {
    Assertions.assertEquals(Math.sin(param), -tr.sin(-param, DELTA), DELTA);
    Assertions.assertEquals(Math.cos(param), tr.cos(-param, DELTA), DELTA);
    Assertions.assertEquals(Math.tan(param), -tr.tan(-param, DELTA), DELTA);
    Assertions.assertEquals(1 / Math.cos(param), tr.sec(-param, DELTA), DELTA);
    Assertions.assertEquals(1 / Math.tan(param), -tr.cot(-param, DELTA), DELTA);
  }
}