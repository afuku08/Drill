public class TriangleArea extends FiguresArea{
    public TriangleArea(double length){
        super("triangle", length);
        setArea(calcArea());
    }

    private double calcArea() {
        return (getLength() * getLength() * 0.433);
    }
}
