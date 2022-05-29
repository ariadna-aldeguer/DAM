/*
 * Programa amb interficies: Gat es la superclasse
 */

public class Gat implements EsserViu{
    private String nom;
    private int vides;
    
    /* CONSTRUCTORS */
    public Gat(String nom){
        
        setNom(nom);
        vides = 7;
    }
    public Gat(String nom, int vides){
        
        setNom(nom);
        setVides(vides);
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
    
    /* GETTERS */
    
    public int getVides() { 
        return vides;
    }
    public String getNom(){
        return nom;
    }
    
    /* METODES */
    
    public boolean estaViu(){
        return (getVides() > 0);  
    }
    
    public String mor(){
        if (vides > 1){
            vides--;
            return "adéu món cruel";
        } else if (vides == 1) {
            vides--;
            return "adéu món cruel";
        } else {
            return "ja l'he palmada";
        }
    }
    public String ressuscita(){
        if(vides == 0){
            vides++;
            return "guai!";
        } else {
            return "encara visc";
        }
    }
    public String ressuscita(int vides){ 
        if(this.vides == 0 && vides > 0){
            this.vides = vides;
            return "guai!";
        } else {
            return "encara visc";
        } 
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
  
}



