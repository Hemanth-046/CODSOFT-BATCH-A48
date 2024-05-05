import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        System.out.println("Let's play a guessing game!");
        System.out.println("I will generate a random number between 1 and 100, and you have to guess it.");

        // Generate a random number
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1;

        // Set the number of attempts
        int maxAttempts = 10;

        // Initialize the score
        int score = 0;
        int roundCount = 0;

        while (true) {
            // Prompt the user to enter a guess
            System.out.print("Enter your guess (1-100): ");
            Scanner scanner = new Scanner(System.in);
            int userGuess = scanner.nextInt();

            // Compare the user's guess with the generated number
            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                score++;
                roundCount++;
                System.out.println("Your score: " + score);
                System.out.print("Do you want to play again? (yes/no) ");
                String playAgain = scanner.next();
                if (playAgain.equalsIgnoreCase("yes")) {
                    // Reset the game for a new round
                    targetNumber = random.nextInt(100) + 1;
                    continue;
                } else {
                    System.out.println("Thanks for playing!");
                    break;
                }
            } else if (userGuess < targetNumber) {
                System.out.println("Your guess is too low. Try again.");
                maxAttempts--;
            } else {
                System.out.println("Your guess is too high. Try again.");
                maxAttempts--;
            }

            if (maxAttempts == 0) {
                System.out.println("Sorry, you have used up all your attempts. The correct number was " + targetNumber + ".");
                roundCount++;
                System.out.println("Your score: " + score);
                System.out.print("Do you want to play again? (yes/no) ");
                String playAgain = scanner.next();
                if (playAgain.equalsIgnoreCase("yes")) {
                    // Reset the game for a new round
                    targetNumber = random.nextInt(100) + 1;
                    maxAttempts = 10;
                    continue;
                } else {
                    System.out.println("Thanks for playing!");
                    break;
                }
            }
        }
    }
}
