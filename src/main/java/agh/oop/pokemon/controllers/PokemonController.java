package agh.oop.pokemon.controllers;

import agh.oop.pokemon.elements.Hero;
import agh.oop.pokemon.interfaces.IPokemon;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import org.jetbrains.annotations.NotNull;

public class PokemonController {
    @FXML
    private GridPane grid;
    @FXML
    private GridPane innerGrid;
    @FXML
    private Button stateButton;
    private IPokemon pokemon;
    private Hero hero;

    @FXML
    public void initialize(@NotNull IPokemon pokemon, Hero hero, ChoiceController choiceController) {
        this.hero = hero;
        this.pokemon = pokemon;
        initButton();

        grid.add(pokemon.getImageViewPane(), 0, 0);
        grid.add(new Text(pokemon.getClass().getSimpleName()), 0, 1);
        grid.add(new Text("Level: " + pokemon.getLevel()), 0, 2);
        grid.add(new Text("Base attack: " + pokemon.getNormalAttack()), 0, 3);
        grid.add(new Text("Health: " + pokemon.getHealth()), 0, 4);
        stateButton.setOnAction(e -> setAllButtons(choiceController));

        Text text = new Text("Type: " + pokemon.getType());
        text.setFill(pokemon.getType().toColor());
        grid.add(text, 0, 5);

        text = new Text(pokemon.getNormalAttackType().toString());
        text.setFill(pokemon.getNormalAttackType().toColor());
        this.innerGrid.add(text, 1, 1);

        text = new Text(pokemon.getSuperAttackType().toString());
        text.setFill(pokemon.getSuperAttackType().toColor());
        this.innerGrid.add(text, 1, 2);

        text = new Text(pokemon.getUltraAttackType().toString());
        text.setFill(pokemon.getUltraAttackType().toColor());
        this.innerGrid.add(text, 1, 3);
    }
    public void setAllButtons(@NotNull ChoiceController choiceController) {
        pokemon.setActive(!pokemon.isActive());
        choiceController.setAllButtons();
    }

    public void initButton() {
        if (pokemon.isActive()) {
            stateButton.setDisable(hero.getNumberOfActive() <= 1);
            stateButton.setText("Remove from active");
        } else {
            stateButton.setDisable(hero.getNumberOfActive() >= 3);
            stateButton.setText("Add to active");
        }

    }

}
