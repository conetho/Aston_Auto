package org.example;

class Product {
    private String name;
    private String productionDate;

    private String manufacturer;
    private String country;
    private int price;
    private boolean isBooked;

    public Product(String name, String productionDate, String manufacturer, String country, int price, boolean isBooked) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.isBooked = isBooked;
    }
    public void printInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + country);
        System.out.println("Цена: " + price);
        System.out.println("Забронирован: " + (isBooked ? "Да" : "Нет"));
        System.out.println("-------------------");
    }
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("Apple 360", "01.03.1683", "Isaac Newton", "England", 8888, false);
        productsArray[2] = new Product("Ant Tenna", "05.03.2026", "LG", "Korea", 45000, false);
        productsArray[3] = new Product("PS 0", "10000 yeas before our era", "A Random Caveman", "Probably Africa, i dunno", -1, true);
        productsArray[4] = new Product("Terminator", "29.08.2029", "Skynet", "Roboland", 1997, true);

        for (Product p : productsArray) {
            p.printInfo();
        }
    }

}




