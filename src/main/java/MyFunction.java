public class MyFunction {

  private final Trigonometry tr;
  private final MyLog log;
  private final static double DELTA = 0.0001;

  public MyFunction() {
    tr = new Trigonometry();
    log = new MyLog();
  }

  public double calculate(double x) {return calculate(x, DELTA);}

  public double calculate(double x, double eps) {
    if (x <= 0) {
      return ((((Math.pow(tr.cos(x, eps) / tr.tan(x, eps), 3) * tr.sin(x, eps)) / tr.sec(x, eps))
          * ((tr.cos(x, eps) - (tr.tan(x, eps) * tr.sec(x, eps))) / (tr.sec(x, eps) + (
          tr.cos(x, eps) * tr.cot(x, eps))))));
    } else {
      return (((((log.log(x, 10) - log.log(x, 2)) * log.log(x, 2)) + (log.log(x, 10) / log.ln(x)))
          + log.log(x, 10)) + ((log.log(x, 10) / log.log(x, 2)) / log.log(x, 3)));
    }
  }
}
