package chapter2;

import java.util.Scanner;

public class MadLibs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for input
        System.out.print("Enter a season of the year: ");
        String season = scanner.nextLine();

        System.out.print("Enter a whole number: ");
        int number = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.print("Enter an adjective: ");
        String adjective = scanner.nextLine();

        // Output the result
        System.out.println("\nOn a " + adjective + " " + season + " day, I drink a minimum of " + number + " cups of coffee.");

        scanner.close();
    }
}
