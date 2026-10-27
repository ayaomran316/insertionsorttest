
import java.util.Random;

public class InsertionSortTest {

    // Insertion Sort Algorithm
    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];

            int j = i - 1;

            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];

                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        int size = 1_000_000;

        int[] original = new int[size];
        int[] randomArray = new int[size];
        int[] sortedArray = new int[size];

        Random rand = new Random();

        // Generate random elements
        for (int i = 0; i < size; i++) {
            original[i] = rand.nextInt(1_000_000);
        }

        // Copy random elements
        for (int i = 0; i < size; i++) {
            randomArray[i] = original[i];
        }

        // Create an already sorted array
        for (int i = 0; i < size; i++) {
            sortedArray[i] = i;
        }

        // Scenario 1: Random array
        long startRandom = System.nanoTime();

        insertionSort(randomArray);

        long endRandom = System.nanoTime();

        long randomTime = endRandom - startRandom;

        // Scenario 2: Already sorted array
        long startSorted = System.nanoTime();

        insertionSort(sortedArray);

        long endSorted = System.nanoTime();

        long sortedTime = endSorted - startSorted;

        // Print results
        System.out.println("Number of elements: " + size);

        System.out.println(
            "Random Array Time: " + randomTime + " nanoseconds"
        );

        System.out.println(
            "Sorted Array Time: " + sortedTime + " nanoseconds"
        );

        // Compare the two times
        System.out.println("\nComparison:");

        if (randomTime > sortedTime) {
            System.out.println(
                "Random array took more time than sorted array."
            );
        } else if (randomTime < sortedTime) {
            System.out.println(
                "Sorted array took more time than random array."
            );
        } else {
            System.out.println(
                "Both arrays took the same time."
            );
        }

        double difference = randomTime - sortedTime;

        System.out.println(
            "Time difference: " + difference + " nanoseconds"
        );
    }
}