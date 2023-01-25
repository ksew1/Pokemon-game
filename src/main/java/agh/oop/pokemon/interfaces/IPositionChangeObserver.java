package agh.oop.pokemon.interfaces;

import agh.oop.pokemon.Vector2d;

public interface IPositionChangeObserver {
    void positionChanged(Vector2d oldPosition, Vector2d newPosition);
}
