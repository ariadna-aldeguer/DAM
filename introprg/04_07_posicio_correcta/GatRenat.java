/*
 * GatRenat: provant els Setter i els Getters
 */

public class GatRenat {
    private int vides = 7;
    private String posicio = "estirat";
    public int getVides() {  //  retorna el nombre de vides
        return vides;
    }
    public void setVides(int novesVides) {   // modifica el nombre de vides si ens donen un de vàlid
        if (novesVides >= 0) {
            vides = novesVides;
        }
    }
    public String getPosicio(){
        return posicio;
    }
    public void setPosicio(String newPosicio){
        if(newPosicio.equals("assegut")){
            posicio = newPosicio;
        }
        if(newPosicio.equals("estirat")){
            posicio = newPosicio;
        }
        if(newPosicio.equals("dret")){
            posicio = newPosicio;
        }
        
    }

}
