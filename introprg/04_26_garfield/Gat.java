/*
 * Gat ara es la superclasse i pot tenir nom
 * Si nom no compleix els parametres sera anonim. 
 * Nomes Gat pot posar nom.
 */
 

public class Gat {
    private String nom;
    private int vides;
    private String posicio;
    
    /* CONSTRUCTOR PER DEFECTE */
    
    
    public Gat(String nom){
        
        setNom(nom);
        vides = 7;
        posicio = "estirat";
    }
    
    /* CONSTRUCTORS ESPECIFICS */
    
    public Gat(String nom, int vides){
        
        setNom(nom);
        setVides(vides);
        posicio = "estirat";
    }
    public Gat(String nom, String posicio){
        
        setNom(nom);
        vides = 7;
        setPosicio(posicio);
    }
    
    public Gat(String nom, int vides, String posicio){
        setNom(nom);
        setVides(vides);
        setPosicio(posicio);
    }
    
    /* SETTERS */
    
    // Només es pot accedir desde el constructor de Gat
    private void setNom(String nom){
        if(esNomValid(nom)){
            this.nom = nom;
        } else {
            this.nom = "anònim";
        }
    }
    public void setVides(int vides) {   
        if (vides >= 0) {
            this.vides = vides;
        }  
    }
    public void setPosicio(String posicio){
         if (posicio.equals("estirat") ||
             posicio.equals("dret") ||
             posicio.equals("assegut")) {
                    this.posicio = posicio;
         } else {
            this.posicio = "estirat";
         }
    }
    
    
    /* GETTERS */
    
    public int getVides() { 
        return vides;
    }
    public String getPosicio(){
        return posicio;
    }
    public String getNom(){
        return nom;
    }
    
    
    
    // Comprova que el nom no estigui buit, ni blanc, ni null
    public static boolean esNomValid(String nom){
        if(nom == null){
            return false;
        } 
        if(nom.isBlank()){
            return false;
        }
        return true;
    }
    
    /* MÉTODES */
    
    public boolean estaViu(){
        return (getVides() > 0);  
    }
    public boolean estaAssegut(){
        return (getPosicio().equals("assegut")); 
    }
    public boolean estaDret(){
        return (getPosicio().equals("dret"));   
    }
    public boolean estaEstirat(){
        return (getPosicio().equals("estirat"));
    }
    public String aixecat(){
        String posicioFinal = "dret";
        if(posicioFinal.equals(getPosicio())){
            return "no faig res";
        }
        setPosicio("dret");
        return "m'aixeco";
    }
    public String seu(){
        String posicioFinal = "assegut";
        if(posicioFinal.equals(getPosicio())){
            return "no faig res";
        }
        setPosicio("assegut");
        return "m'assec";
    }
    public String estirat(){
        String posicioFinal = "estirat";
        if(posicioFinal.equals(getPosicio())){
            return "no faig res";
        }
        setPosicio("estirat");
        return "m'estiro";
    }
}
