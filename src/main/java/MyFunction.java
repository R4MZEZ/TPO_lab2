import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class MyFunction {

  private final Trigonometry tr;
  private final MyLog log;
  private double eps;

  public void setEps(double x) {
    this.eps = x;
  }
  public MyFunction() {
    tr = new Trigonometry();
    log = new MyLog();
    tr.setEps(eps);
    log.setEps(eps);
  }

  public double calculate(double x) {
    if (x <= 0) {
      return ((((Math.pow(tr.cos(x) / tr.tan(x), 3) * tr.sin(x)) / tr.sec(x))
          * ((tr.cos(x) - (tr.tan(x) * tr.sec(x))) / (tr.sec(x) + (tr.cos(x) * tr.cot(x))))));
    } else {
      return (((((log.log(x, 10) - log.log(x, 2)) * log.log(x, 2)) + (log.log(x, 10) / log.ln(x)))
          + log.log(x, 2)) + ((log.log(x, 10) / log.log(x, 2)) / log.log(x, 3)));
    }
  }

  public double writeCSV(double x, Writer out) {
    double res = calculate(x);
    try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
      printer.printRecord(x, res);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return res;
  }
}
