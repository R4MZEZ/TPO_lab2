import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class MyLog {

    private final static MyLn ln = new MyLn();

    private Double exp = 0.0001;

    public void setExp(double x) {
        this.exp = x;
    }

    public double ln(double x) {
        return ln.calculate(x, exp);
    }

    public double log(double arg, double base) {
        return ln.calculate(arg, exp)/ln.calculate(base, exp);
    }

    public double writeLnCSV(double x, Writer out) {
        double res = ln(x, eps);
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)){
            printer.printRecord(x, res);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
}
