/* 
 * Classe: Hora: ampliació. 
 * Duplica hora (sense paràmetre i amb paràmetre)
 * Compara dues hores. 
 */
 
 public class Hora {
    private int hores = 0;
    private int minuts = 0;
    private int segons = 0;;
    
    
    /* CONSTRUCTORS */
    
    public Hora(){
        hores = 0;
        minuts = 0;
        segons = 0;
    }
    public Hora(int hores, int minuts, int segons) throws IllegalArgumentException {
        
        setHores(hores);
        setMinuts(minuts);
        setSegons(segons);

    }
    
    /* GETTERS */
    
    public int getHores() { return hores; }
    public int getMinuts() { return minuts; }
    public int getSegons() { return segons; }
    
    /* SETTERS */
    
    public void setHores(int hores) throws IllegalArgumentException {
        if (hores>=0 && hores<24) {
            this.hores=hores;
        } else {
            throw new IllegalArgumentException("hores fora de rang: " + hores);
        }
    }
    public void setMinuts(int minuts) throws IllegalArgumentException {
        if (minuts>=0 && minuts<60) {
            this.minuts=minuts;
        } else {
            throw new IllegalArgumentException("minuts fora de rang: " + minuts);
        }
    }
    public void setSegons(int segons) throws IllegalArgumentException {
        if (segons>=0 && segons<60) {
            this.segons=segons;
        } else {
            throw new IllegalArgumentException("segons fora de rang: " + segons);
        }
    }
    
    
    /* MÉTODES */
    
    public void incrementa(){
        int totalSegons = toSecondsIncrement(this.segons + 1);  
        toHours(totalSegons); 
    }
    public void incrementa(int increment){
        toHours(toSecondsIncrement(this.segons + increment));          
    }
    public void decrementa(){
        int totalSegons = toSecondsDecrement(this.segons - 1);   
        toHours(totalSegons);  
    }
    public void decrementa(int decrement){
        int totalSegons = toSecondsDecrement(this.segons - decrement);   
        toHours(totalSegons);
    }
    
    public String toString() { 
        return String.format("%d:%02d:%02d", hores, minuts, segons); 
    }
    
    public int toSecondsIncrement(int increment){
        
        int segonsTotals = this.hores*60*60;
        segonsTotals = segonsTotals + this.minuts*60;
        segonsTotals = segonsTotals + increment;
        return segonsTotals;
        
          
    }
    public int toSecondsDecrement(int decrement){
        
        int segonsTotals = this.hores*60*60;
        segonsTotals = segonsTotals + this.minuts*60;
        segonsTotals = segonsTotals + decrement;    
        while(segonsTotals < 0){
            segonsTotals = 86400+segonsTotals;
        }
            
        return segonsTotals;
          
    }
    public void toHours(int segonsTotals){
        while(segonsTotals >= 86400){
            segonsTotals = segonsTotals - 86400;
        } 
        int segons = segonsTotals % 60;
        int hores = segonsTotals / 60;
        int minuts = hores % 60;
        hores = hores / 60;
   
        
        setHores(hores);
        setMinuts(minuts);
        setSegons(segons);
        
        
    }
    
    public int compareTo(Hora hora2){
        if (this.hores == hora2.hores){
            if (this.minuts == hora2.minuts){
                if (this.segons == hora2.segons){
                    return 0;
                } else {
                    return this.segons-hora2.segons;
                    
                }
            } else {
                return this.minuts-hora2.minuts;            
            }
        } else {
            return this.hores-hora2.hores;
        }
    
    }
    public static int compareTo(Hora hora1, Hora hora2){
        if (hora1.hores == hora2.hores){
            if (hora1.minuts == hora2.minuts){
                if (hora1.segons == hora2.segons){
                    return 0;
                } else {
                    return hora1.segons-hora2.segons;
                    
                }
            } else {
                return hora1.minuts-hora2.minuts;            
            }
        } else {
            return hora1.hores-hora2.hores;
        }
    }
    
    
    public static boolean esValida(int hores, int minuts, int segons){
        
        if(hores > 23 || hores < 0){
            return false;
        }
        if(minuts > 59 || minuts < 0){
            return false;
        }
        if(segons > 59 || segons < 0){
            return false;
        }
        return true;
    }
    
    
    
    private static String composaOperadorComparacio(Hora hora1, Hora hora2) {
        int comparacio = hora1.compareTo(hora2);
        if (comparacio < 0) {
            return "<";
        } else if (comparacio > 0) {
            return ">";
        } else {
            return "==";
        }
    }
 }
