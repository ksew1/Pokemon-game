package agh.oop.pokemon.elements;

import agh.oop.pokemon.Type;
import agh.oop.pokemon.gui.ImageViewPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AbstractPokemon implements IMapElement, IPokemon {
    protected int health;

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
        this.level -= 1;
        this.attack = (int) Math.ceil(this.attack * 0.8);
        this.health = (int) Math.ceil(this.health * 0.8);
    }

    public int getNormalAttack() {
        return attack;
    }

    public int getSuperAttack() {
        this.currentHealth = (int) Math.ceil(currentHealth * 0.9);
        return (int) Math.ceil(attack * 1.5);
    }

    public int getUltraAttack() {
        this.currentHealth = (int) Math.ceil(currentHealth * 0.7);
        return (int) Math.ceil(attack * 3);
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

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    protected void setLevel(int level) {
        while (this.level < level) {
            levelUp();
        }
    }

    protected void setImageViewPane(String link) {
        Image image = new Image(link);
        ImageView imageView = new ImageView(image);
        this.imageViewPane = new ImageViewPane(imageView);
    }

    @Override
    public ImageViewPane getImageViewPane() {
        return imageViewPane;
    }
}
