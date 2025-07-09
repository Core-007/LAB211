//logic tính toán và phương thức hỗ trợ (cộng, nhân, hiển thị kết quả)

public class LargeNumberCalculator {
    
    // Hàm cộng hai số lớn
    public static int[] add(int[] num1, int[] num2) {
        int maxLength = Math.max(num1.length, num2.length);
        int[] result = new int[maxLength + 1];  // Dự phòng cho trường hợp có carry

        int carry = 0;
        int i = 0;
        
        // Cộng các chữ số từ phải sang trái
        while (i < maxLength || carry != 0) {
            int digit1 = i < num1.length ? num1[num1.length - 1 - i] : 0;
            int digit2 = i < num2.length ? num2[num2.length - 1 - i] : 0;
            
            int sum = digit1 + digit2 + carry;
            result[result.length - 1 - i] = sum % 10;
            carry = sum / 10;
            
            i++;
        }
        return result;
    }

    // Hàm nhân hai số lớn
    public static int[] multiply(int[] num1, int[] num2) {
        int[] result = new int[num1.length + num2.length];
        
        for (int i = num1.length - 1; i >= 0; i--) {
            for (int j = num2.length - 1; j >= 0; j--) {
                int product = num1[i] * num2[j] + result[i + j + 1];
                result[i + j + 1] = product % 10;
                result[i + j] += product / 10;
            }
        }
        
        return result;
    }

    // Hàm hiển thị mảng số lớn
    public static void printResult(int[] result) {
        boolean leadingZero = true;
        for (int digit : result) {
            if (digit != 0 || !leadingZero) {
                System.out.print(digit);
                leadingZero = false;
            }
        }
        System.out.println();
    }

    // Hàm chuyển chuỗi thành mảng số
    public static int[] stringToArray(String number) {
        int[] result = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            result[i] = number.charAt(i) - '0';
        }
        return result;
    }
}
