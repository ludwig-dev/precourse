package chapter10;

public class Apple extends Fruit {

    public Apple() {
        setCalories(95);
    }

    public void removeSeeds() {
        System.out.println("Seeds removed from apple.");
    }

    @Override
    public void makeJuice() {
        System.out.println("Apple juice is made.");
    }
}

