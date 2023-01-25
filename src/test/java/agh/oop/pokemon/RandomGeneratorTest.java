package agh.oop.pokemon;

import agh.oop.pokemon.enums.AttackType;
import agh.oop.pokemon.enums.MapDirection;
import agh.oop.pokemon.utils.RandomGenerator;
import agh.oop.pokemon.utils.Vector2d;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class RandomGeneratorTest {
    @Test
    public void getRandomTest() {
        for (int i = 1; i < 100; i++) {
            Assertions.assertTrue(RandomGenerator.getRandom(i) < i);
        }
    }

    @Test
    public void getAttackType() {
        List<AttackType> list = new ArrayList<>();
        list.add(AttackType.SUPER);
        list.add(AttackType.NORMAL);
        list.add(AttackType.ULTRA);
        for (int i = 1; i < 100; i++) {
            Assertions.assertTrue(list.contains(RandomGenerator.getAttackType()));
        }


    }
}
