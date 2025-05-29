package Week3;

public class QuickSort {

    public static void sort(int[] arr, int low, int high) {
        if (low >= high) return;

        int pivot = arr[(low + high) / 2];
        int i = low, j = high;

        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) sort(arr, low, j);
        if (i < high) sort(arr, i, high);
    }
}
