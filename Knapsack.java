import java.util.Scanner;

// Find the maximum gold, that you can take in your knapsack (you can not split gold bar)
// given the capacity of knapsack 1 <= W <= 10^4 and number of gold bars 1 <= n <= 300
// with weight of each gold bar equals to 0 <= W <= 10^5

// The example of input:
// 10 3 1 4 8       (answer = 9)
// 7419 7 2 3 4 8 10 400 7000       (answer = 7419)
class Knapsack {
    private static int maxKnapSack(int[][] KnapSack, int[] values, int[] weights, int maxWeight) {

        for (int subjectsNumber = 0; subjectsNumber <= values.length; subjectsNumber++) {
            for (int capacity = 0; capacity <= maxWeight; capacity++) {

                if (subjectsNumber == 0 || capacity == 0) {
                    KnapSack[subjectsNumber][capacity] = 0;
                } else {

                    if (capacity >= weights[subjectsNumber - 1]) {
                        KnapSack[subjectsNumber][capacity] = Math.max(KnapSack[subjectsNumber - 1][capacity],
                                KnapSack[subjectsNumber - 1][capacity - weights[subjectsNumber - 1]] + values[subjectsNumber - 1]);
                    } else {
                        KnapSack[subjectsNumber][capacity] = KnapSack[subjectsNumber - 1][capacity];
                        KnapSack[subjectsNumber][capacity] = KnapSack[subjectsNumber - 1][capacity];
                    }
                }
            }
        }
        return KnapSack[values.length][maxWeight];
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("put the input data, please:");
        int maxWeight = scanner.nextInt();
        int numberOfGold = scanner.nextInt();

        int values[] = new int[numberOfGold];
        int weights[] = new int[numberOfGold];

        for (int i = 0; i < numberOfGold; i++) {
            values[i] = scanner.nextInt();
            weights[i] = values[i];
        }

        int[][] KnapSack = new int[values.length + 1][maxWeight + 1];
        int maxValue = maxKnapSack(KnapSack, values, weights, maxWeight);
        System.out.println("the maximum gold is " + maxValue);
    }

}
