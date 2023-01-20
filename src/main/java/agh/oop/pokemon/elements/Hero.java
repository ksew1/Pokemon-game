package agh.oop.pokemon.elements;

import agh.oop.pokemon.elements.IMapElement;
import agh.oop.pokemon.gui.ImageViewPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Hero implements IMapElement {
    ImageViewPane imageViewPane;

    public Hero() {
        Image image = new Image("/images/hero.png");
        ImageView imageView = new ImageView(image);
        this.imageViewPane = new ImageViewPane(imageView);
    }

    @Override
    public ImageViewPane getImageViewPane() {
        return this.imageViewPane;
    }
}
