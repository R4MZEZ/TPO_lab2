package log_module;

import java.io.PrintWriter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class MyLog {

    private final static MyLn ln = new MyLn();
    private double eps = 0.0001;

    public void setEps(double x) {
        this.eps = x;
    }

    public double ln(double x) {
        return ln.calculate(x, eps);
    }

    public double log(double arg, double base) {
        return ln.calculate(arg, eps)/ln.calculate(base, eps);
    }

    public void writeLnCSV(double x, PrintWriter out) {
        out.print(x);
        out.print(",");
        out.println(ln(x));
    }

    public void writeLogCSV(double x, double base, PrintWriter out) {
        out.print(x);
        out.print(",");
        out.println(log(x, base));
    }
}
