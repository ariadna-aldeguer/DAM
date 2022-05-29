/*
 * Programa que treballa amb interficies: GatRenat subclasse de Gat 
 * amb les interficies: ensinistrable i animal de companyia. 
 */
 
 public class GatRenat extends Gat implements Ensinistrable, AnimalDeCompanyia{
    
    private String posicio;
    
    public GatRenat(){
        super("Renat");
        posicio = "estirat";
    }
    
    public GatRenat(String posicio){
        super("Renat");
        setPosicio(posicio);
    }
    
    public String getPosicio(){
        return posicio;
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
    
    
    /* MÈTODES INTERFACE */
    
    public String deixatEstimar() {
         return "em deixo estimar";
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
 
 
