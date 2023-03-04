public class Trigonometry {

  public double sin(double x, double exp) {
    MySin sin = new MySin();
    return sin.calculate(x, exp);
  }

  public double cos(double x, double eps) {
    MySin sin = new MySin();
    x = sin.validate(x);

    if (Double.isNaN(x)) {
      return Double.NaN;
    }

    int sign = x > Math.PI / 2 || x < -Math.PI / 2 ? -1 : 1;

    return sign * Math.sqrt(1 - sin.calculate(x, eps) * sin.calculate(x, eps));
  }
}
