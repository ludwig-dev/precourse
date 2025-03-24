package chapter14;

import java.util.Scanner;

public class CoinTossGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Coin coin = new Coin();

        // Create Players
        System.out.print("Enter name for Player 1: ");
        Player player1 = new Player(scanner.nextLine());

        System.out.print("Enter name for Player 2: ");
        Player player2 = new Player(scanner.nextLine());

        // Player 1 picks side
        String guess;
        do {
            System.out.print(player1.getName() + ", choose Heads or Tails: ");
            guess = scanner.nextLine().trim();
        } while (!guess.equalsIgnoreCase(Coin.HEADS) && !guess.equalsIgnoreCase(Coin.TAILS));

        // Set guesses
        player1.setGuess(capitalize(guess));
        player2.setGuess(oppositeGuess(player1.getGuess()));

        System.out.println(player2.getName() + " is assigned: " + player2.getGuess());

        // Flip coin
        coin.flip();
        System.out.println("Coin landed on: " + coin.getSide());

        // Determine winner
        if (player1.getGuess().equals(coin.getSide())) {
            System.out.println(player1.getName() + " wins!");
        } else {
            System.out.println(player2.getName() + " wins!");
        }

        scanner.close();
    }

    private static String oppositeGuess(String guess) {
        return guess.equals(Coin.HEADS) ? Coin.TAILS : Coin.HEADS;
    }

    private static String capitalize(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}

