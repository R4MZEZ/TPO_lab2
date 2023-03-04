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
    tr.setEps(DELTA);
  }

  @Test
  public void forceBurst() {
    for (int x = -200; x < 200; x ++) {
      assertAll(((double)x) / 100);
    }
  }

  @ParameterizedTest
  @ValueSource(doubles = {-10.0, -1.01, -1, -0.99, -0.01, 0, 10.0, 1.01, 1, 0.99, 0.01, Double.NaN,
      Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
  public void generalTest(double param) {
    if (param == 0){
      System.out.println();
    }
    assertAll(param);
  }

  private void assertAll(double param) {

    Assertions.assertEquals(Math.sin(param), tr.sin(param), DELTA);
    Assertions.assertEquals(Math.cos(param), tr.cos(param), DELTA);
    Assertions.assertEquals(Math.tan(param), tr.tan(param), DELTA);
    Assertions.assertEquals(1 / Math.cos(param), tr.sec(param), DELTA);
    Assertions.assertEquals(1 / Math.tan(param), tr.cot(param), DELTA);
  }

  @ParameterizedTest
  @ValueSource(doubles = {-0.99, -0.01, 0})
  public void symmetricalTest(double param) {
    Assertions.assertEquals(Math.sin(param), -tr.sin(-param), DELTA);
    Assertions.assertEquals(Math.cos(param), tr.cos(-param), DELTA);
    Assertions.assertEquals(Math.tan(param), -tr.tan(-param), DELTA);
    Assertions.assertEquals(1 / Math.cos(param), tr.sec(-param), DELTA);
    Assertions.assertEquals(1 / Math.tan(param), -tr.cot(-param), DELTA);
  }
}