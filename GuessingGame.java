import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int rounds = 0;
        int totalScore = 0;
        String playAgain;
        
        System.out.println("Welcome to the Guessing Game!");
        
        do {
            int numberToGuess = random.nextInt(100) + 1; // Generate random number between 1 and 100
            int attempts = 0;
            boolean hasWon = false;
            int maxAttempts = 5;
            
            System.out.println("\nRound " + (rounds + 1) + ": Try to guess the number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    hasWon = true;
                    break;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Too low!");
                }
                
                System.out.println("Attempts remaining: " + (maxAttempts - attempts));
            }

            // End of round feedback
            if (hasWon) {
                totalScore += (maxAttempts - attempts + 1); // Higher score for fewer attempts
            } else {
                System.out.println("You've used all attempts. The correct number was " + numberToGuess);
            }
            
            rounds++;
            System.out.println("Your current score: " + totalScore);
            
            // Ask if user wants to play again
            System.out.print("Would you like to play another round? (yes/no): ");
            playAgain = scanner.next();
            
        } while (playAgain.equalsIgnoreCase("yes"));
        
        // End of game summary
        System.out.println("\nGame Over!");
        System.out.println("Total rounds played: " + rounds);
        System.out.println("Your final score: " + totalScore);
        
        scanner.close();
    }
}