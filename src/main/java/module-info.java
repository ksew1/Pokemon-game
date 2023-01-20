module agh.oop.pokemon {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens agh.oop.pokemon to javafx.fxml;
    exports agh.oop.pokemon;
    exports agh.oop.pokemon.gui;
    opens agh.oop.pokemon.gui to javafx.fxml;
    exports agh.oop.pokemon.elements;
    opens agh.oop.pokemon.elements to javafx.fxml;
}