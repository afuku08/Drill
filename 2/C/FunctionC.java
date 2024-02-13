package C;

public class FunctionC {
    protected double a = 0;

    public FunctionC(double p) {
        a = p;
    }
    public double apply(double x) {
        return a;
    }
    public static FunctionC createFunction(double p) { 
        return new FunctionC(p);
    }
    public String toString() {
        return ("y = " + a );
    }
}