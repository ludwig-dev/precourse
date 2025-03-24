package chapter7;

import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] days = {
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
        };

        System.out.print("Enter a number (1-7): ");
        int dayNumber = scanner.nextInt();

        if (dayNumber >= 1 && dayNumber <= 7) {
            System.out.println("Day: " + days[dayNumber - 1]);
        } else {
            System.out.println("Invalid input. Please enter a number between 1 and 7.");
        }

        scanner.close();
    }
}
