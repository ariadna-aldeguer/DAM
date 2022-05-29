/*
 * Garfield només pot ser inicialitzar 
 * amb 9 vides i amb el nou Garfield
 */


public class Garfield extends Gat{
    
    
    /* CONSTRUCTORS */
    public Garfield(){
        super("Garfield", 9, "estirat");
    }
   
    public void setVides(int vides) {   
        if (vides >= 0 && vides <= 9) {
            super.setVides(vides);
        }  
    }
    
    /* METODES */
    public String aixecat(){
        if(getPosicio().equals("assegut")){
            setPosicio("dret");
            return "m'aixeco";
        } else if (getPosicio().equals("dret")) {
            return "no faig res";
        } else {      
            return "Bai Maitea, bai";
        }
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
        if(getPosicio().equals("assegut")){
            setPosicio("estirat");
            return "m'estiro";
        } else if (getPosicio().equals("estirat")) {
            return "no faig res";
        } else {
            return "Bai Maitea, bai";
        }
    }
}


