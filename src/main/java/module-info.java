module agh.oop.pokemon {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires org.jetbrains.annotations;

    opens agh.oop.pokemon to javafx.fxml;
    exports agh.oop.pokemon;
    exports agh.oop.pokemon.gui;
    opens agh.oop.pokemon.gui to javafx.fxml;
    exports agh.oop.pokemon.elements;
    opens agh.oop.pokemon.elements to javafx.fxml;
    exports agh.oop.pokemon.enums;
    opens agh.oop.pokemon.enums to javafx.fxml;
    exports agh.oop.pokemon.interfaces;
    opens agh.oop.pokemon.interfaces to javafx.fxml;
    exports agh.oop.pokemon.controllers;
    opens agh.oop.pokemon.controllers to javafx.fxml;
    exports agh.oop.pokemon.elements.pokemons;
    opens agh.oop.pokemon.elements.pokemons to javafx.fxml;
}