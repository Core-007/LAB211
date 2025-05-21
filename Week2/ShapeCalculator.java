package Week2;

public class ShapeCalculator {

    public static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static double circlePerimeter(double radius) {
        return 2 * Math.PI * radius;
    }

    public static double rectangleArea(double width, double height) {
        return width * height;
    }

    public static double rectanglePerimeter(double width, double height) {
        return 2 * (width + height);
    }

    public static boolean isValidTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a && a > 0 && b > 0 && c > 0;
    }

    public static double trianglePerimeter(double a, double b, double c) {
        return a + b + c;
    }

    public static double triangleArea(double a, double b, double c) {
        double s = trianglePerimeter(a, b, c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
