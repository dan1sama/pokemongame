
package modele;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private String nom;
    private List<Pokemon> equipe = new ArrayList<>();
    private Pokemon pokemonActif;

    public Joueur(String nom) {
        this.nom = nom;
    }

    public void ajouterPokemon(Pokemon pokemon) {
        equipe.add(pokemon);
        if (pokemonActif == null) {
            pokemonActif = pokemon; 
        }
    }

    public void changerPokemon(int index) {
        if (index >= 0 && index < equipe.size()) {
            pokemonActif = equipe.get(index);
        }
    }

    
    public String getNom() { return nom; }
    public List<Pokemon> getEquipe() { return equipe; }
    public Pokemon getPokemonActif() { return pokemonActif; }
}