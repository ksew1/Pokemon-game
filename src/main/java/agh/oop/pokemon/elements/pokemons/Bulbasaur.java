package agh.oop.pokemon.elements.pokemons;

import agh.oop.pokemon.elements.AbstractPokemon;
import agh.oop.pokemon.enums.Type;

public class Bulbasaur extends AbstractPokemon {

    public Bulbasaur(int level) {
        this.attack = 20;
        this.health = 200;
        this.type = Type.GRASS;
        this.normalAttackType = Type.GRASS;
        this.superAttackType = Type.FAIRY;
        this.ultraAttackType = Type.GRASS;

        setLevel(level);

        setImageViewPane("/images/pokemons/bulbasaur.png");
    }
}
