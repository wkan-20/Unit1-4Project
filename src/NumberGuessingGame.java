import java.util.Random;

public class NumberGuessingGame {
    private int numberToGuess;
    private int blackNumber;
    private int previousGuess;
    private int attempts;

    public NumberGuessingGame() {
        Random random = new Random();
        this.numberToGuess = random.nextInt(50) + 1;
        this.blackNumber = random.nextInt(50) + 1;
        while (this.blackNumber == this.numberToGuess) {
            this.blackNumber = random.nextInt(50) + 1;
        }
        this.previousGuess = -1;
        this.attempts = 0;
    }

    public String processGuess(int guess) {
        attempts++;
        if (guess == blackNumber) {
            return "Oh no! You picked the black number (" + blackNumber + "). Game over!";
        }
        if (guess == numberToGuess) {
            return "Congratulations! You guessed the number in " + attempts + " attempts.";
        }
        if (previousGuess == -1) {
            previousGuess = guess;
            return "Keep going! Feedback starts after the first guess.";
        }
        String feedback;
        if (Math.abs(numberToGuess - previousGuess) > Math.abs(numberToGuess - guess)) {
            feedback = guess > numberToGuess ? "Hotter! But try lower." : "Hotter! But try higher.";
        } else {
            feedback = guess > numberToGuess ? "Colder! And still too high." : "Colder! And still too low.";
        }
        previousGuess = guess;
        return feedback;
    }

    public boolean isCorrectGuess(int guess) {
        return guess == numberToGuess;
    }

    public boolean isBlackNumber(int guess) {
        return guess == blackNumber;
    }
}
