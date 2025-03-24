package chapter11;

public class Farm {
    public static void main(String[] args) {
        Animal pig = new Pig();
        Animal duck = new Duck();

        pig.makeSound();
        pig.eat();

        System.out.println();

        duck.makeSound();
        duck.eat();
    }
}

