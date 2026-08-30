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