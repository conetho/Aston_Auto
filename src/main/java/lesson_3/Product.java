package lesson_3;

class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String country;
    private int price;
    private boolean isBooked;

    public Product(String name, String productionDate, String manufacturer, String country, int price,
                   boolean isBooked) {
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
}