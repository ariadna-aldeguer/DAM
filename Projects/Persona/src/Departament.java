public class Departament {
    public String nom;
    private int id;
    public Departament(int id, String nom){
        this.id = id;
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}
