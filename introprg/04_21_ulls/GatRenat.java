/* 
 * GatRenat: Ara té dos ull. Composició
 * Un objecte es composa d'altres clases. 
 */

public class GatRenat{
    
    private UllDeGat ullDret;
    private UllDeGat ullEsquerre;
    private String posicio;
    
    public GatRenat(){
        posicio = "estirat";
        ullDret = new UllDeGat();
        ullEsquerre = new UllDeGat();
    }
    
    public GatRenat(String posicio){
        if(posicio.equals("assegut")){
            this.posicio = posicio;
            ullDret = new UllDeGat(true);
            ullEsquerre = new UllDeGat();
        } else if(posicio.equals("estirat")){
            this.posicio = posicio;
            ullDret = new UllDeGat();
            ullEsquerre = new UllDeGat();
        } else if(posicio.equals("dret")){
            this.posicio = posicio; 
            ullDret = new UllDeGat(true);
            ullEsquerre = new UllDeGat(true);
        } else {
            this.posicio = "estirat";
            ullDret = new UllDeGat();
            ullEsquerre = new UllDeGat();
        }
    }
    
    public String getPosicio(){
        return posicio;
    }
    public UllDeGat getUllDret(){
        // UllDeGat copia = new UllDeGat(ullDret.estaObert());
        return new UllDeGat(ullDret.estaObert());
        
    }
       
    public UllDeGat getUllEsquerre(){
         return new UllDeGat(ullEsquerre.estaObert()); 
    }
    
    public String aixecat(){
        String posicioFinal = "dret";
        if(posicioFinal.equals(posicio)){
            return "no faig res";
        }
        posicio = "dret";
        ullDret.obret();
        ullEsquerre.obret();
        return "m'aixeco";
    }
    
    public String seu(){
        String posicioFinal = "assegut";
        if(posicioFinal.equals(posicio)){
            return "no faig res";
        }
        posicio = "assegut";
        ullDret.obret();
        ullEsquerre.tancat();
        return "m'assec";
    }
    
    public String estirat(){
        String posicioFinal = "estirat";
        if(posicioFinal.equals(posicio)){
            return "no faig res";
        }
        posicio = "estirat";
        ullDret.tancat();
        ullEsquerre.tancat();
        return "m'estiro";
    }
    
    public static void main(String[] args) {
        GatRenat renat = new GatRenat();
        UllDeGat ullDret = renat.getUllDret();
        UllDeGat ullEsquerre = renat.getUllEsquerre();
        System.out.printf("Quan està %s: %b + %b%n",
                renat.getPosicio(),
                renat.getUllDret().estaObert(),
                renat.getUllEsquerre().estaObert());
        renat.seu();
        System.out.printf("Quan està %s: %b + %b%n",
                renat.getPosicio(),
                renat.getUllDret().estaObert(),
                renat.getUllEsquerre().estaObert());
        renat.aixecat();
        System.out.printf("Quan està %s: %b + %b%n",
                renat.getPosicio(),
                renat.getUllDret().estaObert(),
                renat.getUllEsquerre().estaObert());
}
    
}
