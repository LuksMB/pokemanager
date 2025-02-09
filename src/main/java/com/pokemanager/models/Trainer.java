package com.pokemanager.models;
import java.io.Serializable;
import java.util.List;

public class Trainer implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private List<Pokemon> pokemonTeam;

    public Trainer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addPokemon(Pokemon pokemon) {
        if (pokemonTeam.size() < 6) { 
            pokemonTeam.add(pokemon);
            System.out.println(pokemon.getNickname() + " foi adicionado ao time de " + name + "!");
        } else {
            System.out.println("O time já tem 6 Pokémon! Libere um para adicionar outro.");
        }
    }

    public void removePokemon(String nickname) {
        boolean removed = pokemonTeam.removeIf(pokemon -> pokemon.getNickname().equalsIgnoreCase(nickname));

        if (removed) {
            System.out.println(nickname + " foi removido do time de " + name + "!");
        } else {
            System.out.println("Nenhum Pokémon com o nome " + nickname + " foi encontrado no time.");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Pokemon> getPokemonTeam() {
        return pokemonTeam;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pokemonTeam=" + pokemonTeam +
                '}';
    }
}
