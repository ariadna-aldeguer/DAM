//Taulell d'escacs: busca la DamaNegra. 

public class Escacs {
    public static void main(String [] args){
        
        char[][] taulell = new char[8][8];
            
       //Omplir el taullel de buit
        for(int i = 0; i < taulell.length; i++){
            for(int j = 0; j < taulell.length; j++){
                taulell[i][j] = '·';    
            }
        }   
        boolean teDamaNegra = teDamaNegra(taulell);
    }
    public static boolean teDamaNegra(char[][] taulell){
    
        for(int i = 0; i < taulell.length; i++){
            for(int j = 0; j < taulell.length; j++){
                if(taulell[i][j] == 'D'){
                    return true;
                }
            }
        }
        return false;  
    }
}
