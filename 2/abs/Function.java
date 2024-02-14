public abstract class Function {
    public abstract double apply(double x);
    public String toString() {
        return toString("X");
    }
    public abstract String toString(String x);
}
