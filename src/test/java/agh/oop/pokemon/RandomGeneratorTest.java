package agh.oop.pokemon;

import agh.oop.pokemon.enums.AttackType;
import agh.oop.pokemon.utils.RandomGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

class RandomGeneratorTest {
    @Test
    void getRandomTest() {
        for (int i = 1; i < 100; i++) {
            Assertions.assertTrue(RandomGenerator.getRandom(i) < i);
        }
    }



    @Test
    void getRandomObstacle() {
        for (int i = 1; i < 100; i++) {
            Assertions.assertNotNull(RandomGenerator.getRandomObstacle());
        }
    }

    @Test
    void getSuperAttackMissChance() {
        for (int i = 1; i < 100; i++) {
            Assertions.assertTrue(RandomGenerator.getSuperAttackMissChance() < 2);
        }
    }

    @Test
    void getUltraAttackMissChance() {
        for (int i = 1; i < 100; i++) {
            Assertions.assertTrue(RandomGenerator.getUltraAttackMissChance() < 2);
        }
    }


    @Test
    void getMapDirection() {
        for (int i = 1; i < 100; i++) {
            Assertions.assertNotNull(RandomGenerator.getMapDirection());
        }
    }

    @Test
    void getAttackType() {
        List<AttackType> list = new ArrayList<>();
        list.add(AttackType.SUPER);
        list.add(AttackType.NORMAL);
        list.add(AttackType.ULTRA);
        for (int i = 1; i < 100; i++) {
            Assertions.assertTrue(list.contains(RandomGenerator.getAttackType()));
        }

    }
}
