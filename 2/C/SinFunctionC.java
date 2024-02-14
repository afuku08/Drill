public class SinFunctionC extends FunctionC{
    
    public SinFunctionC(double p){
        super(p);
    }

    public double apply(double x){
        return (a * Math.sin(x));
    }

    public static SinFunctionC createFunction(double p){
        return new SinFunctionC(p);
    }

    public String toString(){
        return ("y = " + a + "* Sin(x)");
    }
}
