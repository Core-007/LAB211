package Week3;

public class BubbleSort {

    public static void sort(int[] arr) {
        boolean swapped;
        int n = arr.length;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    swapped = true;
                }
            }
            n--; // tối ưu: mỗi vòng lặp đưa phần tử lớn nhất về cuối
        } while (swapped);
    }
}
