package agh.oop.pokemon.elements;

import agh.oop.pokemon.elements.pokemons.Bulbasaur;
import agh.oop.pokemon.elements.pokemons.Clefairy;
import agh.oop.pokemon.elements.pokemons.Gengar;
import agh.oop.pokemon.gui.ImageViewPane;
import agh.oop.pokemon.interfaces.IMapElement;
import agh.oop.pokemon.interfaces.IPokemon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Hero implements IMapElement {
    private ImageViewPane imageViewPane;
    private IPokemon opponent;

    private List<IPokemon> allPokemons = new ArrayList<>();


    public Hero() {
        Image image = new Image("/images/hero.png");
        ImageView imageView = new ImageView(image);
        this.imageViewPane = new ImageViewPane(imageView);
        allPokemons.add(new Bulbasaur(1));
        addToActive(allPokemons.get(0));
    }

    public void addToActive(@NotNull IPokemon pokemon) {
        pokemon.setActive(true);
    }

    // Setter methods
    public void setOpponent(IPokemon opponent) {
        this.opponent = opponent;
    }
    public List<IPokemon> getActivePokemons() {
        List<IPokemon> activePokemons = new ArrayList<>();
        for (IPokemon pokemon: getAllPokemons()) {
            if (pokemon.isActive()) activePokemons.add(pokemon);
        }
        return activePokemons;
    }

    // Getter methods
    public int getHighestLevel() {
        int level = 0;
        for (IPokemon pokemon : getAllPokemons()) {
            if (pokemon.isActive()) {
                level = Math.max(level, pokemon.getLevel());
            }
        }
        return level;
    }
    public int getNumberOfActive() {
        int counter = 0;
        for (IPokemon pokemon : getAllPokemons()) {
            if (pokemon.isActive()) counter++;
        }
        return counter;
    }

    public List<IPokemon> getAllPokemons() {
        return allPokemons;
    }

    @Override
    public ImageViewPane getImageViewPane() {
        return this.imageViewPane;
    }

    public IPokemon getOpponent() {
        return opponent;
    }

}
