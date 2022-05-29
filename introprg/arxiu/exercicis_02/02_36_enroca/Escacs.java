// Funcio enroc(). Moure el rey i la torre. Comprovar que es pogui fer enroc.

public class Escacs {
    public static void main(String [] args){
    
       char[][] taulell = new char[8][8];
       boolean valid = true;
       
       for(int i = 0; i < taulell.length; i++){
            for(int j = 0; j < taulell.length; j++){
                taulell[i][j] = '·';    
            }
        }
        while(valid){
            
            valid = posicionaFigura(taulell, 0, 0, 'T');
            valid = posicionaFigura(taulell, 0, 4, 'R');
            valid = posicionaFigura(taulell, 0, 7, 'T');
            break;
        }  
        if(valid){
            boolean enrocat = enroc(taulell, 0, 7);
            if(enrocat){
                System.out.println("S'ha pogut enrocar");
            } else {
                System.out.println("No s'ha pogut enrocar");
            }
        }
        else {
        System.out.println("No he fet res");
        }
    }
    
    public static boolean enroc(char[][] taulell, int fila, int columna){
    

        if (fila == 0 && (columna == 0 || columna == 7)){  // Blanques
            

            if (taulell[0][0] != 't'){ //Si no esta LA TORRE en la seva posició
                return false;
            }    
            if (taulell[0][4] != 'r'){ //Si no esta EL REY en la seva posició
                return false;
            }
            if (taulell[0][7] != 't'){ //Si no esta LA TORRE en la seva posició
                return false;
            }
            //El resta de casselles han d'estar buides
            if (taulell[0][1] != '·' 
            || taulell[0][2] != '·' 
            || taulell[0][3] != '·'
            || taulell[0][5] != '·' 
            || taulell[0][6] != '·'){
                return false;  
            }   

            // Si arriba aquí es que el taulell esta bé
            
            //Enroc llarg blanques 0-0
            if (columna == 0){  
                taulell[0][0] = '·';
                taulell[0][2] = 'r';
                taulell[0][3] = 't';
                taulell[0][4] = '·';
                return true; //S'ha pogut fer
             }
             if (columna == 7){  //Enroc curt blanques 0-7
                taulell[0][7] = '·';
                taulell[0][5] = 't';
                taulell[0][6] = 'r';
                taulell[0][4] = '·';
                return true;
             }
       } else if (fila == 7 && (columna == 0 || columna == 7)) {  // Blanques
            
            if(taulell[7][0] != 'T'){ //Si no esta LA TORRE en la seva posició
                return false;
            }    
            if(taulell[7][4] != 'R'){ //Si no esta EL REY en la seva posició
                return false;
            }
            if(taulell[7][7] != 'T'){ //Si no esta LA TORRE en la seva posició
                return false;
            }
            //El resta de casselles han d'estar buides
            if(taulell[7][1] != '·' 
            || taulell[7][2] != '·' 
            || taulell[7][3] != '·'
            || taulell[7][5] != '·' 
            || taulell[7][6] != '·'){
                return false;  
            }      
             
            
            // Si arriba aquí es que el taulell esta bé
            
            //Enroc llarg Blanques 7-0
            if(columna == 0){  
                taulell[7][0] = '·';
                taulell[7][2] = 'R';
                taulell[7][3] = 'T';
                taulell[7][4] = '·';
                return true; //S'ha pogut fer
             } else if (columna == 7){  //Enroc curt Blanques 7-7
                taulell[7][7] = '·';
                taulell[7][5] = 'T';
                taulell[7][6] = 'R';
                taulell[7][4] = '·';
                return true;
             }
        } 
       return false;
        
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
