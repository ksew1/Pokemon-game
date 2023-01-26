package agh.oop.pokemon.elements;

import agh.oop.pokemon.gui.ImageViewPane;
import agh.oop.pokemon.interfaces.IMapElement;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Obstacle implements IMapElement {
    ImageViewPane imageViewPane;

    public Obstacle(String link) {
        Image image = new Image(link);
        ImageView imageView = new ImageView(image);
        this.imageViewPane = new ImageViewPane(imageView);
    }

    @Override
    public ImageViewPane getImageViewPane() {
        return this.imageViewPane;
    }
}
