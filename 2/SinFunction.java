public class SinFunction {
    private double a = 0;

    public SinFunction(double p){
        a = p;
    }

    public double apply(double x){
        return (a * Math.sin(x));
    }

    public static SinFunction creaFunction(double p){
        return new SinFunction(p);
    }
}
