import java.util.Scanner;

/**
 * NumberGuessingGameApp
 * Handles user input and output for the number guessing game.
 */
public class NumberGuessingGameApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NumberGuessingGame game = new NumberGuessingGame();

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have picked a number between 1 and 50. Can you guess what it is?");
        System.out.println("But beware! If you pick the black number, the game ends immediately!");

        boolean gameEnded = false;

        while (!gameEnded) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (game.isBlackNumber(userGuess)) {
                System.out.println(game.processGuess(userGuess));
                gameEnded = true;
            } else {
                String feedback = game.processGuess(userGuess);
                System.out.println(feedback);

                if (game.isCorrectGuess(userGuess)) {
                    gameEnded = true;
                }
            }
        }

        scanner.close();
    }
}
