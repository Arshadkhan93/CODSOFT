import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    private static Scanner scanner = new Scanner(System.in);

    private static int generateGeneratedNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    private static final int MAX_ATTEMPTS = 20;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;

    public static void main(String[] args) {

        System.out.println("WELCOME TO THE NUMBER GAME.");

        boolean playAgain;
        int Rounds = 0;
        int Score = 0;

        do {
            Rounds++;
            int attemptsLeft = MAX_ATTEMPTS;
            int GeneratedNumber = generateGeneratedNumber(MIN_RANGE, MAX_RANGE);
            boolean guessedCorrectly = false;

            System.out.println("Guess the number between " + MIN_RANGE + " and " + MAX_RANGE + ":");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess < MIN_RANGE || userGuess > MAX_RANGE) {
                    System.out.println("Please enter a number between " + MIN_RANGE + " and " + MAX_RANGE + ".");
                    continue;
                }

                attemptsLeft--;

                if (userGuess == GeneratedNumber) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the number correctly.");
                    break;
                } else if (userGuess < GeneratedNumber) {
                    System.out.println("Too low. Try again (Enter Higher Number).");
                } else {
                    System.out.println("Too high. Try again (Enter Lower Number).");
                }

                if (attemptsLeft > 0) {
                    System.out.println(" Attempts remaining: " + attemptsLeft);
                } else {
                    System.out
                            .println("Sorry, you've run out of attempts. The correct number was " + GeneratedNumber
                                    + ".");

                }
            }

            if (guessedCorrectly) {
                Score++;
            }

            System.out.println("Do you want to play again? (yes/no)");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes");

        } while (playAgain);

        System.out.println("Game over. You played " + Rounds + " rounds and won " + Score + " times.");
    }

}
