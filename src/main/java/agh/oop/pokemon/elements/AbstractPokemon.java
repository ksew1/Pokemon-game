package agh.oop.pokemon.elements;

import agh.oop.pokemon.RandomGenerator;
import agh.oop.pokemon.enums.Type;
import agh.oop.pokemon.gui.ImageViewPane;
import agh.oop.pokemon.interfaces.IMapElement;
import agh.oop.pokemon.interfaces.IPokemon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AbstractPokemon implements IMapElement, IPokemon {
    protected int health;
    protected boolean active = false;
    protected double superMultiplayer = 1.5;
    protected double ultraMultiplayer = 2;

    protected int currentHealth;
    protected int attack;
    protected int level = 1;
    protected Type type;
    protected Type normalAttackType;
    protected Type superAttackType;
    protected Type ultraAttackType;
    protected ImageViewPane imageViewPane;

    public void levelUp() {
        this.level += 1;
        this.attack = (int) Math.ceil(this.attack * 1.2);
        this.health = (int) Math.ceil(this.health * 1.2);
    }

    public void levelDown() {
        if (level >= 2) {
            this.level -= 1;
            this.attack = (int) Math.ceil(this.attack * 0.8);
            this.health = (int) Math.ceil(this.health * 0.8);
        }
    }

    // Setter methods
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    protected void setLevel(int level) {
        while (this.level < level) {
            levelUp();
        }
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    protected void setImageViewPane(String link) {
        Image image = new Image(link);
        ImageView imageView = new ImageView(image);
        this.imageViewPane = new ImageViewPane(imageView);
    }
    // Getter methods


    public int getNormalAttack() {
        return attack;
    }

    public int getSuperAttack() {
        return (int) Math.ceil(RandomGenerator.getSuperAttackMissChance() * attack * superMultiplayer);
    }

    public int getUltraAttack() {
        return (int) Math.ceil(RandomGenerator.getUltraAttackMissChance() * attack * ultraMultiplayer);
    }

    public int getSuperAttackWithOutMiss() {
        return (int) Math.ceil(attack * superMultiplayer);
    }

    public int getUltraAttackWithOutMiss() {
        return (int) Math.ceil(attack * ultraMultiplayer);
    }

    public Type getNormalAttackType() {
        return normalAttackType;
    }

    public Type getSuperAttackType() {
        return superAttackType;
    }

    public Type getUltraAttackType() {
        return ultraAttackType;
    }

    public Type getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }


    public boolean isActive() {
        return active;
    }

    @Override
    public ImageViewPane getImageViewPane() {
        return imageViewPane;
    }


}
