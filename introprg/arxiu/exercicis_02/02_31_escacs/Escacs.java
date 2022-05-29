// Taulell d'escacs: matrius
// Omplir el taulell amb peces
// Imprimir l'array

public class Escacs {
    public static void main(String [] args){
        
        // Variable taulell
        char[][] taulell = new char[8][8];
        
        //Omplir el taullel de buit
        for(int i = 0; i < taulell.length; i++){
            for(int j = 0; j < taulell.length; j++){
                taulell[i][j] = '·';    
            }
        }  
        
        //Colocar les peces
        taulell[1][0] = 'p';
        taulell[5][6] = 'P';
        taulell[5][7] = 'R';
        taulell[6][5] = 'A';
        taulell[7][7] = 'r';
        
        //Resultat
        for(int i = 0; i < taulell.length; i++){
            for(int j = 0; j < taulell.length; j++){
                System.out.print(taulell[i][j]);    
            }
            System.out.println();
        }  
    }
}
