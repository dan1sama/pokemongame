package vue;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public void afficherPrincipal() {
        System.out.println("===== Pokémon Java =====");
        System.out.println("1. Nouvelle partie");
        System.out.println("2. Quitter");
    }

    public void afficherChoixStarter() {
        System.out.println("Choisissez votre Pokémon de départ :");
        System.out.println("1. Salamèche (Feu)");
        System.out.println("2. Carapuce (Eau)");
        System.out.println("3. Bulbizarre (Plante)");
    }

    public int getChoix() {
        return scanner.nextInt();
    }
}