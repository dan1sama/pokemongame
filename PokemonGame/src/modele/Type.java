
package modele;

public enum Type {
    FEU, EAU, PLANTE, NORMAL;

  
    public static double getMultiplicateur(Type typeAttaque, Type typeDefense) {
        if (typeAttaque == FEU && typeDefense == PLANTE) return 2.0;
        if (typeAttaque == EAU && typeDefense == FEU) return 2.0;
        if (typeAttaque == PLANTE && typeDefense == EAU) return 2.0;
        if (typeAttaque == typeDefense) return 0.5; 
        return 1.0; 
    }
}