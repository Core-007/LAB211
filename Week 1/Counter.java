package Week1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Counter {
    private Map<Character, Integer> charCounter = new HashMap<>();
    private Map<String, Integer> wordCounter = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your content: ");
        String content = scanner.nextLine();
        
        Counter counter = new Counter();
        counter.analyze(content);
        counter.display();
    }

    public void display() {
        System.out.println("Word count: " + wordCounter);
        System.out.println("Character count (excluding spaces): " + charCounter);
    }

    public void analyze(String content) {
        for (char ch : content.toCharArray()) {
            if (!Character.isWhitespace(ch)) {
                charCounter.merge(ch, 1, Integer::sum);
            }
        }

        for (String word : content.trim().split("\\s+")) {
            wordCounter.merge(word, 1, Integer::sum);
        }
    }
}
