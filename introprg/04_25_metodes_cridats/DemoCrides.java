/* Programa per fer proves sobre herencia
 * Desde quina clase es crida a quina altra
 * Feli, Gat, renat, menjar
 */ 


//Superclasse
class Feli {
    public Feli() {
        System.out.println("Neix Felí");
    }
    public void netejaUrpes() {
        System.out.println("Felí neteja urpes des de " + this.getClass());
    }
    public void menja(Menjar menjar) {
        System.out.println("Felí menja " + menjar + " des de " + this.getClass());
    }
}

//Subclasse de Feli, superclasse de GatRenat
class Gat extends Feli {
    public Gat() {
        System.out.println("Neix Gat");
    }
    public void miola() {
        System.out.println("Gat miola des de " + this.getClass());
    }
    public void menja(Menjar menjar) {
        System.out.println("Gat menja " + menjar + " des de " + this.getClass());
        super.menja(menjar);
    }
}

//Subclasse de Gat
class GatRenat extends Gat {
    public GatRenat() {
        System.out.println("Neix Renat");
    }
    @Override
    public void miola() {
        System.out.println("Renat miola des de " + this.getClass());
    }

    @Override
    public void menja(Menjar menjar) {
        System.out.println("Renat menja " + menjar + " des de " + this.getClass());
        netejaUrpes();
        super.menja(menjar);
    }
}

//Classe menjar
class Menjar {
    private static final String MENJAR_PER_DEFECTE = "sardines";
    private final String nom;
    public Menjar(String nom) {
        if (nom != null && !nom.isEmpty()) {
            this.nom = nom;
        } else {
            this.nom = MENJAR_PER_DEFECTE;
        }
        System.out.println("Neix Menjar(\"" + this.nom + "\")");
    }
    public String toString() { return nom; }
}


public class DemoCrides{
    public static void main(String[] args){
        Feli feli = new Feli();
        Gat gat = new Gat();
        GatRenat renat = new GatRenat();
        feli.netejaUrpes();
        gat.netejaUrpes();
        renat.netejaUrpes();
        gat.miola();
        renat.miola();
        Menjar menja = new Menjar("bacallà");
        renat.menja(menja);
        
    }
}
