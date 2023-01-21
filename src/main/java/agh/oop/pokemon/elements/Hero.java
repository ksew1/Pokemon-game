package agh.oop.pokemon.elements;

import agh.oop.pokemon.elements.IMapElement;
import agh.oop.pokemon.gui.ImageViewPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Hero implements IMapElement {
    ImageViewPane imageViewPane;
    private IPokemon opponent;
    private List<IPokemon> activePokemons = new ArrayList<>();

    public Hero() {
        Image image = new Image("/images/hero.png");
        ImageView imageView = new ImageView(image);
        this.imageViewPane = new ImageViewPane(imageView);
        activePokemons.add(new Bulbasaur(3));
    }

    @Override
    public ImageViewPane getImageViewPane() {
        return this.imageViewPane;
    }

    public IPokemon getOpponent() {
        return opponent;
    }

    public List<IPokemon> getActivePokemons() {
        return activePokemons;
    }

    public void setOpponent(IPokemon opponent) {
        this.opponent = opponent;
    }
}
