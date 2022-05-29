public class GatRenat {
    public int vides = 7;         // vides disponibles del gat Renat
    public String posicio = "estirat";
    
    public int getVides(){
        return vides;
    }
    public void setVides(int newVides){
        if (newVides >= 0) {
            vides = newVides;
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
