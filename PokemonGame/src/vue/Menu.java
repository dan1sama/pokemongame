package vue;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public void afficherPrincipal() {
        System.out.println("===== Pok�mon Java =====");
        System.out.println("1. Nouvelle partie");
        System.out.println("2. Quitter");
    }

    public void afficherChoixStarter() {
        System.out.println("Choisissez votre Pok�mon de d�part :");
        System.out.println("1. Salam�che (Feu)");
        System.out.println("2. Carapuce (Eau)");
        System.out.println("3. Bulbizarre (Plante)");
    }

    public int getChoix() {
        return scanner.nextInt();
    }
}