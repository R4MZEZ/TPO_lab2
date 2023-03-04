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

    public double writeLnCSV(double x, Writer out) {
        double res = ln(x);
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
            printer.printRecord(x, res);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
}
