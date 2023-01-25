package agh.oop.pokemon.controllers;

import agh.oop.pokemon.*;
import agh.oop.pokemon.elements.Hero;
import agh.oop.pokemon.interfaces.IMapElement;
import agh.oop.pokemon.interfaces.IPokemon;
import agh.oop.pokemon.enums.MapDirection;
import javafx.fxml.FXML;

import javafx.scene.Node;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class MapController {
    @FXML
    VBox mainVBox;
    @FXML
    GridPane grid;

    @FXML
    Button pokedexButton;

    private ScreenController screenController;
    private final int n = 25;
    private final double cellPercent = 100 / (double) n;
    private final WorldMap worldMap = new WorldMap(this.n);


    @FXML
    public void initialize(ScreenController screenController) {
        this.screenController = screenController;

        this.worldMap.placeObstacles(n);
        this.worldMap.placePokemons(n);
        pokedexButton.setOnAction(e -> screenController.activateChoice(worldMap.getHero()));

        initGrid();
    }

    private void addNormalToGrid(Node node, @NotNull Vector2d position) {
        Vector2d gridPosition = position.toGrid(n);
        grid.add(node, gridPosition.y, gridPosition.x, 1, 1);
    }

    private void initGrid() {
        grid.setGridLinesVisible(true);
        grid.setStyle("-fx-background-color: #8fbc8f;");

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(cellPercent);

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(cellPercent);

        for (int i = 0; i < this.n; i++) {
            grid.getColumnConstraints().add(columnConstraints);
            grid.getRowConstraints().add(rowConstraints);
        }
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                Vector2d position = new Vector2d(i, j);
                IMapElement mapElement = worldMap.objectAt(position);
                if (mapElement != null) {
                    if (mapElement instanceof IPokemon pokemon) {
                        Label label = new Label(String.valueOf(pokemon.getLevel()));
                        label.setTextFill(Color.WHITE);
                        StackPane stackPane = new StackPane(pokemon.getImageViewPane(), label);
                        addNormalToGrid(stackPane, position);
                    } else {
                        addNormalToGrid(mapElement.getImageViewPane(), position);
                    }
                }
            }
        }
    }

    public Node getNodeByRowColumnIndex(@NotNull Vector2d position) {
        Integer row = position.x;
        Integer column = position.y;

        for (Node node : grid.getChildren()) {
            if (Objects.equals(GridPane.getRowIndex(node), row) && Objects.equals(GridPane.getColumnIndex(node), column)) {
                return node;
            }
        }
        return null;
    }

    private void moveElement(@NotNull Vector2d oldPosition, Vector2d newPosition) {
        Node node = getNodeByRowColumnIndex(oldPosition.toGrid(n));
        grid.getChildren().remove(node);
        addNormalToGrid(node, newPosition);
    }

    public void moveHero(@NotNull MapDirection direction) {
        Vector2d oldHeroPosition = this.worldMap.getHeroPosition();
        Vector2d newHeroPosition = oldHeroPosition.add(direction.toUnitVector());
        if (worldMap.canMoveTo(newHeroPosition)) {
            IMapElement mapElement = worldMap.objectAt(newHeroPosition);
            if (mapElement instanceof IPokemon pokemon) {
                Hero hero = worldMap.getHero();
                hero.setOpponent(pokemon);
                screenController.setNewHeroPosition(newHeroPosition);
                if (hero.getNumberOfActive() > 1) {
                    screenController.activateBeforeFight(hero);
                } else {
                    screenController.activateFight(hero, hero.getActivePokemons().get(0));
                }
                return;
            } else {
                moveElement(oldHeroPosition, newHeroPosition);
                this.worldMap.setHeroPosition(newHeroPosition);
            }
        }
        movePokemons();
    }

    public void movePokemons() {
        Map<Vector2d, Vector2d> toRemove = new HashMap<>();

        for (Vector2d key : worldMap.getPokemonMap().keySet()) {
            if (RandomGenerator.shouldPokemonMove()) {
                Vector2d newPosition = key.add(RandomGenerator.getMapDirection().toUnitVector());
                if (worldMap.canMoveTo(newPosition)) {
                    toRemove.put(key, newPosition);
                }
            }
        }
        for (Map.Entry<Vector2d, Vector2d> entry : toRemove.entrySet()) {
            if (worldMap.objectAt(entry.getValue()) == null) {
                worldMap.positionChanged(entry.getKey(), entry.getValue());
                moveElement(entry.getKey(), entry.getValue());
            }
        }
    }

    public void afterFight(boolean won, @NotNull Vector2d newHeroPosition) {
        grid.getChildren().remove(getNodeByRowColumnIndex(newHeroPosition.toGrid(n)));
        Vector2d position = newHeroPosition;
        if (won) {
            position = worldMap.deletePokemonAndPlace(newHeroPosition);
        }
        IPokemon pokemon = (IPokemon) worldMap.objectAt(position);
        Label label = new Label(String.valueOf(pokemon.getLevel()));
        label.setTextFill(Color.WHITE);
        StackPane stackPane = new StackPane(pokemon.getImageViewPane(), label);
        addNormalToGrid(stackPane, position);
    }
}