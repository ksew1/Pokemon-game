package agh.oop.pokemon.elements;

import agh.oop.pokemon.utils.RandomGenerator;
import agh.oop.pokemon.utils.Vector2d;
import agh.oop.pokemon.elements.pokemons.Gengar;
import agh.oop.pokemon.interfaces.IMapElement;
import agh.oop.pokemon.interfaces.IPokemon;
import agh.oop.pokemon.interfaces.IPositionChangeObserver;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldMap implements IPositionChangeObserver {
    private final int n;
    private Vector2d heroPosition;
    private final Hero hero;
    private final IPokemon boss = new Gengar(20);
    private Vector2d bossPosition;
    private final List<Vector2d> freePositions = new ArrayList<>();
    private final Map<Vector2d, Obstacle> obstacleMap = new HashMap<>();
    private final Map<Vector2d, IPokemon> pokemonMap = new HashMap<>();

    public WorldMap(int n) {
        this.n = n;
        this.hero = new Hero();
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
        this.heroPosition = new Vector2d(n / 2  , n / 2);
        freePositions.remove(heroPosition);
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
            pokemonMap.put(freePositions.get(randomIndex), RandomGenerator.getRandomPokemon(hero.getHighestLevel()));
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
        pokemonMap.put(newPosition, RandomGenerator.getRandomPokemon(hero.getHighestLevel()));
        freePositions.remove(randomIndex);
        return newPosition;
    }

    protected boolean isInBorders(@NotNull Vector2d position) {
        return position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d(this.n - 1, this.n - 1));
    }

    public boolean canMoveTo(Vector2d position) {
        return isInBorders(position) && !(objectAt(position) instanceof Obstacle);
    }

    public IMapElement objectAt(Vector2d position) {
        if (obstacleMap.containsKey(position)) {
            return obstacleMap.get(position);
        }
        if (pokemonMap.containsKey(position)) {
            return (IMapElement) pokemonMap.get(position);
        }
        if (position.equals(bossPosition)) {
            return (IMapElement) boss;
        }
        if (position.equals(heroPosition)) {
            return hero;
        }
        return null;
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IPokemon pokemon = pokemonMap.get(oldPosition);
        pokemonMap.remove(oldPosition);
        pokemonMap.put(newPosition, pokemon);
        freePositions.remove(newPosition);
        freePositions.add(oldPosition);
    }

    // Setter methods
    public void setHeroPosition(Vector2d heroPosition) {
        this.heroPosition = heroPosition;
    }

    // Getter methods
    public Vector2d getHeroPosition() {
        return heroPosition;
    }

    public Hero getHero() {
        return hero;
    }

    public Map<Vector2d, IPokemon> getPokemonMap() {
        return pokemonMap;
    }
}