package agh.oop.pokemon.elements.pokemons;

import agh.oop.pokemon.elements.AbstractPokemon;
import agh.oop.pokemon.enums.Type;

public class Diglett extends AbstractPokemon {
    public Diglett(int level) {
        this.attack = 20;
        this.health = 200;
        this.type = Type.GRASS;
        this.normalAttackType = Type.GRASS;
        this.superAttackType = Type.GRASS;
        this.ultraAttackType = Type.WATER;

        setLevel(level);

        setImageViewPane("/images/pokemons/diglett.png");
    }
}
