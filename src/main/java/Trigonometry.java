import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class Trigonometry {

  public double sin(double x, double exp) {
    MySin sin = new MySin();
    return sin.calculate(x, exp);
  }

  public double writeSinCSV(double x, Writer out) {
    double res = sin(x, eps);
    try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
      printer.printRecord(x, res);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return res;
  }

  public double cos(double x, double eps) {
    return sin(Math.PI/2 + x, eps);
  }

  public double writeCosCSV(double x, Writer out) {
    double res = cos(x, eps);
    try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
      printer.printRecord(x, res);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return res;
  }

  public double tan(double arg, double eps) {
    double x = arg - Math.PI * Math.floor((arg + Math.PI/2) / Math.PI);
    return (x > 0) ?  - sin(-x, eps) / cos(-x, eps) :  sin(x, eps) / cos(x, eps);
  }

  public double writeTanCSV(double x, Writer out) {
    double res = tan(x, eps);
    try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
      printer.printRecord(x, res);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return res;
  }

  public double sec(double x, double eps) {
    return 1/cos(-Math.abs(x), eps);
  }

  public double writeSecCSV(double x, Writer out) {
    double res = sec(x, eps);
    try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
      printer.printRecord(x, res);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return res;
  }

  public double cot(double x, double eps) {
    return 1/tan(x,eps);
  }

  public double writeCotCSV(double x, Writer out) {
    double res = cot(x, eps);
    try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
      printer.printRecord(x, res);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return res;
  }
}
