package agh.oop.pokemon;

import agh.oop.pokemon.enums.MapDirection;
import agh.oop.pokemon.utils.Vector2d;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MapDirectionTest {

    @Test
    public void toUnitVectorTest() {
        Assertions.assertEquals(MapDirection.NORTH.toUnitVector(), new Vector2d(0, 1));
        Assertions.assertEquals(MapDirection.EAST.toUnitVector(), new Vector2d(1, 0));
        Assertions.assertEquals(MapDirection.SOUTH.toUnitVector(), new Vector2d(0, -1));
        Assertions.assertEquals(MapDirection.WEST.toUnitVector(), new Vector2d(-1, 0));
    }

}