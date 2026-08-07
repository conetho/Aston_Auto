package lesson_3;

public class LessonThree {
    public static void main(String[] args) {
        Park centralPark = new Park("Центральный парк");
        Park newPark = new Park("Новый парк");
        centralPark.addAttraction("Колесо обозрения", "10:00 - 22:00", 300);
        centralPark.addAttraction("Американские горки", "11:00 - 21:00", 450);
        newPark.addAttraction("Карусель", "09:00 - 22:00", 150);
        newPark.addAttraction("Американские горки", "11:00 - 21:00", 450);
        centralPark.displayParkInfo();
        newPark.displayParkInfo();
//        Со следующей строки начинается проверка класса Product, для удобства можно закомментировать код выше
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("Apple 360", "01.03.1683", "Isaac Newton", "England", 8888, false);
        productsArray[2] = new Product("Ant Tenna", "05.03.2026", "LG", "Korea", 45000, false);
        productsArray[3] = new Product("PS 0", "10000 yeas before our era", "A Random Caveman",
                "Probably Africa, i dunno", -1, true);
        productsArray[4] = new Product("Terminator", "29.08.2029", "Skynet", "Roboland", 1997, true);
        for (Product p : productsArray) {
            p.printInfo();
        }
    }
}