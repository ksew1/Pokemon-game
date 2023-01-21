package agh.oop.pokemon.gui;

import agh.oop.pokemon.*;
import agh.oop.pokemon.elements.IMapElement;
import agh.oop.pokemon.elements.IPokemon;
import javafx.fxml.FXML;

import javafx.scene.Node;

import javafx.scene.layout.*;

import java.util.Objects;

public class MapController {
    @FXML
    VBox mainVBox;
    @FXML
    GridPane grid;

    private ScreenController screenController;
    private final int n = 25;
    private final double cellPercent = 100 / (double) n;
    private final WorldMap worldMap = new WorldMap(this.n);


    @FXML
    public void initialize(ScreenController screenController) {
        this.screenController = screenController;
        this.worldMap.placeObstacles(n);
        this.worldMap.placePokemons(2);
        initGrid();
    }

    private void addNormalToGrid(Node node, Vector2d position) {
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
                    addNormalToGrid(mapElement.getImageViewPane(), position);
                }
            }
        }
    }


    public Node getNodeByRowColumnIndex(Vector2d position) {
        Integer row = position.x;
        Integer column = position.y;

        for (Node node : grid.getChildren()) {
            if (Objects.equals(GridPane.getRowIndex(node), row) && Objects.equals(GridPane.getColumnIndex(node), column)) {
                return node;
            }
        }
        return null;
    }

    private void moveElement(Vector2d oldPosition, Vector2d newPosition) {
        Node node = getNodeByRowColumnIndex(oldPosition.toGrid(n));
        grid.getChildren().remove(node);
        addNormalToGrid(node, newPosition);
    }

    public void moveHero(MapDirection direction) {
        Vector2d oldHeroPosition = this.worldMap.getHeroPosition();
        Vector2d newHeroPosition = oldHeroPosition.add(direction.toUnitVector());
        if (worldMap.canMoveTo(newHeroPosition)) {
            IMapElement mapElement = worldMap.objectAt(newHeroPosition);

            if (mapElement instanceof IPokemon) {
                worldMap.getHero().setOpponent((IPokemon) mapElement);
                grid.getChildren().remove(getNodeByRowColumnIndex(newHeroPosition.toGrid(n)));
                Vector2d newPosition = worldMap.deletePokemonAndPlace(newHeroPosition);
                addNormalToGrid(worldMap.objectAt(newPosition).getImageViewPane(), newPosition);
                screenController.activateFight(this.worldMap.getHero());
                worldMap.getHero().setOpponent(null);
            }

            moveElement(oldHeroPosition, newHeroPosition);
            this.worldMap.setHeroPosition(newHeroPosition);



        }
    }
}