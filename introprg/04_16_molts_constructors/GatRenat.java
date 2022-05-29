/*
 * Començant a utilitzar diversos constructors
 * Constructor especific: un parametre i dos parametres. 
 * Constructor per defecte.
 */

public class GatRenat {
    private int vides = 7;
    private String posicio = "estirat";
    
    /* CONSTRUCTORS */
    public GatRenat(){
        vides = 7;
        posicio = "estirat";
    }
    public GatRenat(int vides) {
        this.setVides(vides);
        posicio = "estirat";
    }
    public GatRenat(int vides, String posicio){
        this.setVides(vides);
        this.setPosicio(posicio);
    }
    public GatRenat(String posicio){
        this.setPosicio(posicio);
        vides = 7;
    }
    
    /* GETTERS */
     public int getVides() {  //  retorna el nombre de vides
        return vides;
    }
    public String getPosicio(){
        return posicio;
    }
    
    /* SETTERS */
    public void setVides(int vides) {   // modifica el nombre de vides si ens donen un de vàlid
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
    
    /* METODES */
    public boolean estaViu(){
        if(vides > 0) return true;
        return false;    
    }
    public boolean estaAssegut(){
        if(posicio.equals("assegut")) return true;
        return false;    
    }
    public boolean estaDret(){
        if(posicio.equals("dret")) return true;
        return false;    
    }
    public boolean estaEstirat(){
        if(posicio.equals("estirat")) return true;
        return false;    
    }
    public String aixecat(){
        String posicioFinal = "dret";
        if(posicioFinal.equals(posicio)){
            return "no faig res";
        }
        posicio = "dret";
        return "m'aixeco";
    }
    public String seu(){
        String posicioFinal = "assegut";
        if(posicioFinal.equals(posicio)){
            return "no faig res";
        }
        posicio = "assegut";
        return "m'assec";
    }
    public String estirat(){
        String posicioFinal = "estirat";
        if(posicioFinal.equals(posicio)){
            return "no faig res";
        }
        posicio = "estirat";
        return "m'estiro";
    }
    public String mor(){
        if (vides > 1){
            vides--;
            return "auch";
        } else if (vides == 1) {
            vides--;
            return "ximpún";
        } else {
            return "...";
        }
    }
    public String resuscita(){
        if(vides == 0){
            vides++;
            return "guai!";
        } else {
            return "...";
        }
    }
    public String resuscita(int vides){ 
        if(this.vides == 0 && vides > 0){
            this.vides = vides;
            return "guai!";
        } else {
            return "...";
        } 
    }
    
    @Override
    public String toString() {
        return String.format("Vides: %d. Posició: %s", vides, posicio);
    }
    
    public static void main(String[] args) {
        GatRenat[] renats = {
            new GatRenat(),         // tot per defecte
            new GatRenat(8),        // 8 vides i posició per defecte
            new GatRenat("dret"),   // posició dret i vides per defecte
            new GatRenat(8, "dret") // 8 vides i posició dret

        };
        for (GatRenat renat: renats) {
            System.out.println(renat);
        }
    }
}
