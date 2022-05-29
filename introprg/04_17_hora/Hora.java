/* 
 * Exercici de Classe: Hora. Propietats: hores, segons, minuts.
 * Crear metodes, constructors, setters i getters
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
    public Hora(int hores, int minuts, int segons){
    
        if (hores < 0 || hores > 23 || minuts < 0 || minuts > 59 || segons < 0 || segons > 59){
            hores = 0;
            minuts = 0;
            segons = 0;
        } else {
        
            setHores(hores);
            setMinuts(minuts);
            setSegons(segons);
        
        }
    }
    
    /* GETTERS */
    
    public int getHores() { return hores; }
    public int getMinuts() { return minuts; }
    public int getSegons() { return segons; }
    
    /* SETTERS */
    
    public void setHores(int hores){
        this.hores = hores;
    }
    public void setMinuts(int minuts){
        this.minuts = minuts;

    }
    public void setSegons(int segons){
        this.segons = segons;
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

    public static void main(String[] args) {
        Hora hora1 = new Hora();
        Hora hora2 = new Hora(0, 0, 2);
        System.out.printf("Inicialment hora1: %s %s hora2: %s%n",
                hora1,
                composaOperadorComparacio(hora1, hora2),
                hora2);
        System.out.println("Incrementem 1 segon a la primera i decrementem 1 segon a la segona");
        hora1.incrementa();
        hora2.decrementa();
        System.out.printf("Finalment hora1: %s %s hora2: %s%n",
                hora1,
                composaOperadorComparacio(hora1, hora2),
                hora2);

    }
 }
