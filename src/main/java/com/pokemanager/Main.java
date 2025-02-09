package com.pokemanager;

import com.pokemanager.models.Pokemon;
import com.pokemanager.models.Trainer;
import com.pokemanager.repository.InFileRepository;
import com.pokemanager.repository.InMemoryRepository;

public class Main {
    public static void main(String[] args) {
        // Testes com o repositório em memória estão comentados
        // InMemoryRepository<Pokemon> pokeRepo = new InMemoryRepository<>();
        // InMemoryRepository<Trainer> trainerRepo = new InMemoryRepository<>();

        InFileRepository<Pokemon> pokemonsFile = new InFileRepository<>("pokemonList");
        InFileRepository<Trainer> trainersFile = new InFileRepository<>("trainersList");

        System.out.println("---Pokemons loaded---\n");
        for (Pokemon p : pokemonsFile.findAll()) {
            System.out.println(p);
        }
        System.out.println("\n--- Trainers loaded ---\n");
        for (Trainer t : trainersFile.findAll()) {
            System.out.println(t);
        }

        // Trainer brega = new Trainer("Brega", 22);
        // trainerRepo.save(brega);
        // trainersFile.save(brega);

        // Pokemon sparky = new Pokemon("Sparky", "Jolteon", "Electric");
        // pokeRepo.save(sparky);
        // pokemonsFile.save(sparky);

        // Pokemon flamy = new Pokemon("Flamy", "Flameon", "Fire");
        // pokeRepo.save(flamy);
        // pokemonsFile.save(flamy);

        // Pokemon leafy = new Pokemon("Leafy", "Leafeon", "Grass");
        // pokeRepo.save(leafy);
        // pokemonsFile.save(leafy);

        // brega.addPokemon(sparky);
        // brega.addPokemon(flamy);
        // brega.addPokemon(leafy);

        // trainerRepo.update(brega);
        // trainersFile.update(brega);

        // System.out.println("\n--- Pokémons do treinador " + brega.getName());
        // for (Pokemon p : brega.getPokemonTeam()) {
        //     System.out.println(p);
        // }
        
    }
}
