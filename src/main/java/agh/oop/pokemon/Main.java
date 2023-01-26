package agh.oop.pokemon;

import agh.oop.pokemon.gui.PokemonGame;
import javafx.application.Application;

public class Main {
    //        FIRE FAIRY GRASS WATER
    // FIRE  |  1    1    1.5   1.5
    // FAIRY |  1    1     2     2
    // GRASS | 1.5   2     1     1
    // WATER | 1.5   2     1     1
    public static void main(String[] args) {
        Application.launch(PokemonGame.class, args);
    }
}
