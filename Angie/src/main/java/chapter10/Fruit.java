package chapter10;

public class Fruit {
    private int calories;

    public Fruit() {
        // Default
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    public void makeJuice() {
        System.out.println("Juice is made.");
    }
}

