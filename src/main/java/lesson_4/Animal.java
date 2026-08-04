package lesson_4;

class Animal {
    protected String name;
    protected int runLimit;
    protected int swimLimit;
    public static int totalAnimals = 0;

    public Animal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        totalAnimals++;
    }

    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не смог пробежать " + distance + " м.");
        }
    }

    public void swim(int distance) {
        if (swimLimit == 0) {
            System.out.println(name + " не умеет плавать.");
        } else if (distance <= swimLimit) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не смог проплыть " + distance + " м.");
        }
    }
}

class Cat extends Animal {
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

class Dog extends Animal {
    public static int totalDogs = 0;

    public Dog(String name, int runLimit, int swimLimit) {
        super(name, runLimit, swimLimit);
        totalDogs++;
    }
}