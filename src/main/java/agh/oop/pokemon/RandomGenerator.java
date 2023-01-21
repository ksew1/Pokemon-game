package agh.oop.pokemon;

import java.util.Random;

public class RandomGenerator {

    public static int getRandom(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }
    public static String getRandomObstacle() {
        int randomNumber = getRandom(5);
        return switch (randomNumber) {
            case 0, 1 -> "/images/obstacles/rock.png";
            case 2, 3 -> "/images/obstacles/tree.png";
            case 4 -> "/images/obstacles/puddle.png";
            default -> throw new IllegalStateException("Unexpected value: " + randomNumber);
        };
    }
}
