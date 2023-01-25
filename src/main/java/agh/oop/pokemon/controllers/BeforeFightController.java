package agh.oop.pokemon.controllers;

import agh.oop.pokemon.Vector2d;
import agh.oop.pokemon.elements.Hero;
import agh.oop.pokemon.elements.pokemons.Bulbasaur;
import agh.oop.pokemon.elements.pokemons.Clefairy;
import agh.oop.pokemon.elements.pokemons.Gengar;
import agh.oop.pokemon.elements.pokemons.Starmie;
import agh.oop.pokemon.interfaces.IPokemon;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BeforeFightController {
    @FXML
    private GridPane grid;
    @FXML
    private VBox mainVBox;
    @FXML
    private Button firstButton;
    @FXML
    private Button secondButton;
    @FXML
    private Button thirdButton;
    @FXML
    private GridPane firstGrid;
    @FXML
    private GridPane secondGrid;
    @FXML
    private GridPane thirdGrid;
    private List<IPokemon> activePokemons = new ArrayList<>();

    @FXML
    public void initialize(ScreenController screenController, @NotNull Hero hero) {
        for (IPokemon pokemon : hero.getAllPokemons()) {
            if (pokemon.isActive()) activePokemons.add(pokemon);
        }

        int numberOfPokemons = activePokemons.size();


        firstButton.setOnAction(e -> screenController.activateFight(hero, activePokemons.get(0)));
        secondButton.setOnAction(e -> screenController.activateFight(hero, activePokemons.get(1)));
        thirdButton.setOnAction(e -> screenController.activateFight(hero, activePokemons.get(2)));
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth((double) 100 / numberOfPokemons);
        columnConstraints.setHalignment(HPos.CENTER);

        mainVBox.setPadding(new Insets(20, 200 * (4 - numberOfPokemons), 20, 200 * (4 - numberOfPokemons)));

        grid.getColumnConstraints().clear();
        for (int i = 0; i < numberOfPokemons; i++) {
            grid.getColumnConstraints().add(columnConstraints);
        }

        if (numberOfPokemons == 2) {
            grid.getChildren().remove(thirdButton);
            grid.getChildren().remove(thirdGrid);

        } else if (numberOfPokemons == 1) {
            grid.getChildren().remove(thirdButton);
            grid.getChildren().remove(secondButton);
            grid.getChildren().remove(thirdGrid);
            grid.getChildren().remove(secondGrid);
        }

        for (int i = 0; i < numberOfPokemons; i++) {
            IPokemon currentPokemon = activePokemons.get(i);

            GridPane currentGrid;
            if (i == 0) currentGrid = firstGrid;
            else if (i == 1) currentGrid = secondGrid;
            else currentGrid = thirdGrid;
            grid.add(currentPokemon.getImageViewPane(), i, 0);
            grid.add(new Text(currentPokemon.getClass().getSimpleName()), i, 1);
            grid.add(new Text("Level: " + currentPokemon.getLevel()), i, 2);
            grid.add(new Text("Base attack: " + currentPokemon.getNormalAttack()), i, 3);
            grid.add(new Text("Health: " + currentPokemon.getHealth()), i, 4);
            Text text = new Text("Type: " + currentPokemon.getType());
            text.setFill(currentPokemon.getType().toColor());
            grid.add(text, i, 5);
            text = new Text(currentPokemon.getNormalAttackType().toString());
            text.setFill(currentPokemon.getNormalAttackType().toColor());
            currentGrid.add(text, 1, 1);

            text = new Text(currentPokemon.getSuperAttackType().toString());
            text.setFill(currentPokemon.getSuperAttackType().toColor());
            currentGrid.add(text, 1, 2);

            text = new Text(currentPokemon.getUltraAttackType().toString());
            text.setFill(currentPokemon.getUltraAttackType().toColor());
            currentGrid.add(text, 1, 3);

        }
    }
}
