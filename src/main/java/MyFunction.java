import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

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
          + log.log(x, 2)) + ((log.log(x, 10) / log.log(x, 2)) / log.log(x, 3)));
    }
  }

  public double writeCSV(double x, double eps, Writer out) {
    double res = calculate(x, eps);
    try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
      printer.printRecord(x, res);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return res;
  }
}
