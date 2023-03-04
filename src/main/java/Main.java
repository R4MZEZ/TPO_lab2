import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import log_module.MyLog;

public class Main {

  public static void main(String[] args) {
    String func = "Func";


    String inPath = "C:\\Users\\User\\Desktop\\тпо\\lab2\\src\\main\\resources\\CsvFiles\\Inputs\\" + func + "In.csv";
    String outPath = "C:\\Users\\User\\Desktop\\тпо\\lab2\\src\\main\\resources\\CsvFiles\\Outputs\\" + func + "Out.csv";
    File f = new File(inPath);

    try (Scanner scanner = new Scanner(f);
        PrintWriter writer = new PrintWriter(outPath, StandardCharsets.UTF_8)) {

      scanner.useDelimiter(",");
      int start = scanner.nextInt(), end = scanner.nextInt();
      double step = Double.parseDouble(scanner.next()), eps = Double.parseDouble(scanner.next());

//      Trigonometry tr = new Trigonometry();
//      tr.setEps(eps);
//
//      for (double x = start; x <= end; x += step) {
//        tr.writeCSV(x/10, FunctionType.valueOf(func.toUpperCase(Locale.ROOT)), writer);
//      }

//      MyLog lg = new MyLog();
//      lg.setEps(eps);
//
//      for (double x = start; x <= end; x += step) {
//        lg.writeLnCSV(x/10, writer);
//      }

      MyFunction fn = new MyFunction();
      fn.setEps(eps);

      for (double x = start; x <= end; x += step) {
        fn.writeCSV(x/10, writer);
      }

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
