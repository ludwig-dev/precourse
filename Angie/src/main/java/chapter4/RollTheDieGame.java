package chapter4;

import java.util.Random;

public class RollTheDieGame {
    public static void main(String[] args) {
        final int WINNING_SPACE = 20;
        final int MAX_ROLLS = 5;

        Random random = new Random();
        int currentSpace = 0;

        for (int roll = 1; roll <= MAX_ROLLS; roll++) {
            int dieRoll = random.nextInt(6) + 1; // 1 to 6
            currentSpace += dieRoll;

            if (currentSpace == WINNING_SPACE) {
                System.out.println("Roll " + roll + ": You rolled a " + dieRoll + ". You advanced to space 20.");
                System.out.println("Congratulations! You won the game!");
                return;
            } else if (currentSpace > WINNING_SPACE) {
                System.out.println("Roll " + roll + ": You rolled a " + dieRoll + ". You advanced past space 20.");
                System.out.println("Sorry, you lose! You went over the target.");
                return;
            } else {
                int spacesLeft = WINNING_SPACE - currentSpace;
                System.out.println("Roll " + roll + ": You rolled a " + dieRoll + ". You're on space " + currentSpace +
                        " and have " + spacesLeft + " more to go.");
            }
        }

        // After 5 rolls, check if they landed exactly on 20
        if (currentSpace < WINNING_SPACE) {
            int difference = WINNING_SPACE - currentSpace;
            System.out.println("Game over! You didn't make it. You were " + difference + " spaces short.");
        }
    }
}
