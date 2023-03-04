import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Trigonometry {

  private final static MySin sin = new MySin();
  private double eps = 0.0001;

  public void setEps(double x) {
    this.eps = x;
  }

  public double sin(double x) {
    return sin.calculate(x, eps);
  }

  public double cos(double x) {
    return sin(Math.PI/2 + x);
  }

  public double tan(double arg) {
    double x = arg - Math.PI * Math.floor((arg + Math.PI/2) / Math.PI);
    return (x > 0) ?  - sin(-x) / cos(-x) :  sin(x) / cos(x);
  }

  public double sec(double x) {
    return 1/cos(-Math.abs(x));
  }

  public double cot(double x) {
    return 1/tan(x);
  }

  public double writeCSV(double x, FunctionType type, Writer out) {
    double res = functionCSVMapper.get(type).apply(x);
    try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
      printer.printRecord(x, res);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return res;
  }

  Map<FunctionType, Function<Double, Double>> functionCSVMapper= new HashMap<>();
  {
    functionCSVMapper.put(FunctionType.SIN, this::sin);
    functionCSVMapper.put(FunctionType.COS, this::cos);
    functionCSVMapper.put(FunctionType.TAN, this::tan);
    functionCSVMapper.put(FunctionType.SEC, this::sec);
    functionCSVMapper.put(FunctionType.COT, this::cot);
  }

  enum FunctionType {
    SIN, COS, TAN, SEC, COT
  }
}
