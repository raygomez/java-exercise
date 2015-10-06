package project;

import shapes.*;

/**
 * Hello world!
 *
 */
public class ShapeExercise
{
    public static void main( String[] args )
    {

        Shape circle = new Circle(30);
        Shape triangle = new Triangle(20, 20);
        Shape square = new Square(10);
        Shape rectangle = new Rectangle(20, 30);

        System.out.println("Area of square is:" + square.getArea());
        System.out.println("Area of circle is:" + circle.getArea());
        System.out.println("Area of rectangle is:" + rectangle.getArea());
        System.out.println("Area of triangle is:" + triangle.getArea());

    }
}
