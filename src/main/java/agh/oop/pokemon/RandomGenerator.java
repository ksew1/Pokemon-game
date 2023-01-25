package agh.oop.pokemon;

import agh.oop.pokemon.elements.pokemons.Bulbasaur;
import agh.oop.pokemon.elements.pokemons.Gengar;
import agh.oop.pokemon.elements.pokemons.Sandslash;
import agh.oop.pokemon.elements.pokemons.Starmie;
import agh.oop.pokemon.enums.AttackType;
import agh.oop.pokemon.interfaces.IPokemon;
import agh.oop.pokemon.enums.MapDirection;

import java.util.Random;

public class RandomGenerator {

    public static int getRandom(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    public static IPokemon getRandomPokemon(int levelBound) {
        int randomNumber = getRandom(4);
        int level = getRandom(levelBound + 2) + 1;
        return switch (randomNumber) {
            case 0 -> new Bulbasaur(level);
            case 1 -> new Sandslash(level);
            case 2 -> new Bulbasaur(level);
            case 3 -> new Starmie(level);
            default -> throw new IllegalStateException("Unexpected value: " + randomNumber);
        };
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

    // 25 %
    public static int getSuperAttackMissChance() {
        int randomNumber = getRandom(4);
        return switch (randomNumber) {
            case 0 -> 0;
            case 1, 2, 3 -> 1;
            default -> throw new IllegalStateException("Unexpected value: " + randomNumber);
        };
    }

    // 33 %
    public static int getUltraAttackMissChance() {
        int randomNumber = getRandom(3);
        return switch (randomNumber) {
            case 0 -> 0;
            case 1, 2 -> 1;
            default -> throw new IllegalStateException("Unexpected value: " + randomNumber);
        };
    }

    public static boolean shouldPokemonMove() {
        int randomNumber = getRandom(5);
        return switch (randomNumber) {
            case 0 -> true;
            case 1, 2, 3, 4 -> false;
            default -> throw new IllegalStateException("Unexpected value: " + randomNumber);
        };
    }

    public static MapDirection getMapDirection() {
        int randomNumber = getRandom(4);
        return switch (randomNumber) {
            case 0 -> MapDirection.NORTH;
            case 1 -> MapDirection.EAST;
            case 2 -> MapDirection.SOUTH;
            case 3 -> MapDirection.WEST;
            default -> throw new IllegalStateException("Unexpected value: " + randomNumber);
        };
    }

    public static AttackType getAttackType() {
        int randomNumber = getRandom(3);
        return switch (randomNumber) {
            case 0 -> AttackType.NORMAL;
            case 1 -> AttackType.SUPER;
            case 2 -> AttackType.ULTRA;
            default -> throw new IllegalStateException("Unexpected value: " + randomNumber);
        };
    }
}
