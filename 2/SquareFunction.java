public class SquareFunction {
    private double a = 0;
    private double b = 0;
    private double c = 0;

    public SquareFunction(double p, double q, double r) {
        a = p;
        b = q;
        c = r;
    }

    public double apply(double x){
        return (a*(x*x) + b*x + c);
    }

    public static SquareFunction createFunction(double p, double q, double r){
        return new SquareFunction(p, q, r);
    }
}