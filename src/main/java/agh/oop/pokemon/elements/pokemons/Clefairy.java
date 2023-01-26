package agh.oop.pokemon.elements.pokemons;

import agh.oop.pokemon.elements.AbstractPokemon;
import agh.oop.pokemon.enums.Type;

public class Clefairy extends AbstractPokemon {
    public Clefairy(int level) {
        this.attack = 20;
        this.health = 260;
        this.type = Type.FAIRY;
        this.normalAttackType = Type.FAIRY;
        this.superAttackType = Type.FAIRY;
        this.ultraAttackType = Type.FAIRY;

        setLevel(level);

        setImageViewPane("/images/pokemons/clefairy.png");
    }
}
