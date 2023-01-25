package agh.oop.pokemon.utils;

import agh.oop.pokemon.controllers.ScreenController;
import agh.oop.pokemon.elements.pokemons.Gengar;
import agh.oop.pokemon.enums.AttackType;
import agh.oop.pokemon.enums.Type;
import agh.oop.pokemon.interfaces.IPokemon;
import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.jetbrains.annotations.NotNull;


public class Animations {
    private final Text info;
    private final Button normalButton;
    private final Button superButton;
    private final Button ultraButton;
    private final Button catchButton;
    private final ScreenController screenController;


    public Animations(Text info, Button normalButton, Button superButton, Button ultraButton, Button catchButton, ScreenController screenController) {
        this.info = info;
        this.normalButton = normalButton;
        this.superButton = superButton;
        this.ultraButton = ultraButton;
        this.catchButton = catchButton;
        this.screenController = screenController;
    }

    public static void fadeAnimation(Node node) {
        FadeTransition fade = new FadeTransition(Duration.seconds(1), node);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    public void catchAnimation(boolean catched, IPokemon pokemon, IPokemon enemy, Label pokemonHealth, Label enemyHealth) {
        info.setFill(Color.BLACK);
        if (catched) {
            info.setText("Catched!!");

            pokemon.levelUp();
            screenController.getMapController().afterFight(true, screenController.getNewHeroPosition());
            endFightAnimation(true, enemy);
        } else {
            info.setText("Missed catch :(");
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), info);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setOnFinished(e -> {
                FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), info);
                fadeOut.setFromValue(1);
                fadeOut.setToValue(0);
                fadeOut.setOnFinished(event -> pokemonAnimationAttack(enemy, pokemon, enemyHealth, pokemonHealth, RandomGenerator.getAttackType(), false));
                fadeOut.play();
            });
            fadeIn.play();
        }
    }

    private void fadeInAndOutAnimation(IPokemon pokemon, IPokemon enemy, Label pokemonHealth, Label enemyHealth, boolean secondAnimation) {
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), info);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setOnFinished(e -> {
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), info);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            if (secondAnimation) {
                fadeOut.setOnFinished(event -> pokemonAnimationAttack(enemy, pokemon, enemyHealth, pokemonHealth, RandomGenerator.getAttackType(), false));
            }
            fadeOut.play();
        });
        fadeIn.play();
    }

    private void endFightAnimation(boolean won, IPokemon enemy) {
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), info);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setOnFinished(e ->{
            if (won && enemy instanceof Gengar) {
                screenController.activateBossDefeated();
            } else {
                screenController.activateMap();
            }


        } );
        fadeIn.play();

    }

    public void pokemonAnimationAttack(IPokemon pokemon, IPokemon enemy, Label pokemonHealth, Label enemyHealth, @NotNull AttackType attackType, boolean secondAnimation) {
        int damage = 0;
        Color color = Color.GRAY;
        String text = "";
        Type type = Type.FIRE;
        switch (attackType) {
            case NORMAL -> damage = pokemon.getNormalAttack();
            case SUPER -> damage = pokemon.getSuperAttack();
            case ULTRA -> damage = pokemon.getUltraAttack();
        }
        switch (attackType) {
            case NORMAL -> color = pokemon.getNormalAttackType().toColor();
            case SUPER -> color = pokemon.getSuperAttackType().toColor();
            case ULTRA -> color = pokemon.getUltraAttackType().toColor();
        }
        switch (attackType) {
            case NORMAL -> type = pokemon.getNormalAttackType();
            case SUPER -> type = pokemon.getSuperAttackType();
            case ULTRA -> type = pokemon.getUltraAttackType();
        }
        damage = (int) (damage * type.damageTo(enemy.getType()));

        if (secondAnimation)
            text += "You: ";
        else
            text += pokemon.getClass().getSimpleName() + ": ";

        if (damage == 0) {
            text += "Miss!";
            color = Color.GRAY;
        } else {
            text += attackType + "\ndamage: " + damage + "!";
        }
        info.setText(text);
        info.setFill(color);
        normalButton.setDisable(secondAnimation);
        superButton.setDisable(secondAnimation);
        ultraButton.setDisable(secondAnimation);
        catchButton.setDisable(secondAnimation);

        enemy.setCurrentHealth(Math.max(enemy.getCurrentHealth() - damage, 0));
        enemyHealth.setText("Health: " + enemy.getCurrentHealth() + "/" + enemy.getHealth());
        if (enemy.getCurrentHealth() <= 0) {
            if (!secondAnimation) {
                enemy.levelDown();
                info.setText("You lost :(");
            } else {
                pokemon.levelUp();
                info.setText("You won!!!");
            }

            screenController.getMapController().afterFight(secondAnimation, screenController.getNewHeroPosition());
            info.setFill(Color.BLACK);
            endFightAnimation(secondAnimation, enemy);
        } else {
            fadeInAndOutAnimation(pokemon, enemy, pokemonHealth, enemyHealth, secondAnimation);
        }

    }
}
