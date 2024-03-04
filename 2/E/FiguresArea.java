public class FiguresArea {
    private double length;    // 一辺の長さ
    private String name;    // 図形の名前
    private double area;    // 面積

    public FiguresArea(String name,double length) {
        this.name = name;
        this.length = length;
    }
    public double getLength() {
        return length;
    }
    protected void setArea(double area) {
        this.area = area;
    }
    public double getArea() {
        return area;
    }
    public String toString() {
        return name;
    }
}
