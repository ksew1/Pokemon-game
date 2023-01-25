package agh.oop.pokemon.elements.pokemons;

import agh.oop.pokemon.elements.AbstractPokemon;
import agh.oop.pokemon.enums.Type;

public class Sandslash extends AbstractPokemon {
    public Sandslash(int level) {
        this.attack = 18;
        this.health = 220;
        this.type = Type.FIRE;
        this.normalAttackType = Type.FAIRY;
        this.superAttackType = Type.FIRE;
        this.ultraAttackType = Type.FIRE;

        setLevel(level);

        setImageViewPane("/images/pokemons/sandslash.png");
    }

}
