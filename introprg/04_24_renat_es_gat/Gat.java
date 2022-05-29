/*
 * El Gat ja no es renat. Herencia de classes
 * Gat ara nomès té vides i posició.
 */

public class Gat{
    private int vides;
    private String posicio;
    
    public Gat(){
        vides = 7;
        posicio = "estirat";
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
}
