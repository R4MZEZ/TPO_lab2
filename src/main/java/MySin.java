public class MySin {

  private final static double DELTA = 0.0001;

  public double calculate(double x) {
    return calculate(x, DELTA);
  }

  public double calculate(double x, double eps) {
    if (x == Double.NEGATIVE_INFINITY || x == Double.POSITIVE_INFINITY || Double.isNaN(x)) {
      return Double.NaN;
    } else if (x > 0) {
      while (x > Math.PI) {
        x -= 2 * Math.PI;
      }
    } else if (x < 0) {
      while (x < -Math.PI) {
        x += 2 * Math.PI;
      }
    }

    double res = x, term = x;
    double divisible = x * x * x;
    long divider = 6, sign = -1, pow = 3;

    while (Math.abs(term + sign * divisible / divider) > eps) {
      term = sign * (divisible / divider);
      res += term;

      sign *= -1;
      divisible *= x * x;
      divider = divider * ++pow * ++pow;
    }

    return res;
  }

}
