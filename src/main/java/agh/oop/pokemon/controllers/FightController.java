package agh.oop.pokemon.controllers;


import agh.oop.pokemon.utils.Animations;
import agh.oop.pokemon.utils.RandomGenerator;
import agh.oop.pokemon.elements.Hero;
import agh.oop.pokemon.enums.AttackType;
import agh.oop.pokemon.enums.Type;
import agh.oop.pokemon.interfaces.IPokemon;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.jetbrains.annotations.NotNull;


public class FightController {

    @FXML
    private GridPane grid;

    @FXML
    private Label chosenPokemonHealth;
    @FXML
    private Label chosenPokemonType;
    @FXML
    private Label chosenPokemonLevel;
    @FXML
    private Label opponentHealth;
    @FXML
    private Label opponentType;
    @FXML
    private Label opponentLevel;
    @FXML
    private Text info;
    @FXML
    private Button normalButton;
    @FXML
    private Button superButton;
    @FXML
    private Button ultraButton;
    @FXML
    private Button catchButton;

    private IPokemon opponent;
    private Hero hero;

    private IPokemon chosenPokemon;
    private Animations animations;


    @FXML
    public void initialize(ScreenController screenController, @NotNull Hero hero, @NotNull IPokemon chosenPokemon) {
        this.chosenPokemon = chosenPokemon;
        this.hero = hero;
        this.opponent = hero.getOpponent();
        this.animations = new Animations(info, normalButton, superButton, ultraButton, catchButton, screenController);

        normalButton.setOnAction(e -> renderHealthAndAttack(AttackType.NORMAL));
        superButton.setOnAction(e -> renderHealthAndAttack(AttackType.SUPER));
        ultraButton.setOnAction(e -> renderHealthAndAttack(AttackType.ULTRA));

        setButtonColor(normalButton, chosenPokemon.getNormalAttackType());
        setButtonColor(superButton, chosenPokemon.getSuperAttackType());
        setButtonColor(ultraButton, chosenPokemon.getUltraAttackType());

        grid.add(opponent.getImageViewPane(), 0, 0);
        grid.add(chosenPokemon.getImageViewPane(), 3, 1);


        TranslateTransition translateTransition;

        translateTransition = new TranslateTransition(Duration.millis(500), chosenPokemon.getImageViewPane());
        translateTransition.setFromX(-2000);
        translateTransition.setToX(0);
        translateTransition.play();

        translateTransition = new TranslateTransition(Duration.millis(500), opponent.getImageViewPane());
        translateTransition.setFromX(2000);
        translateTransition.setToX(0);
        translateTransition.setOnFinished(e -> initAnimation());
        translateTransition.play();


    }

    @FXML
    private void tryToCatch() {
        double catchChance = (1 - (double) opponent.getCurrentHealth() / opponent.getHealth()) * 1000;
        int randomNumber = RandomGenerator.getRandom(1000);
        if (randomNumber < catchChance) {
            hero.getAllPokemons().add(opponent);
            animations.catchAnimation(true, chosenPokemon, opponent, chosenPokemonHealth, opponentHealth);
        } else {
            animations.catchAnimation(false, chosenPokemon, opponent, chosenPokemonHealth, opponentHealth);
        }


    }


    private void renderHealthAndAttack(AttackType attackType) {
        animations.pokemonAnimationAttack(chosenPokemon, opponent, chosenPokemonHealth, opponentHealth, attackType, true);
    }

    private void initAnimation() {
        normalButton.setText("Normal attack: " + chosenPokemon.getNormalAttack());
        superButton.setText("Super attack: " + chosenPokemon.getSuperAttackWithOutMiss() + "\nMiss chance: 25%");
        ultraButton.setText("Ultra attack: " + chosenPokemon.getUltraAttackWithOutMiss() + "\nMiss chance: 33%");

        opponent.setCurrentHealth(this.opponent.getHealth());
        chosenPokemon.setCurrentHealth(this.chosenPokemon.getHealth());

        opponentType.setText(opponent.getType().toString());
        opponentType.setTextFill(opponent.getType().toColor());

        chosenPokemonType.setText(chosenPokemon.getType().toString());
        chosenPokemonType.setTextFill(chosenPokemon.getType().toColor());


        opponentHealth.setText("Health: " + this.opponent.getCurrentHealth() + "/" + this.opponent.getHealth());
        chosenPokemonHealth.setText("Health: " + chosenPokemon.getCurrentHealth() + "/" + chosenPokemon.getHealth());

        opponentLevel.setText("Level: " + this.opponent.getLevel());

        chosenPokemonLevel.setText("Level: " + this.chosenPokemon.getLevel());
        Animations.fadeAnimation(opponentType);
        Animations.fadeAnimation(opponentLevel);
        Animations.fadeAnimation(opponentHealth);
        Animations.fadeAnimation(chosenPokemonType);
        Animations.fadeAnimation(chosenPokemonLevel);
        Animations.fadeAnimation(chosenPokemonHealth);
        Animations.fadeAnimation(normalButton);
        Animations.fadeAnimation(superButton);
        Animations.fadeAnimation(ultraButton);
        Animations.fadeAnimation(catchButton);
        Animations.fadeAnimation(catchButton);
    }

    private void setButtonColor(Button button, @NotNull Type type) {
        switch (type) {
            case GRASS -> button.setStyle("-fx-border-color: green; -fx-border-width: 5px ");
            case FAIRY -> button.setStyle("-fx-border-color: pink; -fx-border-width: 5px ");
            case FIRE -> button.setStyle("-fx-border-color: red; -fx-border-width: 5px ");
            case WATER -> button.setStyle("-fx-border-color: blue; -fx-border-width: 5px ");

        }
    }
}
