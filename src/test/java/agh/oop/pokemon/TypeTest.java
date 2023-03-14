package agh.oop.pokemon;

import agh.oop.pokemon.enums.Type;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TypeTest {
    @Test
    void toColorTest() {
        List<Type> list = List.of(Type.FIRE, Type.WATER, Type.GRASS, Type.FAIRY);
        List<Color> list2 = List.of(Color.RED, Color.BLUE, Color.GREEN, Color.PINK);
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i).toColor(), list2.get(i));
        }
    }

    @Test
    void toStringTest() {
        List<Type> list = List.of(Type.FIRE, Type.WATER, Type.GRASS, Type.FAIRY);
        List<String> list2 = List.of("Fire", "Water", "Grass", "Fairy");
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i).toString(), list2.get(i));
        }
    }

    @Test
    void damageToTest() {
        List<Type> list = List.of(Type.FIRE, Type.FAIRY, Type.GRASS, Type.WATER);
        List<Type> list2 = List.of(Type.FIRE, Type.FAIRY, Type.GRASS, Type.WATER);
        List<Double> list3 = List.of(1.0, 1.0, 1.5, 1.5, 1.0, 1.0, 2.0, 2.0, 1.5, 2.0, 1.0, 1.0, 1.5, 2.0, 1.0, 1.0);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                Assertions.assertEquals(list.get(i).damageTo(list2.get(j)), (list3.get(i * 4 + j)));
            }
        }
    }


}
