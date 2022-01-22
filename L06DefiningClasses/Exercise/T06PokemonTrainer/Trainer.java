package L06DefiningClasses.Exercise.T06PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private Integer numBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.numBadges = 0;
        pokemons = new ArrayList<>();
    }

    public String toString() {
        return String.format("%s %d %d", name, numBadges, pokemons.size());
    }

    public Integer getNumBadges() {
        return numBadges;
    }

    public void addPokemon(Pokemon pokemon) {pokemons.add(pokemon);}

    public void turn(String element) {
        long numPokemons = pokemons.stream().filter(pokemon -> pokemon.getElement().equals(element)).count();
        if (numPokemons > 0)
            numBadges++;
        else {
                pokemons.removeIf(Pokemon::hit);
        }
    }
}
