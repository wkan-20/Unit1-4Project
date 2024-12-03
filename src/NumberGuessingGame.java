import java.util.Random;

public class NumberGuessingGame {
    private int numberToGuess;
    private int blackNumber;
    private int previousGuess;
    private int attempts;

    public NumberGuessingGame() {
        Random random = new Random();
        // Creates range of the answer and the black number of this instance of 0,50 inclusive
        this.numberToGuess = random.nextInt(51);
        this.blackNumber = random.nextInt(51);
        while (this.blackNumber == this.numberToGuess) {
            this.blackNumber = random.nextInt(51);  // Ensures the black number is not the same as the number to guess
        }
        this.previousGuess = -1;
        this.attempts = 0;
    }

    public String processGuess(int guess) {
        attempts++;
        // Convert to string to check if guess is out of bounds of 2 digit places
        String guessString = Integer.toString(guess);  // Fixed: Changed 'string' to 'String'
        if (guessString.length() > 2) {
            return "Try again";
        }
        // Ends Game if Black Number is picked
        if (guess == blackNumber) {
            return "Oh no! You picked the black number (" + blackNumber + "). Game over!";
        }
        // Ends Game if number is guessed and prints # of attempts
        if (guess == numberToGuess) {
            return "Congratulations! You guessed the number in " + attempts + " attempts.";
        }
        // If the guess is the same as the previous guess, make the user guess again
        if (previousGuess == -1) {
            previousGuess = guess;
            return "Keep going!";
        }
        String feedback;
        // Finds distance and compares to see if new guess is hotter (closer) to the answer
        if (Math.abs(numberToGuess - previousGuess) > Math.abs(numberToGuess - guess)) {
            if (guess > numberToGuess) {
                feedback = "Hotter! But try lower.";
            } else {
                feedback = "Hotter! But try higher.";
            }
        } else {
            // If new guess is farther, it is colder
            if (guess > numberToGuess) {
                feedback = "Colder! And still too high.";
            } else {
                feedback = "Colder! And still too low.";
            }
        }
        previousGuess = guess;
        return feedback;
    }

    // Boolean to check if guess is correct
    public boolean isCorrectGuess(int guess) {
        return guess == numberToGuess;
    }

    // Boolean to check if guess is black number
    public boolean isBlackNumber(int guess) {
        return guess == blackNumber;
    }
}
