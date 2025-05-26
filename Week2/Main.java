package Week2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Matrix Calculator");
            System.out.println("4. Shape Calculator");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine().trim();

            switch (option) {
                case "1":
                    runNormalCalculator(scanner);
                    break;
                case "2":
                    runBMICalculator(scanner);
                    break;
                case "3":
                    runMatrixCalculator(scanner);
                    break;
                case "4":
                    runShapeCalculator(scanner);
                    break;
                case "5":
                    System.out.println("End");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // ========= BÀI 1 =========
    private static void runNormalCalculator(Scanner scanner) {
        NormalCalculator calc = new NormalCalculator();
        Double num = readDouble(scanner, "Enter first number: ");
        calc.setMemory(num);

        while (true) {
            System.out.print("Enter operator: ");
            String op = scanner.nextLine().trim();

            if (op.equals("=")) {
                System.out.println("Result = " + calc.getMemory());
                break;
            }

            if (!Validator.isValidOperator(op)) {
                System.out.println("Invalid operator.");
                continue;
            }

            Double next = readDouble(scanner, "Enter next number: ");
            calc.changeMemory(op, next);
            System.out.println("Memory = " + calc.getMemory());
        }
    }

    // ========= BÀI 2 =========
    private static void runBMICalculator(Scanner scanner) {
        Double weight = readDouble(scanner, "Enter weight (kg): ");
        Double height = readDouble(scanner, "Enter height (cm): ");

        double bmi = BMICalculator.calculateBMI(weight, height);
        String status = BMICalculator.classifyBMI(bmi);

        System.out.printf("BMI = %.2f\n", bmi);
        System.out.println("Status: " + status);
    }

    // ========= BÀI 3 =========
    private static void runMatrixCalculator(Scanner scanner) {
        System.out.println("1. Add matrices");
        System.out.println("2. Subtract matrices");
        System.out.println("3. Multiply matrices");
        System.out.print("Choose operation: ");
        String choice = scanner.nextLine();

        System.out.println("Enter matrix A:");
        int[][] a = readMatrix(scanner);
        System.out.println("Enter matrix B:");
        int[][] b = readMatrix(scanner);

        int[][] result = null;
        switch (choice) {
            case "1":
                result = MatrixCalculator.add(a, b);
                break;
            case "2":
                result = MatrixCalculator.subtract(a, b);
                break;
            case "3":
                result = MatrixCalculator.multiply(a, b);
                break;
            default:
                System.out.println("Invalid matrix operation.");
                return;
        }

        if (result == null) {
            System.out.println("Invalid matrix dimensions for this operation.");
        } else {
            System.out.println("Result:");
            printMatrix(result);
        }
    }

    // ========= BÀI 4 =========
    private static void runShapeCalculator(Scanner scanner) {
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");
        System.out.print("Choose shape: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                Double r = readDouble(scanner, "Enter radius: ");
                System.out.printf("Area: %.2f\n", ShapeCalculator.circleArea(r));
                System.out.printf("Perimeter: %.2f\n", ShapeCalculator.circlePerimeter(r));
                break;

            case "2":
                Double w = readDouble(scanner, "Enter width: ");
                Double h = readDouble(scanner, "Enter height: ");
                System.out.printf("Area: %.2f\n", ShapeCalculator.rectangleArea(w, h));
                System.out.printf("Perimeter: %.2f\n", ShapeCalculator.rectanglePerimeter(w, h));
                break;

            case "3":
                Double a = readDouble(scanner, "Enter side A: ");
                Double b = readDouble(scanner, "Enter side B: ");
                Double c = readDouble(scanner, "Enter side C: ");

                if (!Validator.isValidTriangle(a, b, c)) {
                    System.out.println("Invalid triangle.");
                    return;
                }

                System.out.printf("Area: %.2f\n", ShapeCalculator.triangleArea(a, b, c));
                System.out.printf("Perimeter: %.2f\n", ShapeCalculator.trianglePerimeter(a, b, c));
                break;

            default:
                System.out.println("Invalid shape.");
        }
    }

    // ========= TIỆN ÍCH CHUNG =========
    private static Double readDouble(Scanner scanner, String prompt) {
        Double value = null;
        while (value == null) {
            System.out.print(prompt);
            value = Validator.parseDouble(scanner.nextLine());
            if (value == null) {
                System.out.println("Invalid number. Please try again.");
            }
        }
        return value;
    }

    private static Integer readInt(Scanner scanner, String prompt) {
        Integer value = null;
        while (value == null) {
            System.out.print(prompt);
            value = Validator.parseInt(scanner.nextLine());
            if (value == null) {
                System.out.println("Invalid integer. Please try again.");
            }
        }
        return value;
    }

    private static int[][] readMatrix(Scanner scanner) {
        int rows = readInt(scanner, "Enter number of rows: ");
        int cols = readInt(scanner, "Enter number of columns: ");
        int[][] m = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m[i][j] = readInt(scanner, String.format("Element [%d][%d]: ", i + 1, j + 1));
            }
        }

        return m;
    }

    private static void printMatrix(int[][] m) {
        for (int[] row : m) {
            for (int val : row) {
                System.out.printf("%5d", val);
            }
            System.out.println();
        }
    }
}
