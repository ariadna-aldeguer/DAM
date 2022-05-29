import java.io.IOException;

/*
 * Funció que mostra un taullel [8][8] 
 */

public class Escacs {
    public static void main(String [] args){
    
    }
    public static void mostraTaulell(char[][] taulell){
        for(int i = taulell.length-1; i >= 0; i--){
            for(int j = 0; j < taulell.length; j++){
                System.out.print(taulell[i][j]);    
            }
            System.out.println();
        }  
    }
    
    public static char[][] creaTaulellBuit(){
        
        // Variable taulell
        char[][] taulell = new char[8][8];
        
        //Omplir el taullel de buit
        for(int i = taulell.length-1; i >= 0; i--){
            for(int j = 0; j < taulell.length; j++){
                taulell[i][j] = '·';    
            }
        }  
        return taulell;
    } 
    public static boolean posicionaFigura(char[][] taulell, int fila, int columna, char figura){
    
        

        if(fila < 8 && fila >= 0){  //Comprova que la fila estigui dintre dels límits             
            if(columna < 8 && columna >= 0){ //Comprova que la columna estigui dintre dels limits
                
                if(taulell[fila][columna] == '·'){ //Comprova que no estigui ocupada
                    taulell[fila][columna] = figura;
                    return true;
                }
                
            } 
        }
        return false; 
          
    }
    public static boolean esFiguraValida(char figura){
        char[] figures ={'P','T','C','A','D','R','p','t','c','a','d','r'};

        for(char pieza: figures){
            if(pieza == figura){
                return true;
            }
        }
        return false;   
    }
}
