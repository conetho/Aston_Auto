package lesson_7_junit5;

public class Compare {

    public String compare(int a, int b) {
        if (a > b) {
            return a + " > " + b;
        } else if (a < b) {
            return a + " < " + b;
        } else {
            return "Числа равны";
        }
    }
}