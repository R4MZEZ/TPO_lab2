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
}
