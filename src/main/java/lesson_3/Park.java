package lesson_3;

import java.util.ArrayList;
import java.util.List;

public class Park {
    private String parkName;
    private List<Attraction> attractionList = new ArrayList<>();

    public Park(String parkName) {
        this.parkName = parkName;
    }

    public class Attraction {
        private String name;
        private String workingHours;
        private int price;

        public Attraction(String name, String workingHours, int price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void displayAttractionInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Цена: " + price + " руб.");
            System.out.println("-------------------");
        }
    }

    public void addAttraction(String name, String workingHours, int price) {
        Attraction attraction = new Attraction(name, workingHours, price);
        attractionList.add(attraction);
    }

    public void displayParkInfo() {
        System.out.println("Парк: " + parkName);
        System.out.println("Список аттракционов:");
        System.out.println("-------------------");
        for (Attraction a : attractionList) {
            a.displayAttractionInfo();
        }
    }
}