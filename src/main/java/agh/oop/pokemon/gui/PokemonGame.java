package agh.oop.pokemon.gui;

import agh.oop.pokemon.controllers.MapController;
import agh.oop.pokemon.controllers.ScreenController;
import agh.oop.pokemon.enums.MapDirection;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class PokemonGame extends Application {
    @Override
    public void start(@NotNull Stage stage) throws IOException {


        Scene scene = new Scene(new VBox(), 800, 800);
        ScreenController screenController = new ScreenController(scene);
        MapController mapController = screenController.getMapController();

        scene.setOnKeyPressed(event -> {
            if (screenController.getActiveScene().equals("map")) {
                switch (event.getCode()) {
                    case UP, W -> mapController.moveHero(MapDirection.NORTH);
                    case DOWN, S -> mapController.moveHero(MapDirection.SOUTH);
                    case LEFT, A -> mapController.moveHero(MapDirection.WEST);
                    case RIGHT, D -> mapController.moveHero(MapDirection.EAST);
                }
            }
        });
        stage.setMaximized(true);
        stage.setTitle("Pokemon");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}