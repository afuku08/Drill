public class MulFunction extends Function{
    private double a = 0;
    private Function f;
    private Function g;

    public MulFunction(double p, Function ff, Function gg){
        a = p;
        f = ff;
        g = gg;
    }

    public static Function mulFunction(double p, Function f, Function g){
        return new MulFunction(p, f, g);
    }

    public static Function mulFunction(Function f, Function g){
        return mulFunction(1, f, g);
    }

    public double apply(double x){
        return (a * f.apply(x) * g.apply(x));
    }

    public String toString(String x){
        return (a + "*" + f.toString(x) + "*" + g.toString(x));
    }
}
