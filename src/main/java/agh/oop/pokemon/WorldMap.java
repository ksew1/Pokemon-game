package agh.oop.pokemon;

import agh.oop.pokemon.elements.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldMap {
    private final int n;
    private Vector2d heroPosition;
    private final Hero hero = new Hero();
    private Vector2d bossPosition;
    private final List<Vector2d> freePositions = new ArrayList<>();
    private final Map<Vector2d, Obstacle> obstacleMap = new HashMap<>();
    private final Map<Vector2d, AbstractPokemon> pokemonMap = new HashMap<>();

    public WorldMap(int n) {
        this.n = n;
        generateFreePositions();
        placeHero();
        placeBoss();
    }

    private void generateFreePositions() {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                freePositions.add(new Vector2d(i, j));
            }
        }
    }

    private void placeHero() {
        int randomIndex = RandomGenerator.getRandom(freePositions.size());
        this.heroPosition = freePositions.get(randomIndex);
        freePositions.remove(randomIndex);
    }

    private void placeBoss() {
        int randomIndex = RandomGenerator.getRandom(freePositions.size());
        this.bossPosition = freePositions.get(randomIndex);
        freePositions.remove(randomIndex);
    }

    public void placeObstacles(int number) {
        if (number > freePositions.size()) number = freePositions.size();
        for (int i = 0; i < number; i++) {
            int randomIndex = RandomGenerator.getRandom(freePositions.size());
            obstacleMap.put(freePositions.get(randomIndex), new Obstacle(RandomGenerator.getRandomObstacle()));
            freePositions.remove(randomIndex);
        }
    }

    public void placePokemons(int number) {
        if (number > freePositions.size()) number = freePositions.size();
        for (int i = 0; i < number; i++) {
            int randomIndex = RandomGenerator.getRandom(freePositions.size());
            pokemonMap.put(freePositions.get(randomIndex), new Bulbasaur(1));
            freePositions.remove(randomIndex);
        }
    }

    public Vector2d deletePokemonAndPlace(Vector2d position) {
        //remove
        pokemonMap.remove(position);
        freePositions.add(position);
        //add
        int randomIndex = RandomGenerator.getRandom(freePositions.size());
        Vector2d newPosition = freePositions.get(randomIndex);
        pokemonMap.put(newPosition, new Bulbasaur(1));
        freePositions.remove(randomIndex);
        return newPosition;

    }

    public boolean canMoveTo(Vector2d position) {
        return isInBorders(position) && !(objectAt(position) instanceof Obstacle);
    }

    protected boolean isInBorders(Vector2d position) {
        return position.follows(new Vector2d(0, 0)) &&
                position.precedes(new Vector2d(this.n - 1, this.n - 1));
    }

    public IMapElement objectAt(Vector2d position) {
        if (obstacleMap.containsKey(position)) {
            return obstacleMap.get(position);
        }
        if (pokemonMap.containsKey(position)) {
            return pokemonMap.get(position);
        }
        if (position.equals(heroPosition)) {
            return hero;
        }
        return null;
    }

    public Vector2d getHeroPosition() {
        return heroPosition;
    }

    public void setHeroPosition(Vector2d heroPosition) {
        this.heroPosition = heroPosition;
    }

    public Hero getHero() {
        return hero;
    }

}
