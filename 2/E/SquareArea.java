public class SquareArea extends FiguresArea{
    public SquareArea(double length) {
        super("square", length);
        setArea(calcArea());
    }

    private double calcArea(){
        return (getLength() * getLength());
    }
}
