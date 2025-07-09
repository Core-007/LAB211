// LargeNumberApp.java hay main.java

import java.util.Scanner;

public class LargeNumberApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập vào 2 số lớn
        System.out.print("Enter first large number: ");
        String num1Str = scanner.nextLine();
        System.out.print("Enter second large number: ");
        String num2Str = scanner.nextLine();

        // Chuyển chuỗi thành mảng số
        int[] num1 = LargeNumberCalculator.stringToArray(num1Str);
        int[] num2 = LargeNumberCalculator.stringToArray(num2Str);

        // Thực hiện phép cộng
        int[] sumResult = LargeNumberCalculator.add(num1, num2);
        System.out.print("Sum: ");
        LargeNumberCalculator.printResult(sumResult);

        // Thực hiện phép nhân
        int[] mulResult = LargeNumberCalculator.multiply(num1, num2);
        System.out.print("Multiplication: ");
        LargeNumberCalculator.printResult(mulResult);
    }
}
