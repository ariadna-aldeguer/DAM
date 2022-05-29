import java.io.IOException;

/*
 * Funcions de Escacs.
 * mostraTaulell
 * creaTaulellBuit
 * posicionaFigura
 * esFiguraValida 
 * mouFigura
 * eliminaFigura
 */

public class Escacs {
    public static void main(String [] args){
    
    }
    /**
     * Printa per pantalla el taulell donat
     * @param: taulell
     */
    public static void mostraTaulell(char[][] taulell){
        for(int i = taulell.length-1; i >= 0; i--){
            for(int j = 0; j < taulell.length; j++){
                System.out.print(taulell[i][j]);    
            }
            System.out.println();
        }  
    }
    /**
     * Crea un taulell de chars 8x8
     * @param: cap
     */
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
    /**
     * Posiciona una figura, previement validada, a un taulell
     * @param: taulell, fila, columna, figura
     */
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
    /**
     * Comprova si es una figura valida
     * @param: figura
     */
    public static boolean esFiguraValida(char figura){
        char[] figures ={'P','T','C','A','D','R','p','t','c','a','d','r'};

        for(char pieza: figures){
            if(pieza == figura){
                return true;
            }
        }
        return false;   
    }
    /**
     * Comprova si la figura es pot moure (que el lloc no estigui ocupat)
     * @param: taulell, filaOrigen, columnaOrigen, filaDesti, columnaDesti 
     */
    public static boolean mouFigura(char[][] taulell, int filaOrigen, int columnaOrigen, int filaDesti, int columnaDesti){
    
        char figura;
        
        if(filaDesti < 8 && filaDesti >= 0 && filaOrigen < 8 && filaOrigen >= 0){  //Comprova que la fila estigui dintre dels límits
            
            if(columnaDesti < 8 && columnaDesti >= 0 && columnaOrigen < 8 && columnaOrigen >= 0){ //Comprova que la columna estigui dintre dels limits
                if(taulell[filaOrigen][columnaOrigen] != '·'){ //Comprova que hagi una figura
                    if(taulell[filaDesti][columnaDesti] == '·'){
                        figura = taulell[filaOrigen][columnaOrigen];
                        taulell[filaOrigen][columnaOrigen] = '·';
                        taulell[filaDesti][columnaDesti] = figura;
                        return true;
                    }
                }   
            }
        }
        return false;     
    }
     /**
     * Comprova que la figura es pot eliminar (sempre que el lloc no estigui buit)
     * @param: taulell, fila, columna
     */
    public static boolean eliminaFigura(char[][] taulell, int fila, int columna){
    
        

        if(fila < 8 && fila >= 0){  //Comprova que la fila estigui dintre dels límits             
            if(columna < 8 && columna >= 0){ //Comprova que la columna estigui dintre dels limits
                
                if(taulell[fila][columna] != '·'){ //Comprova que no estigui ocupada
                    taulell[fila][columna] = '·';
                    return true;
                }
                
            } 
        }
        return false; 
          
    }
    
}
