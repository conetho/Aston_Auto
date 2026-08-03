package org.example;

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
            System.out.println(name + " остался голодным (мало еды или уже сыт).");
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

class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = Math.max(foodAmount, 0);
    }

    public boolean decreaseFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }


    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В миску добавили " + amount + " еды. Всего: " + getFoodAmount());
        }
    }


    public int getFoodAmount() {
        return foodAmount;
    }
}

