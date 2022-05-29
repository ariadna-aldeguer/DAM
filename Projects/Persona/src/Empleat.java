public class Empleat {
    private String nom;
    private String departament;

    public Empleat(String nom, String departament) {
        this.nom = nom;
        this.departament = departament;
    }
    
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getDepartament() {
        return departament;
    }
    public void setDepartament(String departament) {
        this.departament = departament;
    }

    
}
