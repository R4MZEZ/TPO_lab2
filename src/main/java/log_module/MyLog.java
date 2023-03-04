package log_module;

import java.io.PrintWriter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class MyLog {

    private final static MyLn ln = new MyLn();
    private double eps = 0.0001;

    public MyLog(double eps) {
        this.eps = eps;
    }

    public void setEps(double x) {
        this.eps = x;
    }

    public double ln(double x) {
        return ln.calculate(x, eps);
    }

    public double log(double arg, double base) {
        return ln.calculate(arg, eps)/ln.calculate(base, eps);
    }

    public void writeCSV(double x, PrintWriter out) {
        try {
            CSVPrinter printer = CSVFormat.DEFAULT.print(out);
            printer.printRecord(x, ln(x), log(x, 2), log(x, 3), log(x, 10));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
