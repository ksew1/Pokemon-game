package agh.oop.pokemon.elements.pokemons;

import agh.oop.pokemon.elements.AbstractPokemon;
import agh.oop.pokemon.enums.Type;

public class Eevee extends AbstractPokemon {
    public Eevee(int level) {
        this.attack = 25;
        this.health = 150;
        this.type = Type.FIRE;
        this.normalAttackType = Type.FIRE;
        this.superAttackType = Type.FIRE;
        this.ultraAttackType = Type.FAIRY;

        setLevel(level);

        setImageViewPane("/images/pokemons/eevee.png");
    }
}
