import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    
    private static final int MAX_ATTEMPTS = 10;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalScore = 0;
        int roundsPlayed = 0;
        
        System.out.println("===== NUMBER GUESSING GAME =====");
        System.out.println("Guess a number between 1 and 100.");
        System.out.println();
        
        boolean playAgain = true;
        
        while (playAgain) {
            roundsPlayed++;
            int targetNumber = random.nextInt(MAX_NUMBER) + MIN_NUMBER;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            System.out.println("Round " + roundsPlayed);
            System.out.println("-------------------");
            
            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                attempts++;
                System.out.print("Enter your guess: ");
                
                int userGuess = getValidGuess(scanner);
                
                if (userGuess == -1) {
                    System.out.println("Invalid input. Please enter a number between 1 and 100.");
                    attempts--;
                    continue;
                }
                
                if (userGuess < targetNumber) {
                    System.out.println("Too Low!");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too High!");
                } else {
                    System.out.println("Correct!");
                    guessedCorrectly = true;
                }
            }
            
            int roundScore = calculateScore(attempts, guessedCorrectly);
            totalScore += roundScore;
            
            System.out.println();
            System.out.println("Attempts: " + attempts);
            System.out.println("Score: " + roundScore);
            System.out.println();
            
            playAgain = askToPlayAgain(scanner);
            System.out.println();
        }
        
        System.out.println("===== FINAL RESULTS =====");
        System.out.println("Rounds Played: " + roundsPlayed);
        System.out.println("Total Score: " + totalScore);
        System.out.println("Average Score: " + (roundsPlayed > 0 ? totalScore / roundsPlayed : 0));
        System.out.println();
        System.out.println("Thank you for playing!");
        
        scanner.close();
    }
    
    private static int getValidGuess(Scanner scanner) {
        try {
            String input = scanner.nextLine();
            int guess = Integer.parseInt(input);
            
            if (guess < MIN_NUMBER || guess > MAX_NUMBER) {
                return -1;
            }
            
            return guess;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static int calculateScore(int attempts, boolean guessedCorrectly) {
        if (!guessedCorrectly) {
            return 0;
        }
        
        // Score rewards fewer attempts (max 100, min 10)
        int score = 100 - ((attempts - 1) * 10);
        return Math.max(score, 10);
    }
    
    private static boolean askToPlayAgain(Scanner scanner) {
        while (true) {
            System.out.print("Do you want to play another round? (Y/N): ");
            String choice = scanner.nextLine().trim().toUpperCase();
            
            if (choice.equals("Y")) {
                return true;
            } else if (choice.equals("N")) {
                return false;
            } else {
                System.out.println("Invalid choice. Please enter Y or N.");
            }
        }
    }
}
