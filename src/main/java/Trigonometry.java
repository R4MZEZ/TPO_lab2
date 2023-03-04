public class Trigonometry {

  public double sin(double x, double exp) {
    MySin sin = new MySin();
    return sin.calculate(x, exp);
  }

  public double cos(double x, double eps) {
    return sin(Math.PI/2 + x, eps);
  }

  public double tan(double arg, double eps) {
    double x = arg - Math.PI * Math.floor((arg + Math.PI/2) / Math.PI);
    return (x > 0) ?  - sin(-x, eps) / cos(-x, eps) :  sin(x, eps) / cos(x, eps);
  }

  public double sec(double x, double eps) {
    return 1/cos(-Math.abs(x), eps);
  }

  public double cot(double x, double eps) {
    return 1/tan(x,eps);
  }
}
