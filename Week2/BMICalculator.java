package Week2;

public class BMICalculator {

    public static double calculateBMI(double weightKg, double heightCm) {
        double heightM = heightCm / 100.0;
        return weightKg / (heightM * heightM);
    }

    public static String classifyBMI(double bmi) {
        if (bmi < 19) {
            return "Under-standard";
        } else if (bmi < 25) {
            return "Standard";
        } else if (bmi < 30) {
            return "Overweight";
        } else if (bmi < 40) {
            return "Fat - should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }
}
