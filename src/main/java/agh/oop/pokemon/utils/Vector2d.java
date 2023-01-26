package agh.oop.pokemon.utils;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";

    }

    public boolean precedes(@NotNull Vector2d other) {
        return this.x <= other.x && this.y <= other.y;
    }

    public boolean follows(@NotNull Vector2d other) {
        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2d add(@NotNull Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }


    public Vector2d toGrid(int n) {
        int firstCord = n - this.y - 1;
        int secondCord = this.x;
        return new Vector2d(firstCord, secondCord);
    }


    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Vector2d)) return false;
        Vector2d that = (Vector2d) other;
        return this.x == that.x && this.y == that.y;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }
}
