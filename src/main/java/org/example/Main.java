import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        nine();


    }
    public static void printThreeWords(){
        String s1 = "Orange, " + "\n" + "Banana, " + "\n" + "Apple";
        System.out.print(s1);
    }
    public static void checkSumSign(){
        int a = 10;
        int b = 5;
        int sum = (a + b);
        if (sum >= 0) {
            System.out.print("Сумма положительная");
        } else if (sum < 0) {
            System.out.print("Сумма отрицательная");
        }else {
            System.out.print("Ошибка");
        }
    }
    public static void printColor(){
        int value = 101;
        if (value <= 0) {
            System.out.print("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.print("Желтый");
        } else if (value > 100) {
            System.out.print("Зеленый");
        }
    }
    public static void compareNumbers(){
        int a = 9;
        int b = 10;
        if (a>=b){
            System.out.print("a>=b");
        } else {
            System.out.print("a<b");
        }
    }
    public static boolean findFive (int a, int b){
        return  ((a+b>=10) && (a+b<=20));

    }
    public static void five(){
        Scanner read = new Scanner(System.in);
        int inputA = read.nextInt();
        int inputB = read.nextInt();
        System.out.println(findFive(inputA, inputB));
    }
    public static void findSix(int number){
        if (number < 0) {
            System.out.println("Число отрицательное");
        }else {
            System.out.println("Число положительное");
        }
    }
    public static void six(){
        Scanner read = new Scanner(System.in);
        int inputA = read.nextInt();
        findSix(inputA);
    }
    public static boolean findSeven(int a){
        return a < 0;
    }
    public static void seven(){
        Scanner read = new Scanner(System.in);
        int inputA = read.nextInt();
        System.out.println(findSeven(inputA));
    }
    public static void findEight(String a, int b){
        for (int i = 0; i < b; i++){
            System.out.println(a);
        }
    }
    //Сначала вводим предложение, потом кол-во повторений
    public static void eight(){
        Scanner read = new Scanner(System.in);
        String inputA = read.nextLine();
        int inputB = read.nextInt();
        findEight(inputA, inputB);
    }
    public static boolean findNine(int a){
        return ( ((a % 4 == 0) && (a % 100 != 0)) || ((a % 4 == 0) && (a % 100 == 0) && (a % 400 == 0)));

    }
    public static void nine(){
        Scanner read = new Scanner(System.in);
        int inputA = read.nextInt();
        System.out.println(findNine(inputA));
    }

}