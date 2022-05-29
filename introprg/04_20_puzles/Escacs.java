/* 
 * Refactoring programa Puzle
 * Escacs: crea objecte escacs amb un taulell 8x8
 */

public class Escacs {
    
    private char[][] taulell;
    
    public Escacs(){
         this(new char[8][8]); 
    }
    
    public Escacs(char[][] taulell){
        
        //char[][] taulellInicial = clonaTaulell(taulell);
        this.taulell = new char[8][8];

        if(! esTaulellValid(taulell)){
             
            //Omplir el taullel de buit
            for(int i = this.taulell.length-1; i >= 0; i--){
                for(int j = 0; j < this.taulell.length; j++){
                    this.taulell[i][j] = '·';    
                }
            } 
             
            
        } else {
            
            for(int i = taulell.length-1; i >= 0; i--){
                for(int j = 0; j < taulell.length; j++){
                        this.taulell[i][j] = taulell[i][j];
                }
            }
        }
        char[][] taulellInicial = clonaTaulell(this.taulell);
    }
    
    public char[][] getTaulell(){
        
        char[][] clon = clonaTaulell(this.taulell);
        return clon;    
             
    }
    
    
    public void mostraTaulell(){
    
        for(int i = taulell.length-1; i >= 0; i--){
            for(int j = 0; j < taulell.length; j++){
                System.out.print(taulell[i][j]);    
            }
            System.out.println();
        }  
    }
    
    public boolean posicionaFigura(int fila, int columna, char figura){
        
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
    
    public boolean mouFigura(int filaOrigen, int columnaOrigen, int filaDesti, int columnaDesti){
        char figura;
        
        //Comprova que la fila estigui dintre dels límits
        if(filaDesti < 8 && filaDesti >= 0 && filaOrigen < 8 && filaOrigen >= 0){  
            
            //Comprova que la columna estigui dintre dels limits
            if(columnaDesti < 8 && columnaDesti >= 0 && columnaOrigen < 8 && columnaOrigen >= 0){ 
            
                //Comprova que hagi una figura
                if(taulell[filaOrigen][columnaOrigen] != '·'){ 
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
    
    public boolean eliminaFigura(int fila, int columna){
        
        //Comprova que la fila estigui dintre dels límits  
        if(fila < 8 && fila >= 0){           
        
            //Comprova que la columna estigui dintre dels limits  
            if(columna < 8 && columna >= 0){ 
                
                //Comprova que no estigui ocupada
                if(taulell[fila][columna] != '·'){ 
                    taulell[fila][columna] = '·';
                    return true;
                }
                
            } 
        }
        return false; 
    }
    
    public static boolean esTaulellValid(char[][] valid){
        
        //Mesures diferents
        if(valid.length != 8){
            return false;
        }
        for(int i = 0; i < valid.length; i++){
            if(valid[i].length != 8){
                return false;
            }
        }
        
        //Té figures no vàlides
        for(int i = 0; i < valid.length; i++){
            for(int j = 0; j < valid.length; j++){
                if(valid[i][j] != '·'){ 
                    if(!esFiguraValida(valid[i][j])){
                        return false;
                    }
                }
            }
        }
        return true;
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
    
    public static char[][] clonaTaulell(char[][] taulell){
        
        char[][] copia = new char[taulell.length][taulell.length];
        
        for(int i = taulell.length-1; i >= 0; i--){
            for(int j = 0; j < taulell.length; j++){
                    copia[i][j] = taulell[i][j];
            }
        } 
        return copia;
        
    }
    
    
    public static void main(String [] args){
    
        Escacs escacs = new Escacs();
    
    }
    
}
