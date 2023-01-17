package agh.oop.pokemon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PokemonGame extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PokemonGame.class.getResource("map-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 800);


        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
        /*<VBox fx:id="mainVbox" alignment="CENTER" prefHeight="518.0" prefWidth="427.0" spacing="20.0" xmlns:fx="http://javafx.com/fxml/1" xmlns="http://javafx.com/javafx/19" fx:controller="agh.oop.pokemon.MapController">
    <padding>
        <Insets bottom="20.0" left="20.0" right="20.0" top="20.0" />
    </padding>
</VBox>  */
    }
}