package agh.oop.pokemon.controllers;

import agh.oop.pokemon.elements.Hero;
import agh.oop.pokemon.gui.PokemonGame;
import agh.oop.pokemon.interfaces.IPokemon;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChoiceController {


    @FXML
    private HBox box;
    private ScreenController screenController;
    private final List<PokemonController> pokemonControllerList = new ArrayList<>();

    @FXML
    public void initialize(ScreenController screenController , @NotNull Hero hero) {
        this.screenController = screenController;
        try {
            for (IPokemon pokemon : hero.getAllPokemons()) {
                addPokemon(pokemon,  hero);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addPokemon(IPokemon pokemon, Hero hero) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PokemonGame.class.getResource("/fxml/pokemon-view.fxml"));
        Pane pane = fxmlLoader.load();
        PokemonController pokemonController = fxmlLoader.getController();
        pokemonControllerList.add(pokemonController);
        pokemonController.initialize(pokemon, hero, this);
        pane.setPrefHeight(700);
        pane.setPrefWidth(400);
        box.getChildren().add(pane);
    }
    @FXML
    private void toMap() {
        screenController.activateMap();
    }
    public void setAllButtons() {
        for (PokemonController pokemonController: pokemonControllerList) {
            pokemonController.initButton();
        }
    }
}
