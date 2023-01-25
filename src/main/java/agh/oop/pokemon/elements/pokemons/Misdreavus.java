package agh.oop.pokemon.elements.pokemons;

import agh.oop.pokemon.elements.AbstractPokemon;
import agh.oop.pokemon.enums.Type;

public class Misdreavus extends AbstractPokemon {
    public Misdreavus(int level) {
        this.attack = 18;
        this.health = 220;
        this.type = Type.WATER;
        this.normalAttackType = Type.WATER;
        this.superAttackType = Type.GRASS;
        this.ultraAttackType = Type.WATER;

        setLevel(level);

        setImageViewPane("/images/pokemons/misdreavus.png");
    }
}
