public class CompositFunction extends Function{
    private Function f;
    private Function g;

    public CompositFunction(Function f, Function g) {
        f = f;
        g = g;
    }

    public double apply(double x){
        return (f.apply(g.apply(x)));
    }

    public static Function composFunction(Function f, Function g){
        return new CompositFunction(f, g);
    }

    public String toString(String x){
        return (f.toString("(" +g.toString(x) +")"));
    }
}
