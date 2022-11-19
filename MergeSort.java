import java.util.Arrays;
import java.util.Scanner;

// Algorithm of mergesort
// Code asks to put the size of array and value for each element of array
// The example of input:
// 10 10 9 8 7 6 5 4 3 2 1      (answer: 1 2 3 4 5 6 7 8 9 10)
// 5 -300 -700 2 -24 35         (answer: -700 -300 -24 2 35)

public class MergeSort {
    private static int[] mergeSort(int[] inputArray) {

        if (inputArray.length < 2) {
            return inputArray;
        }

        int midIndex = inputArray.length / 2;
        int[] leftArray = new int[midIndex];
        int[] rightArray = new int[inputArray.length - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftArray[i] = inputArray[i];
        }
        for (int j = midIndex; j < inputArray.length; j++) {
            rightArray[j - midIndex] = inputArray[j];
        }

        mergeSort(rightArray);
        mergeSort(leftArray);

        return merge(inputArray, leftArray, rightArray);
    }

    private static int[] merge(int[] inputArray, int[] leftArray, int[] rightArray) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                inputArray[k] = leftArray[i];
                i++;
            } else {
                inputArray[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            inputArray[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            inputArray[k] = rightArray[j];
            j++;
            k++;
        }

        return inputArray;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] unsortedArray = new int[size];

        for (int i = 0; i < size; i++) {
            unsortedArray[i] = scanner.nextInt();
        }

        int[] sortedArray = mergeSort(unsortedArray);
        System.out.println("The sorted array is:");
        Arrays.stream(sortedArray).forEach(x -> System.out.print(x + " "));
    }
}
