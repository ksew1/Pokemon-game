package agh.oop.pokemon.controllers;

import agh.oop.pokemon.utils.Vector2d;
import agh.oop.pokemon.elements.Hero;
import agh.oop.pokemon.gui.PokemonGame;
import agh.oop.pokemon.interfaces.IPokemon;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


import java.io.IOException;

public class ScreenController {
    private final Pane mapPane;
    private final MapController mapController;
    private String activeScene;
    private final Scene main;
    private Vector2d newHeroPosition;

    public ScreenController(Scene scene) throws IOException {
        FXMLLoader mapLoader = new FXMLLoader(PokemonGame.class.getResource("/fxml/map-view.fxml"));
        this.mapPane = mapLoader.load();
        this.mapController = mapLoader.getController();
        mapController.initialize(this);

        this.main = scene;
        this.main.getStylesheets().add("/style.css");
        activateMainMenu();
    }

    // Activate methods
    public void activateMap() {
        activeScene = "map";
        main.setRoot(mapPane);
    }
    public void activateMainMenu() {
        try {
            activeScene = "mainMenu";
            FXMLLoader mainMenuLoader = new FXMLLoader(PokemonGame.class.getResource("/fxml/main-menu-view.fxml"));
            Pane mainMenuPane = mainMenuLoader.load();
            MainMenuController mainMenuController = mainMenuLoader.getController();
            mainMenuController.initialize(this);
            main.setRoot(mainMenuPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void activateStory() {
        try {
            activeScene = "story";
            FXMLLoader storyLoader = new FXMLLoader(PokemonGame.class.getResource("/fxml/story-view.fxml"));
            Pane storyPane = storyLoader.load();
            StoryController storyController = storyLoader.getController();
            storyController.initialize(this);
            main.setRoot(storyPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void activateBossDefeated() {
        try {
            activeScene = "bossDefeated";
            FXMLLoader defeatLoader = new FXMLLoader(PokemonGame.class.getResource("/fxml/boss-defeated-view.fxml"));
            Pane defeatPane = defeatLoader.load();
            BossDefeatedController defeatedController = defeatLoader.getController();
            defeatedController.initialize(this);
            main.setRoot(defeatPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void activateChoice(Hero hero) {
        try {
            activeScene = "choice";
            FXMLLoader choiceLoader = new FXMLLoader(PokemonGame.class.getResource("/fxml/choice-view.fxml"));
            Pane choicePane = choiceLoader.load();
            main.setRoot(choicePane);
            ChoiceController choiceController = choiceLoader.getController();
            choiceController.initialize(this, hero);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void activateBeforeFight(Hero hero) {
        try {
            activeScene = "beforeFight";
            FXMLLoader beforeFightLoader = new FXMLLoader(PokemonGame.class.getResource("/fxml/before-fight.fxml"));
            Pane beforeFightPane = beforeFightLoader.load();
            BeforeFightController beforeFightController = beforeFightLoader.getController();
            beforeFightController.initialize(this, hero);
            main.setRoot(beforeFightPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void activateFight(Hero hero, IPokemon chosenPokemon) {
        try {
            activeScene = "fight";
            FXMLLoader fightLoader = new FXMLLoader(PokemonGame.class.getResource("/fxml/fight-view.fxml"));
            Pane fightPane = fightLoader.load();
            FightController fightController = fightLoader.getController();
            fightController.initialize(this, hero, chosenPokemon);
            main.setRoot(fightPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // Setter methods

    public void setNewHeroPosition(Vector2d newHeroPosition) {
        this.newHeroPosition = newHeroPosition;
    }
    // Getter methods

    public String getActiveScene() {
        return activeScene;
    }

    public MapController getMapController() {
        return mapController;
    }

    public Vector2d getNewHeroPosition() {
        return newHeroPosition;
    }

}
