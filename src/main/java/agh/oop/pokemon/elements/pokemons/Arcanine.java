package agh.oop.pokemon.elements.pokemons;

import agh.oop.pokemon.elements.AbstractPokemon;
import agh.oop.pokemon.enums.Type;

public class Arcanine extends AbstractPokemon {
    public Arcanine(int level) {
        this.attack = 10000;
        this.health = 10000;
        this.type = Type.FIRE;
        this.normalAttackType = Type.FIRE;
        this.superAttackType = Type.FIRE;
        this.ultraAttackType = Type.FAIRY;

        setLevel(level);

        setImageViewPane("/images/pokemons/arcanine.png");
    }
}
