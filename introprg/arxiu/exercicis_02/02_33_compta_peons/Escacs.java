// Taulell d'escacs: busca una peça, retorna quantes negres i blanques té. 

public class Escacs {
    public static void main(String [] args){
    
        char[][] taulell = new char[8][8];
        char pieza = 'p';
        
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
            
        //contar les peces
        char mayuscula = Character.toUpperCase(pieza);
        char minuscula = Character.toLowerCase(pieza);
        int negres = quantesOcurrencies(taulell, mayuscula);
        int blancs = quantesOcurrencies(taulell, minuscula);
         
        System.out.printf(
        "Peons negres: %d%nPeons blancs: %d%n", negres, blancs);
           
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
}
