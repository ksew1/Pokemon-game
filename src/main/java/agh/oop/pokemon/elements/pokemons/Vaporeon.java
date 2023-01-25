package agh.oop.pokemon.elements.pokemons;

import agh.oop.pokemon.elements.AbstractPokemon;
import agh.oop.pokemon.enums.Type;

public class Vaporeon extends AbstractPokemon {
    public Vaporeon(int level) {
        this.attack = 30;
        this.health = 100;
        this.type = Type.WATER;
        this.normalAttackType = Type.WATER;
        this.superAttackType = Type.WATER;
        this.ultraAttackType = Type.WATER;

        setLevel(level);

        setImageViewPane("/images/pokemons/vaporeon.png");
    }
}
