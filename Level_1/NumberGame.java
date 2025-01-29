import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int low = 1, high = 100;
        boolean guessedCorrectly = false;
        while (!guessedCorrectly) {
            int guess = generateGuess(low, high, random);
            System.out.println("Is your number " + guess + "? (Enter 'high', 'low', or 'correct')");
            String feedback = scanner.next().toLowerCase();
            guessedCorrectly = processFeedback(feedback, guess);
            if (!guessedCorrectly) {
                if (feedback.equals("high")) {
                    high = guess - 1;
                } else if (feedback.equals("low")) {
                    low = guess + 1;
                }
            }
        }
        System.out.println("Great! The computer guessed your number.");
        scanner.close();
    }

    private static int generateGuess(int low, int high, Random random) {
        return random.nextInt(high - low + 1) + low;
    }

    private static boolean processFeedback(String feedback, int guess) {
        return feedback.equals("correct");
    }
}
