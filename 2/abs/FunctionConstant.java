public class FunctionConstant extends Function {
    private double a = 0;
    public FunctionConstant(double p) {
        a = p;
    }
    public double apply(double x) {
        return a;
    }
    public static Function createFunction(double p) {
        return new FunctionConstant(p);
    }
    public String toString(String x) {
        return ("" + a);
    }
}
