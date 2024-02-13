package C;

public class LinearFunctionC extends FunctionC{
    protected double b = 0;

    public LinearFunctionC(double p, double q){
        super(p);
        b = q;
    }

    public double apply(double x){
        return (a*x + b);
    }

    public static FunctionC creatFunction(double p, double q){
        return new LinearFunctionC(p, q);
    }

    public static FunctionC creatFunction(double p){
        return creatFunction(p, 0);
    }

    public String toString(){
        return ("y = " + a + "*x +" + b);
    }

}
