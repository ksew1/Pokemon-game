package agh.oop.pokemon.controllers;

import agh.oop.pokemon.gui.ImageViewPane;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class StoryController {
    @FXML private Button menuButton;
    @FXML private GridPane grid;

    @FXML
    public void initialize(ScreenController screenController ) {
        menuButton.setOnAction(event -> screenController.activateMainMenu());

        Image heroImage = new Image("/images/hero.png");
        ImageView heroImageView = new ImageView(heroImage);
        grid.add(new ImageViewPane(heroImageView), 1, 0);

        Image bossImage = new Image("/images/pokemons/gengar.png");
        ImageView bossImageView = new ImageView(bossImage);
        grid.add(new ImageViewPane(bossImageView), 1, 1);

    }
}
