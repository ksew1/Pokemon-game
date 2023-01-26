package agh.oop.pokemon.enums;

import javafx.scene.paint.Color;
import org.jetbrains.annotations.NotNull;

public enum Type {
    FIRE, WATER, GRASS, FAIRY;

    public Color toColor() {
        return switch (this) {
            case FIRE -> Color.RED;
            case FAIRY -> Color.PINK;
            case GRASS -> Color.GREEN;
            case WATER -> Color.BLUE;
        };
    }

    @Override
    public String toString() {
        return switch (this) {
            case FIRE -> "Fire";
            case FAIRY -> "Fairy";
            case GRASS -> "Grass";
            case WATER -> "Water";
        };
    }

    private int toNumber() {
        return switch (this) {
            case FIRE -> 0;
            case FAIRY -> 1;
            case GRASS -> 2;
            case WATER -> 3;
        };
    }

    public double damageTo(@NotNull Type type) {
        //        FIRE FAIRY GRASS WATER
        // FIRE  |  1    1    1.5   1.5
        // FAIRY |  1    1     2     2
        // GRASS | 1.5   2     1     1
        // WATER | 1.5   2     1     1
        Double[][] damageMultiplayer = {
                {1.0, 1.0, 1.5, 1.5},
                {1.0, 1.0, 2.0, 2.0},
                {1.5, 2.0, 1.0, 1.0},
                {1.5, 2.0, 1.0, 1.0}
        };
        return damageMultiplayer[this.toNumber()][type.toNumber()];

    }
}
