package Week2;

public class NormalCalculator {
    private double memory;

    public NormalCalculator() {
        memory = 0;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    public void changeMemory(String operator, double number) {
        switch (operator) {
            case "+":
                memory += number;
                break;
            case "-":
                memory -= number;
                break;
            case "*":
                memory *= number;
                break;
            case "/":
                if (number == 0) {
                    System.err.println("Cannot calculator with zero");
                } else {
                    memory /= number;
                }
                break;
            case "^":
                memory = Math.pow(memory, number);
                break;
            default:
                System.err.println("Invalid operator: " + operator);
        }
    }
}
