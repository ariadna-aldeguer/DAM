/*
 * GatRenat ara només te els constructors propis
 * el nom sempre sera Renat
 */
 
 public class GatRenat extends Gat{
    
    public GatRenat(){
        super("Renat");
        setVides(7);
        setPosicio("estirat");
    }
    
    public GatRenat(int vides){
        super("Renat");
        setVides(vides);
        setPosicio("estirat");
    }
    
    public GatRenat(String posicio){
        super("Renat");
        setVides(7);
        setPosicio(posicio);
    }
    public GatRenat(int vides, String posicio){
        super("Renat");
        setVides(vides);
        setPosicio(posicio);
    }
    
 }
