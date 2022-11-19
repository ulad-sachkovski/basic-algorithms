import java.util.Arrays;
import java.util.Scanner;

// Algorithm of quicksort
// Code asks to put the size of array and value for each element of array
// The example of input:
// 10 10 9 8 7 6 5 4 3 2 1      (answer: 1 2 3 4 5 6 7 8 9 10)
// 5 -300 -700 2 -24 35         (answer: -700 -300 -24 2 35)

public class QuickSort {

    private static int[] quickSort(int[] array, int start, int end) {
        if (start >= end) return null;
        int anchor = partition(array, start, end);
        quickSort(array, start, anchor - 1);
        quickSort(array, anchor + 1, end);

        return array;
    }

    private static int partition(int[] array, int start, int end) {
        int anchor = array[start];
        int counter = start;

        for (int i = start + 1; i <= end; i++) {
            if (array[i] <= anchor) {
                counter++;
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
            }
        }

        int temp = array[counter];
        array[counter] = array[start];
        array[start] = temp;

        return counter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] unsortedArray = new int[size];

        for (int i = 0; i < size; i++) {
            unsortedArray[i] = scanner.nextInt();
        }

        int[] sortedArray = quickSort(unsortedArray, 0, size - 1);
        System.out.println("The sorted array is:");
        Arrays.stream(sortedArray).forEach(x -> System.out.print(x + " "));

    }
}
