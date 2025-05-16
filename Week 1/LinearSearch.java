package Week1;

import java.util.Random;
import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of array: ");
        int length = scanner.nextInt();

        System.out.print("Enter search value: ");
        int searchValue = scanner.nextInt();

        int[] array = new Random().ints(length, 0, length).toArray();

        LinearSearch searcher = new LinearSearch();
        System.out.print("The array: ");
        searcher.displayArray(array);

        int index = searcher.linearSearch(array, searchValue);
        System.out.println("\nFound " + searchValue + " at index: " + index);
    }

    public void displayArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.print("]");
    }

    public int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }
}
