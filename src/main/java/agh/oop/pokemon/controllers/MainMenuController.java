package agh.oop.pokemon.controllers;

import agh.oop.pokemon.gui.ImageViewPane;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainMenuController {
    @FXML
    private GridPane grid;
    @FXML
    private Button startButton;
    @FXML
    private Button storyButton;

    @FXML
    public void initialize(ScreenController screenController) {
        Image image = new Image("/images/pokemon-logo.png");
        ImageView imageView = new ImageView(image);
        grid.add(new ImageViewPane(imageView), 0, 0);

        startButton.setOnAction(event -> screenController.activateMap());
        storyButton.setOnAction(event -> screenController.activateStory());


        FadeTransition fade = new FadeTransition(Duration.seconds(2.5), grid);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();

    }

    @FXML
    public void closeAction() {
        Stage stage = (Stage) grid.getScene().getWindow();
        stage.close();
    }
}
