/*
 * Diversus constructors amb diferents paràmetres 
 * Constructor per defecte
 * Constructor específic
 */

public class GatRenat {
    private int vides;
    private String posicio;
    
    public GatRenat(int novesVides) {
        vides = novesVides;
    }
    public GatRenat(int novesVides, String novaPosicio){
        vides = novesVides;
        posicio = novaPosicio;
    }
    public int getVides() { 
        return vides; 
    }
    public String getPosicio() { 
        return posicio; 
    }
    
    @Override
    public String toString() {
        return String.format("Vides: %d. Posició: %s", vides, posicio);
    }
    
   
    
    public static void main(String[] args) {
        System.out.println(new GatRenat(7, "estirat"));
    }
}
