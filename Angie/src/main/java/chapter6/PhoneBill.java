package chapter6;

public class PhoneBill {
    private int id;
    private double baseCost;
    private int allottedMinutes;
    private int minutesUsed;

    // Default constructor
    public PhoneBill() {
        this(0, 50.0, 100, 120); // Default values
    }

    // ID-only constructor
    public PhoneBill(int id) {
        this(id, 50.0, 100, 120); // Other values set to default
    }

    // All-fields constructor
    public PhoneBill(int id, double baseCost, int allottedMinutes, int minutesUsed) {
        this.id = id;
        this.baseCost = baseCost;
        this.allottedMinutes = allottedMinutes;
        this.minutesUsed = minutesUsed;
    }

    public double calculateOverage() {
        int overageMinutes = Math.max(0, minutesUsed - allottedMinutes);
        return overageMinutes * 0.25;
    }

    public double calculateTax() {
        return (baseCost + calculateOverage()) * 0.15;
    }

    public double calculateTotal() {
        return baseCost + calculateOverage() + calculateTax();
    }

    public void printItemizedBill() {
        System.out.println("Phone Bill for ID: " + id);
        System.out.println("Plan: $" + String.format("%.2f", baseCost));
        System.out.println("Overage: $" + String.format("%.2f", calculateOverage()));
        System.out.println("Tax: $" + String.format("%.2f", calculateTax()));
        System.out.println("Total: $" + String.format("%.2f", calculateTotal()));
    }
}
