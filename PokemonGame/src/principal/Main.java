package principal;

import controleur.Combat;
import modele.Joueur;
import modele.Pokemon;
import modele.Type;
import vue.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        
       
        menu.afficherPrincipal();
        
 
        int choix = menu.getChoix();

        if (choix == 1) {
            nouvellePartie(); 
        } else if (choix == 2) {
            System.out.println("Au revoir !");
        } else {
            System.out.println("Choix invalide. Fin du programme.");
        }
    }

    private static void nouvellePartie() {
        Menu menu = new Menu();
        Joueur joueur = new Joueur("Dresseur");
        
        menu.afficherChoixStarter();
        int starter = menu.getChoix();
        
        Pokemon pokemonDepart = null;
        switch (starter) {
            case 1:
                pokemonDepart = new Pokemon("Salam�che", Type.FEU, 5);
                break;
            case 2:
                pokemonDepart = new Pokemon("Carapuce", Type.EAU, 5);
                break;
            case 3:
                pokemonDepart = new Pokemon("Bulbizarre", Type.PLANTE, 5);
                break;
            default:
                System.out.println("Choix invalide, Salam�che est choisi par d�faut.");
                pokemonDepart = new Pokemon("Salam�che", Type.FEU, 5);
        }
        
        joueur.ajouterPokemon(pokemonDepart);
        
        Pokemon pokemonSauvage = new Pokemon("Rondoudou", Type.NORMAL, 3);
        Combat combat = new Combat(joueur, pokemonSauvage);
        combat.demarrer();
    }
}