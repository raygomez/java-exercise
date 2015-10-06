package shapes;

public class Square implements Shape {

    double side;

    public Square(double side) {
        this.side = side;
    }
    public double getArea() {
        return side * side;
    }
}
