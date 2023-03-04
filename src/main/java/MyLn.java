public class MyLn {

    private final static double DELTA = 0.0001;

    public double calculate(double rawX) {return calculate(rawX, DELTA);}

    public double calculate(double rawX, double delta) {
        if (rawX < 0) return Double.NaN;
        if (rawX == 0) return Double.NEGATIVE_INFINITY;
        double x;
        if (rawX > 1) x = 1/rawX - 1;
        else x = rawX - 1;
        double result = x, prevItem = x, curItem = -x*x;
        int iter = 2;
        while(Math.abs(curItem/iter + prevItem/(iter - 1)) > delta) {
            result += curItem/iter;
            prevItem = curItem;
            curItem *= -x;
            iter++;
        }
        return rawX > 1 ? -result : result;
    }
}
