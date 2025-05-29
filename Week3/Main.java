package Week3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Bubble Sort");
            System.out.println("2. Quick Sort");
            System.out.println("3. Binary Search");
            System.out.println("4. Stack Demo");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    runBubbleSort(scanner);
                    break;
                case "2":
                    runQuickSort(scanner);
                    break;
                case "3":
                    runBinarySearch(scanner);
                    break;
                case "4":
                    runStack(scanner);
                    break;
                case "5":
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void runBubbleSort(Scanner scanner) {
        int n = readPositiveInt(scanner, "Enter number of elements: ");
        int[] arr = generateRandomArray(n);
        System.out.println("Unsorted: " + Arrays.toString(arr));
        BubbleSort.sort(arr);
        System.out.println("Sorted:   " + Arrays.toString(arr));
    }

    private static void runQuickSort(Scanner scanner) {
        int n = readPositiveInt(scanner, "Enter number of elements: ");
        int[] arr = generateRandomArray(n);
        System.out.println("Unsorted: " + Arrays.toString(arr));
        QuickSort.sort(arr, 0, arr.length - 1);
        System.out.println("Sorted:   " + Arrays.toString(arr));
    }

    private static void runBinarySearch(Scanner scanner) {
        int n = readPositiveInt(scanner, "Enter number of elements: ");
        int[] arr = generateRandomArray(n);
        Arrays.sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));

        int target = readInt(scanner, "Enter number to search: ");
        int index = BinarySearch.search(arr, target);
        if (index == -1) {
            System.out.println("Value not found.");
        } else {
            System.out.println("Found " + target + " at index " + index);
        }
    }

    private static void runStack(Scanner scanner) {
        MyStack stack = new MyStack();

        while (true) {
            System.out.println("\n--- Stack Menu ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Get Top");
            System.out.println("4. Show All");
            System.out.println("0. Return");
            System.out.print("Choose option: ");
            String op = scanner.nextLine();

            switch (op) {
                case "1":
                    int value = readInt(scanner, "Enter value to push: ");
                    stack.push(value);
                    break;
                case "2":
                    Integer popped = stack.pop();
                    System.out.println("Popped: " + (popped != null ? popped : "Stack is empty"));
                    break;
                case "3":
                    Integer top = stack.get();
                    System.out.println("Top: " + (top != null ? top : "Stack is empty"));
                    break;
                case "4":
                    List<Integer> values = stack.getAllValues();
                    System.out.println("Stack: " + values);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Utility
    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random() * 100); // Random từ 0 - 99
        }
        return arr;
    }

    private static int readPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int val = Integer.parseInt(scanner.nextLine());
                if (val > 0) return val;
                System.out.println("Must be positive.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
            }
        }
    }
}
