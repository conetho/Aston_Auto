package lesson_4;

import java.awt.Color;

public interface Shape {
    double getArea();
    Color getFillColor();
    Color getBorderColor();

    default double getPerimeter() {
        return 0;
    }

    default void printInfo(String name) {
        System.out.println("Фигура: " + name);
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println("-----------------------------------");
    }
}

class Circle implements Shape {
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

class Rectangle implements Shape {
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

class Triangle implements Shape {
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