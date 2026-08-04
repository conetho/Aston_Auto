package lesson_2;
import java.util.Arrays;
import java.util.Scanner;

public class LessonTwo {
    public static void main(String[] args) {
//        printThreeWords()
//        checkSumSign();
//        printColor();
//        compareNumbers();
//        five();
//        six();
//        seven();
//        eight();
//        nine();
//        ten();
//        eleven();
//        twelve();
//        thirteen();
//        fourteen();
//        сверху все команды по порядку заданий, просто напишите их ниже в мэйне, с 5 задания данные нужно вводить в
//        консоль
        fourteen();
    }

    public static void printThreeWords() {
        String s1 = "Orange, " + "\n" + "Banana, " + "\n" + "Apple";
        System.out.print(s1);
    }

    public static void checkSumSign() {
        int a = 10;
        int b = 5;
        int sum = (a + b);
        if (sum >= 0) {
            System.out.print("Сумма положительная");
        } else if (sum < 0) {
            System.out.print("Сумма отрицательная");
        } else {
            System.out.print("Ошибка");
        }
    }

    public static void printColor() {
        int value = 101;
        if (value <= 0) {
            System.out.print("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.print("Желтый");
        } else if (value > 100) {
            System.out.print("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 9;
        int b = 10;
        if (a >= b) {
            System.out.print("a >= b");
        } else {
            System.out.print("a < b");
        }
    }

    public static boolean findFive(int a, int b) {
        return ((a + b >= 10) && (a + b <= 20));
    }

    public static void five() {
        Scanner read = new Scanner(System.in);
        int inputA = read.nextInt();
        int inputB = read.nextInt();
        System.out.println(findFive(inputA, inputB));
    }

    public static void findSix(int number) {
        if (number < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }

    public static void six() {
        Scanner read = new Scanner(System.in);
        int inputA = read.nextInt();
        findSix(inputA);
    }

    public static boolean findSeven(int a) {
        return a < 0;
    }

    public static void seven() {
        Scanner read = new Scanner(System.in);
        int inputA = read.nextInt();
        System.out.println(findSeven(inputA));
    }

    public static void findEight(String a, int b) {
        for (int i = 0; i < b; i++){
            System.out.println(a);
        }
    }

    public static void eight() {
        Scanner read = new Scanner(System.in);
        String inputA = read.nextLine();
        int inputB = read.nextInt();
        findEight(inputA, inputB);
    }

    public static boolean findNine(int a) {
        return (((a % 4 == 0) && (a % 100 != 0)) || ((a % 4 == 0) && (a % 100 == 0) && (a % 400 == 0)));
    }

    public static void nine() {
        Scanner read = new Scanner(System.in);
        int inputA = read.nextInt();
        System.out.println(findNine(inputA));
    }

    public static void ten(){
        int [] arr = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
            System.out.print(arr[i] + " ");
        }
    }

    public static void eleven() {
        int [] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");
        }
    }

    public static void twelve() {
        int[] arr = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
            System.out.print(arr[i] + " ");
        }
    }

    public static void thirteen() {
        int[][] table = new int[5][5];
        int size = table.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i == j) || (i + j == size - 1)) {
                    table[i][j] = 1;
                }
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] findFourteen(int len, int initialValue) {
        int[] arr = new int[len];
        Arrays.fill(arr, initialValue);
        return arr;
    }

    public static void fourteen() {
        Scanner read = new Scanner(System.in);
        int inputA = read.nextInt();
        int inputB = read.nextInt();
        System.out.print(Arrays.toString(findFourteen(inputA, inputB)));
    }
}