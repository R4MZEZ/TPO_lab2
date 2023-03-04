public class Trigonometry {

  public double sin(double x, double exp) {
    MySin sin = new MySin();
    return sin.calculate(x, exp);
  }

  public double cos(double x, double eps) {
    int sign = x > Math.PI / 2 || x < -Math.PI / 2 ? -1 : 1;
    return sign * Math.sqrt(1 - sin(x, eps) * sin(x, eps));
  }

  public double tan(double x, double eps) {
    return sin(x, eps) / cos(x, eps);
  }

  public double sec(double x, double eps) {
    return 1/cos(x, eps);
  }

  public double cot(double x, double eps) {
    return 1/tan(x,eps);
  }
}
