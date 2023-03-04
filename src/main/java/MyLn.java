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
}
