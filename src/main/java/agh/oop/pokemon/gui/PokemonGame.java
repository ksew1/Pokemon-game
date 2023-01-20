package agh.oop.pokemon.gui;

import agh.oop.pokemon.MapDirection;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class PokemonGame extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PokemonGame.class.getResource("/fxml/map-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 800);
        MapController mapController = fxmlLoader.getController();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
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