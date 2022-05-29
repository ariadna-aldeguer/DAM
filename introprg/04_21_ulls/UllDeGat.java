/*
 * L'ull del gat renat. Com funcionen les parts d'un objecte. 
 */

public class UllDeGat {
    
    private boolean Ull;
    
    public UllDeGat(){
        Ull = false;
    }
    public UllDeGat(boolean estat){
        Ull = estat;
    }
    
    public void obret(){
       Ull = true;
    }
    public void tancat(){
       Ull = false;
    }
    
    public boolean estaObert(){
        return Ull; 
    }

}
