public class CircleArea extends FiguresArea {
    public CircleArea(double length) {
        super("circle",length);
        setArea(calcArea());
    }
    private double calcArea() {
        return (getLength() * getLength() * 3.14);
    }
}
