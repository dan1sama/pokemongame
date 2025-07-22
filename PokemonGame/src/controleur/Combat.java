package controleur;

import modele.Attaque; 

import modele.Joueur;
import modele.Pokemon;
import modele.Type;
import java.util.Random;
import java.util.Scanner;

public class Combat {
    
    private Joueur joueur;
    private Pokemon pokemonSauvage;
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    public Combat(Joueur joueur, Pokemon pokemonSauvage) {
        this.joueur = joueur;
        this.pokemonSauvage = pokemonSauvage;
    }

    public void demarrer() {
        System.out.println("Un " + pokemonSauvage.getNom() + " sauvage appara�t !");
        
        while (!joueur.getPokemonActif().estKO() && !pokemonSauvage.estKO()) {
            tourDeJeu();
        }
        
        if (pokemonSauvage.estKO()) {
            System.out.println("Vous avez gagn� le combat !");
            joueur.getPokemonActif().monterNiveau();
        } else {
            System.out.println("Votre Pok�mon est KO !");
        }
    }

    private void tourDeJeu() {
        afficherEtat();
        
        
        System.out.println("Choisissez une action :");
        System.out.println("1. Attaquer");
        System.out.println("2. Changer de Pok�mon");
        int choix = scanner.nextInt();
        
        if (choix == 1) {
            choisirAttaque();
        } else {
            changerPokemon();
        }
        
        
        if (!pokemonSauvage.estKO()) {
            attaquerAdversaire();
        }
    }

    private void choisirAttaque() {
        Pokemon actif = joueur.getPokemonActif();
        Attaque[] attaques = actif.getAttaques();
        
        System.out.println("Choisissez une attaque :");
        for (int i = 0; i < attaques.length; i++) {
            System.out.println((i+1) + ". " + attaques[i].getNom());
        }
        
        int choix = scanner.nextInt() - 1;
        actif.attaquer(attaques[choix], pokemonSauvage);
    }

    private void changerPokemon() {
      System.out.println("Fonctionnalit� non impl�ment�e dans cette �tape.");
    }

    private void attaquerAdversaire() {
        Attaque[] attaques = pokemonSauvage.getAttaques();
        Attaque attaque = attaques[random.nextInt(attaques.length)];
        pokemonSauvage.attaquer(attaque, joueur.getPokemonActif());
    }

    private void afficherEtat() {
        System.out.println("\n--- �tat du combat ---");
        System.out.println(joueur.getNom() + " : " + joueur.getPokemonActif().getNom() + 
                         " (PV: " + joueur.getPokemonActif().getPv() + "/" + joueur.getPokemonActif().getPvMax() + ")");
        System.out.println("Adversaire : " + pokemonSauvage.getNom() + 
                         " (PV: " + pokemonSauvage.getPv() + "/" + pokemonSauvage.getPvMax() + ")");
    }
}