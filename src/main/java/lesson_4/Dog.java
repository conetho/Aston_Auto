package lesson_4;

public class Dog extends Animal {
    public static int totalDogs = 0;

    public Dog(String name, int runLimit, int swimLimit) {
        super(name, runLimit, swimLimit);
        totalDogs++;
    }
}