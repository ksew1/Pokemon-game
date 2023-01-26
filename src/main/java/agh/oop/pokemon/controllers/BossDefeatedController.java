package agh.oop.pokemon.controllers;

import agh.oop.pokemon.gui.ImageViewPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class BossDefeatedController {
    @FXML
    private Button mapButton;
    @FXML
    private Button menuButton;
    @FXML
    private GridPane grid;

    @FXML
    public void initialize(ScreenController screenController) {
        mapButton.setOnAction(event -> screenController.activateMap());
        menuButton.setOnAction(event -> screenController.activateMainMenu());

        Image image = new Image("/images/ending-screen.gif");
        ImageView imageView = new ImageView(image);
        grid.add(new ImageViewPane(imageView), 0, 1);
    }
}
