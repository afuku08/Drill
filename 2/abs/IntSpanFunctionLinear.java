public class IntSpanFunctionLinear extends FunctionLinear implements IntSpanFunction{
    
    public IntSpanFunctionLinear(double p, double q){
        super(p, q);
    }

    public double intApply(double x){
        return apply((int)x);
    }

    public static Function createFunction(double p, double q) {
        return new IntSpanFunctionLinear(p, q);
    }

    public static Function createFunction(double p) {
        return createFunction(p, 0);
    }

    public String toString(String x) {
        return (super.toString("[" + x + "]"));
    }
}
