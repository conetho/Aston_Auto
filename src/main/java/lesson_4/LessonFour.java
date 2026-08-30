package lesson_4;

import java.awt.*;

public class LessonFour {
    public static void main(String[] args) {
        Dog bobik = new Dog("Бобик", 500, 10);
        bobik.run(150);
        bobik.swim(5);
        Bowl bowl = new Bowl(40);
        Cat[] cats = {
                new Cat("Барсик", 200, 0),
                new Cat("Мурзик", 200, 0),
                new Cat("Василий", 200, 0)
        };
        cats[1].swim(5);
        cats[0].run(150);
        for (Cat cat : cats) {
            cat.eat(bowl);
        }
        bowl.addFood(50);
        bowl.addFood(-100);
        System.out.println(bowl.getFoodAmount());
        cats[1].eat(bowl);
        cats[2].eat(bowl);
        System.out.println("Всего животных: " + Animal.totalAnimals);
        System.out.println("Всего котов: " + Cat.totalCats);
        System.out.println("Всего собак: " + Dog.totalDogs);
        System.out.println("-----------------------------------");
//        ниже код для проверки интерфейса Shape
        Shape circle = new Circle(5.0, Color.RED, Color.BLACK);
        Shape rectangle = new Rectangle(4.0, 6.0, Color.BLUE, Color.GREEN);
        Shape triangle = new Triangle(3.0, 4.0, 5.0, Color.YELLOW, Color.PINK);
        circle.printInfo("Круг");
        rectangle.printInfo("Прямоугольник");
        triangle.printInfo("Треугольник");
    }
}