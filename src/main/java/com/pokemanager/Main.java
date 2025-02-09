package com.pokemanager;

import com.pokemanager.models.Pokemon;
import com.pokemanager.models.Trainer;

public class Main {
    public static void main(String[] args) {
        Trainer brega = new Trainer("Brega", 22);

        Pokemon pikachu = new Pokemon("Sparky", "Jolteon", "Electric");
        Pokemon charmander = new Pokemon("Flamy", "Flameon", "Fire");
        Pokemon bulbasaur = new Pokemon("Leafy", "Leafeon", "Grass");

        brega.addPokemon(pikachu);
        brega.addPokemon(charmander);
        brega.addPokemon(bulbasaur);

        brega.removePokemon("Flamy");

        
    }
}
