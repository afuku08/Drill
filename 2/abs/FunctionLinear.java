public class FunctionLinear extends Function{
    private double a = 0;
    private double b = 0;
    
    public FunctionLinear(double p, double q){
        a = p;
        b = q;
    }

    public double apply(double x){
        return (a*x + b);
    }

    public static Function createFunction(double p, double q){
        return new FunctionLinear(p, q);
    }

    public static Function createFunction(double p){
        return createFunction(p, 0);
    }

    public String toString(String x){
        return (a + "*" + x + "+" + b);
    }
}
