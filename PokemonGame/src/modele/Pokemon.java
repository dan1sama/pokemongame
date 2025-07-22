package modele;

public class Pokemon {
    private String nom;
    private int niveau;
    private int pv;
    private int pvMax;
    private Type type;
    private Attaque[] attaques;

    public Pokemon(String nom, Type type, int niveau) {
        this.nom = nom;
        this.type = type;
        this.niveau = niveau;
        this.pvMax = 20 + niveau * 5;
        this.pv = pvMax;
        this.attaques = new Attaque[]{
            new Attaque("Charge", 10, Type.NORMAL),
            new Attaque("Vive-Attaque", 15, Type.NORMAL)
        };
    }

    public void attaquer(Attaque attaque, Pokemon cible) {
        int degats = calculerDegats(attaque, cible);
        cible.subirDegats(degats);
    }

    private int calculerDegats(Attaque attaque, Pokemon cible) {
        double multiplicateur = Type.getMultiplicateur(attaque.getType(), cible.getType());
        return (int) (attaque.getDegats() * multiplicateur * (1 + niveau/100.0));
    }

    public void subirDegats(int degats) {
        this.pv -= degats;
        if (this.pv < 0) this.pv = 0;
    }

 
    public void monterNiveau() {
        niveau++;
        pvMax += 5;
        pv = pvMax;
        System.out.println(this.nom + " est maintenant au niveau " + this.niveau + " !");
    }


    public boolean estKO() { return pv <= 0; }
    public String getNom() { return nom; }
    public int getNiveau() { return niveau; }
    public int getPv() { return pv; }
    public int getPvMax() { return pvMax; }
    public Type getType() { return type; }
    public Attaque[] getAttaques() { return attaques; }
}