package agh.oop.pokemon;

import agh.oop.pokemon.enums.AttackType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AttackTypeTest {

    @Test
    void toStringTest() {
        List<AttackType> list = List.of(AttackType.NORMAL, AttackType.SUPER, AttackType.ULTRA);
        for (AttackType attackType : list) {
            Assertions.assertEquals(attackType.toString(), attackType.name().toLowerCase() + " attack");
        }
    }

}
