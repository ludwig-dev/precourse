package chapter10;

public class Market {
    public static void main(String[] args) {
        Fruit generic = new Fruit();
        generic.setCalories(50);
        generic.makeJuice();
        System.out.println("Calories: " + generic.getCalories());
        System.out.println();

        Apple apple = new Apple();
        apple.removeSeeds();
        apple.makeJuice();
        System.out.println("Calories: " + apple.getCalories());
        System.out.println();

        Banana banana = new Banana();
        banana.peel();
        banana.makeJuice();
        System.out.println("Calories: " + banana.getCalories());
        System.out.println();

        // Polymorphism example
        Fruit f1 = new Apple();
        Fruit f2 = new Banana();
        f1.makeJuice(); // Apple juice is made.
        f2.makeJuice(); // Banana smoothie is made.
    }
}

