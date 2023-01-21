package agh.oop.pokemon.gui;

import agh.oop.pokemon.MapDirection;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class PokemonGame extends Application {
    @Override
    public void start(Stage stage) throws IOException {


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


        stage.setTitle("Pokemon");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}