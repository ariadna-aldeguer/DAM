// Funcio mouFigura(). Moure una figura a una altre, comprobant que hi hagi figura i vagi a un lloc on estigui buit

public class Escacs {
    public static void main(String [] args){
    
        boolean valid = true;
        char pieza = 'p';
        char[][] taulell = new char[8][8];
         
        //Omple el taulell: 
        for(int i = 0; i < taulell.length; i++){
            for(int j = 0; j < taulell.length; j++){
                taulell[i][j] = '·';    
            }
        }  
    
        while(valid){
        
            valid = posicionaFigura(taulell, 1, 0, 'p');
            valid = posicionaFigura(taulell, 5, 6, 'P');
            valid = posicionaFigura(taulell, 5, 7, 'R');
            valid = posicionaFigura(taulell, 6, 5, 'A');
            valid = posicionaFigura(taulell, 7, 7, 'r');
        }   
  
    }
    public static int quantesOcurrencies(char[][] taulell, char pieza){
         
         int contador = 0;
         
         for(int i = 0; i < taulell.length; i++){
            for(int j = 0; j < taulell.length; j++){
                if(taulell[i][j] == pieza){
                    contador += 1;
                }
            }              
        }
        return contador;
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
 }
 

