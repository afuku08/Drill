package C;

public class SquareFunctionC extends FunctionC{
    protected double b = 0;
    protected double c = 0;

    public SquareFunctionC(double p, double q, double r){
        super(p);
        b = q;
        c = r;
    }

    public double apply(double x) { 
        return (((a * x + b) * x) + c);
    }

    public static FunctionC createFunction(double p){
        return createFunction(p,0,0);
    }

    public static FunctionC createFunction(double p, double q){
        return createFunction(p,q,0);
    }

    public static FunctionC createFunction(double p, double q, double r){
        return new SquareFunctionC(p,q,r);
    }

    public String toString(){
        return ("y = " + a + "*x*x +  + " + b + "*x + " + c);
    }
}
