package lesson_4;

public class Cat extends Animal {
    public static int totalCats = 0;
    private boolean fullness;

    public Cat(String name, int runLimit, int swimLimit) {
        super(name, runLimit, swimLimit);
        this.fullness = false;
        totalCats++;
    }

    public void eat(Bowl bowl) {
        if (!fullness && bowl.decreaseFood(20)) {
            fullness = true;
            System.out.println(name + " покушал и сыт.");
        } else {
            System.out.println(name + " решил не есть (мало еды или уже сыт).");
        }
    }
}
