package agh.oop.pokemon;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.stage.Screen;

public class MapController {

    @FXML
    GridPane grid;
    private final int n = 25;

    @FXML
    private void initialize() {
        grid.setGridLinesVisible(true);

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(100 / (double) n);

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(100 / (double) n);

        for (int i = 0; i < this.n; i++) {
            grid.getColumnConstraints().add(columnConstraints);
            grid.getRowConstraints().add(rowConstraints);
        }

        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                Label label = new Label("elo");
                grid.add(label, i, j, 1, 1);
                GridPane.setHalignment(label, HPos.CENTER);
            }
        }
        grid.setStyle("-fx-background-color: #8fbc8f;");
    }
}