package agh.oop.pokemon;

import agh.oop.pokemon.utils.Vector2d;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Vector2dTest {
    @Test
    public void equalsTest() {
        Assertions.assertEquals(new Vector2d(1, 2), new Vector2d(1, 2));
        Assertions.assertNotEquals(new Vector2d(2, 1), new Vector2d(1, 2));
        Assertions.assertNotEquals(new Vector2d(0, -1), new Vector2d(0, 1));
    }

    @Test
    public void toStringTest() {
        Assertions.assertEquals("(1,2)", new Vector2d(1, 2).toString());
        Assertions.assertEquals("(0,0)", new Vector2d(0, 0).toString());
        Assertions.assertNotEquals("(1,2)", new Vector2d(2, 2).toString());
        Assertions.assertNotEquals("3,2", new Vector2d(3, 2).toString());
    }

    @Test
    public void precedesTest() {
        Assertions.assertTrue(new Vector2d(1, 2).precedes(new Vector2d(1, 3)));
        Assertions.assertFalse(new Vector2d(4, 5).precedes(new Vector2d(1, 2)));
        Assertions.assertTrue(new Vector2d(4, 5).precedes(new Vector2d(4, 5)));
        Assertions.assertTrue(new Vector2d(4, 5).precedes(new Vector2d(7, 6)));
    }

    @Test
    public void followsTest() {
        Assertions.assertTrue(new Vector2d(1, 2).follows(new Vector2d(1, 1)));
        Assertions.assertTrue(new Vector2d(4, 5).follows(new Vector2d(1, 2)));
        Assertions.assertTrue(new Vector2d(4, 5).follows(new Vector2d(4, 5)));
        Assertions.assertFalse(new Vector2d(4, 5).follows(new Vector2d(7, 6)));
    }


    @Test
    public void addTest() {
        Assertions.assertEquals(new Vector2d(4, 5), new Vector2d(4, 5).add(new Vector2d(0, 0)));
        Assertions.assertEquals(new Vector2d(-20, 15), new Vector2d(3, 17).add(new Vector2d(-23, -2)));
        Assertions.assertNotEquals(new Vector2d(0, 15), new Vector2d(100, 18).add(new Vector2d(-100, 3)));
        Assertions.assertNotEquals(new Vector2d(0, 7), new Vector2d(0, 0).add(new Vector2d(-293, -2)));
    }


}