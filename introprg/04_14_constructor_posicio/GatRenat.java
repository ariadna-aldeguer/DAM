/*
 * Protegint la posicio
 * Per accedir a la posició des de fòra de la classe
 * s'ha d'utilitzar els setters
 */

public class GatRenat {
    private int vides;
    private String posicio;
    
    public GatRenat(int novesVides) {
        setVides(novesVides);
    }
    public GatRenat(int novesVides, String novaPosicio){
        setVides(novesVides);
        setPosicio(novaPosicio);
    }
    /* GETTERS */
     public int getVides() {  //  retorna el nombre de vides
        return vides;
    }
    public String getPosicio(){
        return posicio;
    }
    
    /* SETTERS */
    public void setVides(int novesVides) {   // modifica el nombre de vides si ens donen un de vàlid
        if (novesVides >= 0) {
            vides = novesVides;
        }
    }
    public void setPosicio(String novaPosicio){
         if (novaPosicio.equals("estirat") ||
             novaPosicio.equals("dret") ||
             novaPosicio.equals("assegut")) {
                    posicio = novaPosicio;
         } else {
            posicio = "estirat";
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
        System.out.println(new GatRenat(7, "dret"));
    }
}
