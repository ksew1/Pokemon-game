package agh.oop.pokemon.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BossDefeatedController {
    @FXML private Button mapButton;
    @FXML
    public void initialize(ScreenController screenController ) {
        mapButton.setOnAction(event -> screenController.activateMap());

    }
}
