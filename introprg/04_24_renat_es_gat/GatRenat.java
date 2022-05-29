/*
 * Herencia del Gat: mètodes que farà gat Renat.
 * Canviar de dret, assegut i estirat.
 */

public class GatRenat extends Gat {
    
    public boolean estaViu(){
        if(getVides() > 0) return true;
        return false;    
    }
    public boolean estaAssegut(){
        if(getPosicio().equals("assegut")) return true;
        return false;    
    }
    public boolean estaDret(){
        if(getPosicio().equals("dret")) return true;
        return false;    
    }
    public boolean estaEstirat(){
        if(getPosicio().equals("estirat")) return true;
        return false;    
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
