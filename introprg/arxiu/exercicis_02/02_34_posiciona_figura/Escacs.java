//  Funcio posicionaFigura(). Omplir el taullel de peces amb la funcio posicionaFigura i contar quants peons hi ha.

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
        
        
        //Sortida: taulell
        for(int i = 0; i < taulell.length; i++){
            for(int j = 0; j < taulell.length; j++){
                System.out.print(taulell[i][j]);    
            }
            System.out.println();
        }
        //contar les peces
        char mayuscula = Character.toUpperCase(pieza);
        char minuscula = Character.toLowerCase(pieza);
        int negres = quantesOcurrencies(taulell, mayuscula);
        int blancs = quantesOcurrencies(taulell, minuscula);
         
        System.out.printf(
        "%nPeons negres: %d%nPeons blancs: %d%n", negres, blancs);
           
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
    
 }
 

