package chapter9;

public class TasteTester {
    public static void main(String[] args) {
        BirthdayCake bCake = new BirthdayCake("Chocolate");
        bCake.setPrice(29.99);
        bCake.setCandles(10);

        WeddingCake wCake = new WeddingCake("Vanilla");
        wCake.setPrice(99.99);
        wCake.setTiers(3);

        System.out.println("Birthday Cake: Flavor = " + bCake.getFlavor() +
                ", Price = $" + bCake.getPrice() +
                ", Candles = " + bCake.getCandles());

        System.out.println("Wedding Cake: Flavor = " + wCake.getFlavor() +
                ", Price = $" + wCake.getPrice() +
                ", Tiers = " + wCake.getTiers());
    }
}

