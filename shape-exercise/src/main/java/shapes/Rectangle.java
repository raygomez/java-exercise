package shapes;

public class Rectangle implements Shape{

    private final double length;
    private final double height;

    public Rectangle(double length, double height) {
        this.length = length;
        this.height = height;
    }
    public double getArea() {
        return length * height;
    }
}
