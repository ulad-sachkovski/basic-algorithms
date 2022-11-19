import java.util.Scanner;

//* The algorithm of finding the greatest common divisor of 2 positive integer numbers
//* THe code will ask to put 2 positive integer numbers (e.g. 10 and 35)

public class GreatestCommonDivisor {
    private static int findMaxDiv (int a, int b){
        if (a == 0){
            return b;}
        if (b == 0){
            return a;}
        if (a >= b){
            return findMaxDiv (a % b, b);}
        if (a < b){
            return findMaxDiv (b % a, a);}
        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Please, enter 2 positive integer numbers");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int divider = findMaxDiv(a, b);
        System.out.println("The greatest common divider is: " + divider);
    }
}