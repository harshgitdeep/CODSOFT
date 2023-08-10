import java.util.Scanner;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;
        System.out.println();
        System.out.println();
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You need to guess a number between " + minRange + " and " + maxRange + ".");
        System.out.println("You have " + maxAttempts + " attempts per round.");

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("\nRound " + (rounds + 1));
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Please enter a number between " + minRange + " and " + maxRange + ".");
                } else {
                    attempts++;

                    if (userGuess == targetNumber) {
                        System.out.println("Congratulations! You guessed the correct number " + targetNumber + " in " + attempts + " attempts.");
                        score += maxAttempts - attempts + 1;
                        break;
                    } else if (userGuess < targetNumber) {
                        System.out.println("Your guess is too low.");
                    } else {
                        System.out.println("Your guess is too high.");
                    }

                    if (attempts == maxAttempts) {
                        System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
                    }
                }
            }

            rounds++;
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.nextLine();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("\nGame over! You played " + rounds + " rounds and your total score is " + score + ".");
        scanner.close();
    }
}
