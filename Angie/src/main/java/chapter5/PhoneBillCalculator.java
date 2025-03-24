package chapter5;

import java.util.Scanner;

public class PhoneBillCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter plan fee: $");
        double planFee = scanner.nextDouble();

        System.out.print("Enter number of overage minutes: ");
        int overageMinutes = scanner.nextInt();

        // Calculations
        double overageFee = calculateOverageFee(overageMinutes);
        double tax = calculateTax(planFee + overageFee);
        double total = calculateTotal(planFee, overageFee, tax);

        // Output
        printItemizedBill(planFee, overageFee, tax, total);

        scanner.close();
    }

    public static double calculateOverageFee(int minutes) {
        return minutes * 0.25;
    }

    public static double calculateTax(double amount) {
        return amount * 0.15;
    }

    public static double calculateTotal(double planFee, double overageFee, double tax) {
        return planFee + overageFee + tax;
    }

    public static void printItemizedBill(double planFee, double overageFee, double tax, double total) {
        System.out.println("\nPhone Bill Statement");
        System.out.println("Plan Fee: $" + String.format("%.2f", planFee));
        System.out.println("Overage Fee: $" + String.format("%.2f", overageFee));
        System.out.println("Tax: $" + String.format("%.2f", tax));
        System.out.println("Total: $" + String.format("%.2f", total));
    }
}

