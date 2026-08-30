package lesson_4;

import java.awt.*;

public class Circle implements Shape {
    private double radius;
    private Color fillColor;
    private Color borderColor;

    public Circle(double radius, Color fillColor, Color borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }
}