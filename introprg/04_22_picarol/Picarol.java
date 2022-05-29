/*
 * El gat renat pot tenir un picarol o no. 
 * EL picarol pot estar o no(true o false)
 * I cada vegada que sona, suma un cop
 */

public class Picarol {
    
    private boolean picarol;
    private int cops;
    
    public Picarol(){
        picarol = true;
        cops = 0;
    } 
    public Picarol(boolean estat){
        picarol = estat;
        cops = 0;
    }
    public Picarol(boolean estat, int cops){
        picarol = estat;
        this.cops = cops;
    }
    
    
    public void sona(){
        DemoPicarol.sona();
        cops++;
        System.out.println("clink-clink");
    }
    
    public int quantsCops(){
        return cops;
    }
    
      
    
    
}
