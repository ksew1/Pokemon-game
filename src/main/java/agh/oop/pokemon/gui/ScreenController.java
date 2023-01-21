package agh.oop.pokemon.gui;

import agh.oop.pokemon.elements.Hero;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


import java.io.IOException;

public class ScreenController {
    private final Pane mapPane;
    private final MapController mapController;
    private String activeScene;

    private final Scene main;

    public ScreenController(Scene scene) throws IOException {
        FXMLLoader mapLoader = new FXMLLoader(PokemonGame.class.getResource("/fxml/map-view.fxml"));


        this.mapPane = mapLoader.load();

        this.mapController = mapLoader.getController();
        mapController.initialize(this);

        this.main = scene;
        activateMap();

    }

    public String getActiveScene() {
        return activeScene;
    }

    public MapController getMapController() {
        return mapController;
    }


    protected void activateMap() {
        activeScene = "map";
        main.setRoot(mapPane);
    }

    protected void activateFight(Hero hero) {
        try {
            activeScene = "fight";
            FXMLLoader fightLoader = new FXMLLoader(PokemonGame.class.getResource("/fxml/fight-view.fxml"));
            Pane fightPane = fightLoader.load();
            FightController fightController = fightLoader.getController();
            fightController.initialize(this, hero);
            main.setRoot(fightPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
