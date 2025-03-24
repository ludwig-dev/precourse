package chapter6;

public class PhoneBillCalculatorOOP {
    public static void main(String[] args) {
        // You can try all constructors here
        PhoneBill bill1 = new PhoneBill(); // Default
        PhoneBill bill2 = new PhoneBill(101); // ID only
        PhoneBill bill3 = new PhoneBill(102, 60.0, 200, 250); // All fields

        bill1.printItemizedBill();
        System.out.println();

        bill2.printItemizedBill();
        System.out.println();

        bill3.printItemizedBill();
    }
}
