package agh.oop.pokemon.elements;

import agh.oop.pokemon.Type;
import agh.oop.pokemon.elements.AbstractPokemon;

public class Bulbasaur extends AbstractPokemon {

    public Bulbasaur(int level) {
        this.attack = 30;
        this.health = 20;
        this.type = Type.FIRE;
        this.normalAttackType = Type.WATER;
        this.superAttackType = Type.AIR;
        this.ultraAttackType = Type.FIRE;

        setLevel(level);

        setImageViewPane("/images/pokemons/bulbasaur.png");
    }
}
