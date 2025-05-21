package Week2;

public class Validator {

    public static boolean isValidOperator(String op) {
        return op != null && op.matches("[+\\-*/^=]");
    }

    public static Double parseDouble(String input) {
        try {
            return Double.parseDouble(input.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Integer parseInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static boolean isValidTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a && a > 0 && b > 0 && c > 0;
    }
}
