/* 
 * GatRenat: Ara pot tenir un picarol o no. 
 * Agregació de objectes.  
 */

public class GatRenat{
    private Picarol picarol;
    private String posicio;
    
    public GatRenat(){
        picarol = null;
        posicio = "estirat";
    }
    
    public GatRenat(String posicio){
        if(posicio.equals("assegut")){
            this.posicio = posicio;
        } else if(posicio.equals("estirat")){
            this.posicio = posicio;
        } else if(posicio.equals("dret")){
            this.posicio = posicio; 
        } else {
            this.posicio = "estirat";
        }
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
    
    public String aixecat(){
        String posicioFinal = "dret";
        if(posicioFinal.equals(posicio)){
            return "no faig res";
        } else {
            posicio = "dret";
            if (picarol != null){ picarol.sona(); }
            return "m'aixeco";
        }
    }
    
    public String seu(){
        String posicioFinal = "assegut";
        if(posicioFinal.equals(posicio)){
            return "no faig res";
        } else {
            posicio = "assegut";
            if (picarol != null){ picarol.sona(); }
            return "m'assec";
        }
    }
    
    public String estirat(){
        String posicioFinal = "estirat";
        if(posicioFinal.equals(posicio)){
            return "no faig res";
        } else {
            posicio = "estirat";
            if (picarol != null){ picarol.sona(); }
            return "m'estiro";
        }
    }
    
    public Picarol posaPicarol(Picarol picarol){
        if(this.picarol != null){
            Picarol copia = this.picarol;
            this.picarol = picarol;
            return copia;
        } else {
            this.picarol = picarol;
            return null;
        }
    }
    
    public Picarol treuPicarol(){
       
       
        if (picarol != null) { 
            Picarol copia = this.picarol;
            picarol = new Picarol();
            picarol = null;
            return copia;
        } else {
            return null;
        }
        
    }
    
    public boolean tePicarol(){
        if(picarol != null){
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        Picarol picarol = new Picarol();
        picarol.sona();   // el picarol funciona fins i tot sense gat!
        GatRenat renat = new GatRenat();
        renat.aixecat();
        renat.posaPicarol(picarol);
        renat.seu();      // ha de sonar el picarol
        renat.seu();      // no sona el picarol doncs no es mou!
        renat.treuPicarol();
        renat.estirat();  // no sona el picarol doncs ja no el té
        System.out.println("Nombre de cops que sona el picarol: " + picarol.quantsCops());
    }

}
