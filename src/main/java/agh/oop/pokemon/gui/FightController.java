package agh.oop.pokemon.gui;


import agh.oop.pokemon.elements.Hero;
import agh.oop.pokemon.elements.IPokemon;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.List;

public class FightController {

    @FXML
    private GridPane grid;

    @FXML
    private Label chosenPokemonHealth;
    @FXML
    private Label chosenPokemonType;
    @FXML
    private Label chosenPokemonLevel;
    @FXML
    private Label opponentHealth;
    @FXML
    private Label opponentType;
    @FXML
    private Label opponentLevel;
    private ScreenController screenController;

    private List<IPokemon> pokemons;
    private IPokemon opponent;

    private IPokemon chosenPokemon;


    @FXML
    public void initialize(ScreenController screenController, Hero hero) {
        this.screenController = screenController;
        this.pokemons = hero.getActivePokemons();
        this.chosenPokemon = pokemons.get(0);
        this.opponent = hero.getOpponent();

        grid.setGridLinesVisible(true);
        grid.add(opponent.getImageViewPane(), 0, 0);
        grid.add(chosenPokemon.getImageViewPane(), 3, 1);


        this.opponent.setCurrentHealth(this.opponent.getHealth());
        this.chosenPokemon.setCurrentHealth(this.chosenPokemon.getHealth());

        renderHealth();

        opponentLevel.setText("Level: " + this.opponent.getLevel());

        chosenPokemonLevel.setText("Level: " + this.chosenPokemon.getLevel());
    }

    @FXML
    private void normalAttack() {
        opponent.setCurrentHealth(opponent.getCurrentHealth() - chosenPokemon.getNormalAttack());
        renderHealth();
    }

    @FXML
    private void superAttack() {
        opponent.setCurrentHealth(opponent.getCurrentHealth() - chosenPokemon.getSuperAttack());
        renderHealth();
    }

    @FXML
    private void ultraAttack() {
        opponent.setCurrentHealth(opponent.getCurrentHealth() - chosenPokemon.getUltraAttack());
        renderHealth();

    }

    private void renderHealth() {
        if (opponent.getCurrentHealth() <= 0) {
            screenController.activateMap();
        }
        if (chosenPokemon.getCurrentHealth() <= 0) {
            screenController.activateMap();
        }
        opponentHealth.setText("Health: " + this.opponent.getCurrentHealth() + "/" + this.opponent.getHealth());
        chosenPokemonHealth.setText("Health: " + chosenPokemon.getCurrentHealth() + "/" + chosenPokemon.getHealth());

    }


}
