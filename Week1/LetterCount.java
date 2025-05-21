package Week1;

import java.util.HashMap;

public class LetterCount {

    public static HashMap<String, Integer> countWords(String input) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : input.trim().split("\\s+")) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

    public static HashMap<Character, Integer> countLetters(String input) {
        HashMap<Character, Integer> letterCount = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
            }
        }
        return letterCount;
    }
}
