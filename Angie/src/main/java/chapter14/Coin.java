package chapter14;

import java.util.Random;

public class Coin {
    public static final String HEADS = "Heads";
    public static final String TAILS = "Tails";

    private String side; // encapsulated field

    public String getSide() {
        return side;
    }

    public void flip() {
        Random random = new Random();
        if (random.nextBoolean()) {
            side = HEADS;
        } else {
            side = TAILS;
        }
    }
}

