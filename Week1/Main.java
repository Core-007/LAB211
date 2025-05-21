package Week1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Letter & Character Count");
            System.out.println("2. Linear Search");
            System.out.println("3. Base Converter");
            System.out.println("4. Equation Solver");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter your content: ");
                    String input = scanner.nextLine();
                    System.out.println("Word count: " + LetterCount.countWords(input));
                    System.out.println("Letter count: " + LetterCount.countLetters(input));
                    break;

                case "2":
                    int size = Validator.readPositiveInt(scanner, "Enter size of array: ");
                    int[] arr = LinearSearch.generateRandomArray(size, 10);

                    int target = Validator.readPositiveInt(scanner, "Enter search value: ");
                    System.out.print("The array: ");
                    System.out.println(Arrays.toString(arr));

                    int index = LinearSearch.search(arr, target);
                    if (index != -1) {
                        System.out.println("Found " + target + " at index: " + index);
                    } else {
                        System.out.println("Value not found.");
                    }
                    break;

                case "3":
                    int inBase = Validator.readBase(scanner, "Choose input base (2, 10, 16): ");
                    System.out.print("Enter value: ");
                    String value = scanner.nextLine();
                    int outBase = Validator.readBase(scanner, "Choose output base (2, 10, 16): ");

                    try {
                        int decimal = BaseConverter.toDecimal(value, inBase);
                        String result = BaseConverter.fromDecimal(decimal, outBase);
                        System.out.println("Converted value: " + result);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for base " + inBase);
                    }
                    break;

                case "4":
                    while (true) {
                        System.out.println("1. Solve Superlative (Ax + B = 0)");
                        System.out.println("2. Solve Quadratic (Ax^2 + Bx + C = 0)");
                        System.out.println("0. Return to main menu");
                        System.out.print("Choose sub-option: ");
                        String opt = scanner.nextLine().trim();

                        if (opt.equals("0")) break;

                        if (opt.equals("1")) {
                            float a = Validator.readFloat(scanner, "Enter A: ");
                            float b = Validator.readFloat(scanner, "Enter B: ");

                            List<Float> result = EquationSolver.solveSuperlative(a, b);

                            if (result == null) {
                                System.out.println("No solution.");
                            } else if (result.isEmpty()) {
                                System.out.println("Infinitely many solutions.");
                            } else {
                                System.out.printf("x = %.3f\n", result.get(0));
                            }

                            showProperties(a, b);
                        } else if (opt.equals("2")) {
                            float a = Validator.readFloat(scanner, "Enter A: ");
                            float b = Validator.readFloat(scanner, "Enter B: ");
                            float c = Validator.readFloat(scanner, "Enter C: ");

                            if (a == 0) {
                                System.out.println("Since A = 0, equation becomes linear: Bx + C = 0");
                                List<Float> result = EquationSolver.solveSuperlative(b, c);

                                if (result == null) {
                                    System.out.println("No solution.");
                                } else if (result.isEmpty()) {
                                    System.out.println("Infinitely many solutions.");
                                } else {
                                    System.out.printf("x = %.3f\n", result.get(0));
                                }

                                showProperties(b, c);
                            } else {
                                List<Float> result = EquationSolver.solveQuadratic(a, b, c);

                                if (result == null) {
                                    System.out.println("No solution.");
                                } else if (result.isEmpty()) {
                                    System.out.println("Infinitely many solutions.");
                                } else {
                                    System.out.printf("x1 = %.3f, x2 = %.3f\n", result.get(0), result.get(1));
                                }

                                showProperties(a, b, c);
                            }
                        } else {
                            System.out.println("Invalid sub-option. Please choose 1, 2, or 0.");
                        }
                    }
                    break;

                case "5":
                    System.out.println("End");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void showProperties(float... values) {
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        StringBuilder square = new StringBuilder();

        for (float v : values) {
            if (EquationSolver.isOdd(v)) {
                odd.append(v).append(", ");
            }
            if (EquationSolver.isEven(v)) {
                even.append(v).append(", ");
            }
            if (EquationSolver.isPerfectSquare(v)) {
                square.append(v).append(", ");
            }
        }

        if (!odd.isEmpty()) {
            System.out.println("Odd: " + odd.substring(0, odd.length() - 2));
        }
        if (!even.isEmpty()) {
            System.out.println("Even: " + even.substring(0, even.length() - 2));
        }
        if (!square.isEmpty()) {
            System.out.println("Perfect Square: " + square.substring(0, square.length() - 2));
        }
    }
}
