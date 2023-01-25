package agh.oop.pokemon.interfaces;

import agh.oop.pokemon.enums.Type;
import agh.oop.pokemon.gui.ImageViewPane;

public interface IPokemon {
    void levelUp();

    void levelDown();

    int getNormalAttack();

    int getSuperAttack();

    int getUltraAttack();

    Type getNormalAttackType();

    Type getSuperAttackType();

    Type getUltraAttackType();

    Type getType();

    int getHealth();

    void setCurrentHealth(int currentHealth);
    int getCurrentHealth();
    int getLevel();

    ImageViewPane getImageViewPane();

    int getSuperAttackWithOutMiss();

    int getUltraAttackWithOutMiss();
    void setActive(boolean active);
    boolean isActive();
}
