package agh.oop.pokemon.elements.pokemons;

import agh.oop.pokemon.elements.AbstractPokemon;
import agh.oop.pokemon.enums.Type;

public class Starmie extends AbstractPokemon {
    public Starmie(int level) {
        this.attack = 14;
        this.health = 260;
        this.type = Type.FAIRY;
        this.normalAttackType = Type.WATER;
        this.superAttackType = Type.FAIRY;
        this.ultraAttackType = Type.FAIRY;

        setLevel(level);

        setImageViewPane("/images/pokemons/starmie.png");
    }
}