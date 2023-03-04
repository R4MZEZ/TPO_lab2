import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class MyLn {

    private final static double DELTA = 0.0001;

    public double calculate(double rawX) {return calculate(rawX, DELTA);}

    public double calculate(double rawX, double delta) {
        if (Double.isNaN(rawX)) return  Double.NaN;
        if (rawX < 0) return Double.NaN;
        if (rawX == 0) return Double.NEGATIVE_INFINITY;
        double x;
        if (rawX > 1) x = 1/rawX - 1;
        else x = rawX - 1;
        double result = x, curItem = -x*x;
        int iter = 2, sign = -1;
        while(Math.abs(sign * Math.pow(x, iter)/(iter + 1) + curItem/iter) > delta/iter) {
            result += curItem/iter++;
            sign = -sign;
            curItem = sign * Math.pow(x, iter);
        }
        return rawX > 1 ? -result : result;
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
