package lesson_4;

import java.awt.*;

public class Rectangle implements Shape {
    private double width;
    private double length;
    private Color fillColor;
    private Color borderColor;

    public Rectangle(double width, double length, Color fillColor, Color borderColor) {
        this.width = width;
        this.length = length;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double getPerimeter() {
        return 2 * (width + length);
    }

    public double getArea() {
        return width * length;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }
}