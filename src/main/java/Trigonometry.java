import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class Trigonometry {

  private final static MySin sin = new MySin();
  private double eps = 0.0001;

  public void setEps(double x) {
    this.eps = x;
  }

  public double sin(double x) {
    return sin.calculate(x, eps);
  }

  public double writeSinCSV(double x, Writer out) {
    double res = sin(x);
    try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
      printer.printRecord(x, res);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return res;
  }

  public double cos(double x) {
    return sin(Math.PI/2 + x);
  }

  public double writeCosCSV(double x, Writer out) {
    double res = cos(x);
    try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
      printer.printRecord(x, res);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return res;
  }

  public double tan(double arg) {
    double x = arg - Math.PI * Math.floor((arg + Math.PI/2) / Math.PI);
    return (x > 0) ?  - sin(-x) / cos(-x) :  sin(x) / cos(x);
  }

  public double writeTanCSV(double x, Writer out) {
    double res = tan(x);
    try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
      printer.printRecord(x, res);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return res;
  }

  public double sec(double x) {
    return 1/cos(-Math.abs(x));
  }

  public double writeSecCSV(double x, Writer out) {
    double res = sec(x);
    try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
      printer.printRecord(x, res);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return res;
  }

  public double cot(double x) {
    return 1/tan(x);
  }

  public double writeCotCSV(double x, Writer out) {
    double res = cot(x);
    try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
      printer.printRecord(x, res);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return res;
  }
}
