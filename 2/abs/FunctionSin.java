public class FunctionSin extends Function{
    private double a = 0;
    
    public FunctionSin(double p){
        a = p;
    }

    public double apply(double x){
        return (a * Math.sin(x));
    }

    public static Function createFunction(double p){
        return new FunctionSin(p);
    }

    public String toString(String x){
        return (a + "*Sin(" + x + ")");
    }
}
