package Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RepeatedLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter text: ");
        String text = scanner.nextLine();

        // Create a HashMap to store repeated letters
        Map<Character, Integer> letterCount = new HashMap<>();

        // Calculate the frequency of letters in the text
        for (char letter : text.toCharArray()) {
            if (Character.isLetter(letter)) {
                letter = Character.toLowerCase(letter);
                letterCount.put(letter, letterCount.getOrDefault(letter, 0) + 1);
            }
        }

        // Find the most repeated letter and its frequency
        char mostRepeatedLetter = '\0';
        int highestFrequency = 0;
        boolean hasRepeatedLetters = false;
        for (Map.Entry<Character, Integer> entry : letterCount.entrySet()) {
            char letter = entry.getKey();
            int frequency = entry.getValue();
            if (frequency > highestFrequency) {
                highestFrequency = frequency;
                mostRepeatedLetter = letter;
                hasRepeatedLetters = true;
            } else if (frequency == highestFrequency) {
                hasRepeatedLetters = false;
            }
        }

        if (hasRepeatedLetters) {
            System.out.println("The most repeated letter is " + mostRepeatedLetter + ", which appears " + highestFrequency + " times.");
        } else {
            System.out.println("No letter was repeated or some letters were repeated an equal number of times.");
        }
    }
}