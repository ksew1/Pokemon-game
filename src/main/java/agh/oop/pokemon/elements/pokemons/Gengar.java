package agh.oop.pokemon.elements.pokemons;

import agh.oop.pokemon.elements.AbstractPokemon;
import agh.oop.pokemon.enums.Type;

public class Gengar extends AbstractPokemon {
    public Gengar(int level) {
        this.attack = 24;
        this.health = 160;
        this.type = Type.FAIRY;
        this.normalAttackType = Type.FAIRY;
        this.superAttackType = Type.FAIRY;
        this.ultraAttackType = Type.WATER;

        setLevel(level);
        setImageViewPane("/images/pokemons/gengar.png");
    }
}