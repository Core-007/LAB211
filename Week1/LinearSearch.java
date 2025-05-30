package Week1;

import java.util.Random;

public class LinearSearch {

    // Phương thức tìm kiếm tuyến tính
    public static int search(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    // Phương thức sinh mảng ngẫu nhiên
    public static int[] generateRandomArray(int size, int bound) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(bound); 
        }
        return arr;
    }
}
