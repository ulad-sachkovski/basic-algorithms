import java.util.Scanner;

// Given the number of steps 1 <= n <= 100 and integer values of each step -10^4 <= a <= 10^4
// Find the maximum sum
// You can go up for 1 step or for 2 steps

// The code asks to put the number of steps and values for each step
// for example:
// 5 -64 -16 -13 -9 -48     (answer -73)
// 5 -2 -16 -13 -9 -48      (answer -63)

public class MaxSumLadder {

    private static int MaximumCoins(int[] Array) {
        int[] suppArray = new int[Array.length + 1];
        suppArray[0] = 0;
        suppArray[1] = Array[0];
        for (int i = 2; i < suppArray.length; i++) {
            if (suppArray[i - 2] + Array[i - 1] > suppArray[i - 1] + Array[i - 1]) {
                suppArray[i] = suppArray[i - 2] + Array[i - 1];
            } else {
                suppArray[i] = suppArray[i - 1] + Array[i - 1];
            }
        }

        int maximum = suppArray[suppArray.length - 1];
        return maximum;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, put the number of steps in ladder and values for each step");
        int ArrayVolume = scanner.nextInt();
        int[] Array = new int[ArrayVolume];
        for (int i = 0; i < ArrayVolume; i++) {
            Array[i] = scanner.nextInt();
        }
        long coins = MaximumCoins(Array);
        System.out.println("The maximum coins are: ");
        System.out.println(coins);
    }

}
