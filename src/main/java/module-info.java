module agh.oop.pokemon {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens agh.oop.pokemon to javafx.fxml;
    exports agh.oop.pokemon;
}