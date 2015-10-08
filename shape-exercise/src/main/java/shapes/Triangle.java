package shapes;

import shapes.Shape;

public class Triangle implements Shape {

    private final double height;
    private final double width;

    public Triangle(double height, double width) {
        this.height = height;
        this.width = width;
    }
    public double getArea() {
        return 0.5 * height * width;
    }
}
