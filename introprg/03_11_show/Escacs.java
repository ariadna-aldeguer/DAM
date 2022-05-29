/*
 * Funció que mostra un taullel [8][8] 
 */

public class Escacs {
    public static void main(String [] args){
    
    }
    public static void mostraTaulell(char[][] taulell){
        for(int i = 0; i < taulell.length; i++){
            for(int j = 0; j < taulell.length; j++){
                System.out.print(taulell[i][j]);    
            }
            System.out.println();
        }  
    }
    
    
}
