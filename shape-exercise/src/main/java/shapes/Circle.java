package shapes;

import shapes.Shape;

public class Circle implements Shape {

    double radius;
    public Circle(double radius) {
        this.radius = radius;
    }


    public double getArea() {
        return Math.PI * radius * radius;
    }
}
