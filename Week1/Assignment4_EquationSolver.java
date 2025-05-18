package Week1;

import java.util.ArrayList;
import java.util.List;

public class Assignment4_EquationSolver {

    public static List<Float> solveSuperlative(float a, float b) {
        if (a == 0) {
            if (b == 0) return new ArrayList<>(); // vô số nghiệm
            return null; // vô nghiệm
        }
        List<Float> result = new ArrayList<>();
        result.add(-b / a);
        return result;
    }

    public static List<Float> solveQuadratic(float a, float b, float c) {
        float delta = b * b - 4 * a * c;
        if (delta < 0) return null;
        List<Float> result = new ArrayList<>();
        float sqrtDelta = (float) Math.sqrt(delta);
        float x1 = (-b + sqrtDelta) / (2 * a);
        float x2 = (-b - sqrtDelta) / (2 * a);
        result.add(x1);
        result.add(x2);
        return result;
    }

    public static boolean isEven(float number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(float number) {
        return number % 2 != 0;
    }

    public static boolean isPerfectSquare(float number) {
        double sqrt = Math.sqrt(number);
        return sqrt == Math.floor(sqrt);
    }
}
