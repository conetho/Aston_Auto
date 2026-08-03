package org.example;

public class Main {
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
        cats[1].eat(bowl);
        cats[2].eat(bowl);
        System.out.println("Всего животных: " + Animal.totalAnimals);
        System.out.println("Всего котов: " + Cat.totalCats);
        System.out.println("Всего собак: " + Dog.totalDogs);
    }
}