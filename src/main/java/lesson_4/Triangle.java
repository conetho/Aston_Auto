package lesson_4;

import java.awt.*;

public class Triangle implements Shape {
    private double a, b, c;
    private Color fillColor;
    private Color borderColor;

    public Triangle(double a, double b, double c, Color fillColor, Color borderColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double getPerimeter() {
        return a + b + c;
    }

    public double getArea() {
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public Color getFillColor() {
        return fillColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }
}