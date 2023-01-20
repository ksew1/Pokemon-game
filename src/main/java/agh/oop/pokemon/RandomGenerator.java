package agh.oop.pokemon;

import java.util.Random;

public class RandomGenerator {
    public static int getRandom(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }
    public static String getRandomObstacle() {
        return switch (getRandom(5)) {
            case 0, 1 -> "/images/obstacles/rock.png";
            case 2, 3 -> "/images/obstacles/tree.png";
            case 4 -> "/images/obstacles/puddle.png";
            default -> throw new IllegalStateException("Unexpected random value");
        };
    }
}
