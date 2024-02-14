public class FunctionSquare extends Function {
    private double a = 0;
    private double b = 0;
    private double c = 0;

    public FunctionSquare(double p,double q,double r) {
        a = p;
        b = q;
        c = r;
    }
    public double apply(double x) {
        return (((a * x + b) * x) + c);
    }
    public static Function createFunction(double p) { 
        return createFunction(p,0,0);
    }
    public static Function createFunction(double p,double q) { 
        return createFunction(p,q,0);
    }
    public static Function createFunction(double p,double q,double r) { 
        return new FunctionSquare(p,q,r);
    }
    public String toString(String x) {
        return (a + "*" + x + "*" + x + " + " + b +  "*" + x + " + " + c);
    }
}