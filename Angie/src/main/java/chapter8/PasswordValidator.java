package chapter8;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inputs
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your old password: ");
        String oldPassword = scanner.nextLine();

        System.out.print("Enter your new password: ");
        String newPassword = scanner.nextLine();

        // Validation
        if (isValidPassword(newPassword, username, oldPassword)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }

        scanner.close();
    }

    public static boolean isValidPassword(String password, String username, String oldPassword) {
        return isAtLeast8Chars(password)
                && containsUppercase(password)
                && containsSpecialChar(password)
                && !password.contains(username)
                && !password.equals(oldPassword);
    }

    public static boolean isAtLeast8Chars(String s) {
        return s.length() >= 8;
    }

    public static boolean containsUppercase(String s) {
        return s.matches(".*[A-Z].*");
    }

    public static boolean containsSpecialChar(String s) {
        return s.matches(".*[^a-zA-Z0-9].*");
    }
}