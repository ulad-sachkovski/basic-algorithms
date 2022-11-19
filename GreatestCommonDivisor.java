import java.util.Scanner;

//* The algorithm of finding the greatest common divisor of 2 positive integer numbers
//* THe code will ask to put 2 positive integer numbers (e.g. 10 and 35)

public class GreatestCommonDivisor {
    private static int findMaxDiv (int firstNum, int secondNum){
        if (firstNum == 0){
            return secondNum;}
        if (secondNum == 0){
            return firstNum;}
        if (firstNum >= secondNum){
            return findMaxDiv (firstNum % secondNum, secondNum);}
        if (firstNum < secondNum){
            return findMaxDiv (secondNum % firstNum, firstNum);}
        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Please, enter 2 positive integer numbers");
        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();
        int divider = findMaxDiv(firstNum, secondNum);
        System.out.println("The greatest common divider is: " + divider);
    }
}