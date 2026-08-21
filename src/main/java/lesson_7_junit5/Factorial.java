package lesson_7_junit5;

public class Factorial {

    public long findFactorial(int n){
        if (n < 0) {
            throw new IllegalArgumentException("Цифра не должна быть отрицательной");
        }
        if (n <= 1) {
            return 1;
        }
        return n * findFactorial(n-1);
    }
}