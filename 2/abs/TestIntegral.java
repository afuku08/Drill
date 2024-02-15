interface DoubleIteration {
    boolean hasNext();
    double next();
}

class IntegralRectangles implements DoubleIteration {
    private double x;
    private double b;
    private double dx;
    private Function fun;

    public IntegralRectangles(Function ff, double aa, double bb, double nn) {
        x = aa;
        b = bb;
        dx = (bb - aa) / nn;
        fun = ff;
    }

    /*終了判定 */
    /*@return boolean */
    public boolean hasNext() {
        return x < b;
    }

    public double next() {
        double s = x * fun.apply(dx);
        x += dx;
        return s;
    }

    public String toString() {
        return "∫(" + fun.toString() + ")dx";
    }
}

public class TestIntegral {
    
}
