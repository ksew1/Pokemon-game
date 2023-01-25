package agh.oop.pokemon.enums;

public enum AttackType {
    NORMAL, SUPER, ULTRA;

    @Override
    public String toString() {
        return switch (this) {
            case NORMAL -> "normal attack";
            case SUPER -> "super attack";
            case ULTRA -> "ultra attack";
        };
    }
}
