package Week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n========= LAB211 Menu =========");
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
                    System.out.println("Word count: " + Assignment1_LetterCount.countWords(input));
                    System.out.println("Letter count: " + Assignment1_LetterCount.countLetters(input));
                    break;

                case "2":
                    int size = readInt(scanner, "Enter size of array: ");
                    int bound = 10; // Giới hạn số ngẫu nhiên từ 0 đến 9
                    int[] arr = Assignment2_LinearSearch.generateRandomArray(size, bound);

                    int target = readInt(scanner, "Enter search value: ");
                    System.out.print("The array: ");
                    System.out.println(Arrays.toString(arr));

                    int index = Assignment2_LinearSearch.search(arr, target);
                    if (index != -1) {
                        System.out.println("Found " + target + " at index: " + index);
                    } else {
                        System.out.println("Value not found.");
                    }
                    break;

                case "3":
                    int inBase = readBase(scanner, "Choose input base (2, 10, 16): ");
                    System.out.print("Enter value: ");
                    String value = scanner.nextLine();

                    int outBase = readBase(scanner, "Choose output base (2, 10, 16): ");

                    try {
                        int decimal = Assignment3_BaseConverter.toDecimal(value, inBase);
                        String result = Assignment3_BaseConverter.fromDecimal(decimal, outBase);
                        System.out.println("Converted value: " + result);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for base " + inBase);
                    }
                    break;

                case "4":
                    while (true) {
                        System.out.println("\n=== Equation Solver ===");
                        System.out.println("1. Solve Superlative (Ax + B = 0)");
                        System.out.println("2. Solve Quadratic (Ax^2 + Bx + C = 0)");
                        System.out.println("0. Return to main menu");
                        System.out.print("Choose sub-option: ");
                        String opt = scanner.nextLine().trim();

                        if (opt.equals("0")) {
                            break;
                        }

                        if (opt.equals("1")) {
                            float a = readFloat(scanner, "Enter A: ");
                            float b = readFloat(scanner, "Enter B: ");

                            List<Float> result = Assignment4_EquationSolver.solveSuperlative(a, b);

                            if (result == null) {
                                System.out.println("No solution.");
                            } else if (result.isEmpty()) {
                                System.out.println("Infinitely many solutions.");
                            } else {
                                System.out.printf("x = %.3f\n", result.get(0));
                            }

                            showProperties(a, b);
                        } else if (opt.equals("2")) {
                            float a = readFloat(scanner, "Enter A: ");
                            float b = readFloat(scanner, "Enter B: ");
                            float c = readFloat(scanner, "Enter C: ");

                            if (a == 0) {
                                System.out.println("Since A = 0, equation becomes linear: Bx + C = 0");
                                List<Float> result = Assignment4_EquationSolver.solveSuperlative(b, c);

                                if (result == null) {
                                    System.out.println("No solution.");
                                } else if (result.isEmpty()) {
                                    System.out.println("Infinitely many solutions.");
                                } else {
                                    System.out.printf("x = %.3f\n", result.get(0));
                                }

                                showProperties(b, c);
                            } else {
                                List<Float> result = Assignment4_EquationSolver.solveQuadratic(a, b, c);

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
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Các hàm đọc số và kiểm tra giá trị nhập vào
    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int val = Integer.parseInt(scanner.nextLine());
                if (val > 0) {
                    return val;
                }
                System.out.println("Please enter a positive integer.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    private static float readFloat(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    private static int readBase(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int base = Integer.parseInt(scanner.nextLine());
                if (base == 2 || base == 10 || base == 16) {
                    return base;
                }
                System.out.println("Base must be 2, 10 or 16.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }
    }

    private static void showProperties(float... values) {
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        StringBuilder square = new StringBuilder();

        for (float v : values) {
            if (Assignment4_EquationSolver.isOdd(v)) {
                odd.append(v).append(", ");
            }
            if (Assignment4_EquationSolver.isEven(v)) {
                even.append(v).append(", ");
            }
            if (Assignment4_EquationSolver.isPerfectSquare(v)) {
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
