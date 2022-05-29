public class provant{
    public static void main(String [] args){
    
        int numeros [][] = new int [4][5];
        
        numeros [0][0] = 1;
        numeros [0][1] = 2;
        numeros [0][2] = 3;
        numeros [0][3] = 4;
        numeros [0][4] = 5;

        numeros [1][0] = 1;
        numeros [1][1] = 2;
        numeros [1][2] = 3;
        numeros [1][3] = 4;
        numeros [1][4] = 5;

        numeros [2][0] = 1;
        numeros [2][1] = 2;
        numeros [2][2] = 3;
        numeros [2][3] = 4;
        numeros [2][4] = 5;

        numeros [3][0] = 1;
        numeros [3][1] = 2;
        numeros [3][2] = 3;
        numeros [3][3] = 4;
        numeros [3][4] = 5;
        
        modificaEnters(numeros);
        
        for(int i = 0; i < numeros.length; i++){
            for(int j=0; j <= numeros.length; j++){
            
                System.out.print(numeros[i][j] + "  ");
            }
            System.out.println();
       
       }
        
    }
    
    public static void modificaEnters (int numeros[][]){
    
        for(int i = 0; i < numeros.length; i++){
            for(int j=0; j <= numeros.length; j++){
            
                if(i % 2 == 0){
                    numeros[i][j] = numeros[i][j] + 1;
                } else {
                    numeros[i][j] = numeros[i][j] - 1;
                }
            }
        }    
    }
}
