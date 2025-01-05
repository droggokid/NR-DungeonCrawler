package nr.dungeoncrawler.utils;

import java.util.Random;

public class Dice {
    private static final Random random = new Random();

    // Returns 0 or 1
    public static boolean rollFifty() {
        return random.nextInt(2) == 0;
    }

    // Returns 0, 1, 2 or 3
    public static boolean rollTwentyFive() {
        return random.nextInt(4) == 0;
    }

    // Returns 0 to 99
    public static int rollHundred() {
        return random.nextInt(100);
    }

    /*
       The method rollCustomChance takes an integer chance
       and returns true if a randomly generated number between 0 and 100/chance - 1 is 0
    */
    public static boolean rollCustomChance(int chance) {
        if (chance <= 0 || chance > 100) {
            throw new IllegalArgumentException("Chance must be between 1 and 100");
        }
        return random.nextInt(100 / chance) == 0;
    }

    // Returns 1, 2, 3, 4, 5 or 6
    public static int rollDice() {
        return random.nextInt(6) + 1;
    }
}
