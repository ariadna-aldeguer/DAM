public class Prueva{
    public static void main(String [] args){
    
    System.out.println("quants?");
    int quants = Integer.parseInt(Entrada.readLine());
    
        for(int vegades = quants; vegades > 0; vegades--){
        
        int num = 9;
        int aux = 9;
        int sop = 9;
        
        
            for(int fila = 0; fila <= 9; fila++){
                //Dibuixa la primera part del triangle
                for(int columna = 0; columna <= 9; columna++){
                    if(fila >= columna){
                    fila = fila + 1;
                        System.out.print(".");
                    } else {
                        System.out.print(columna);
                    }
               }
               //Segona part del triangle
               for(int col = 8; col >= 0; col--){
                    if(fila >= col){
                       System.out.print(col);
                    } else {
                       System.out.print(".");
                    }
               }
               
               System.out.println(); 
            } 
            for(int fila = 1; fila <= 9; fila++){
                //Dibuixa la primera part del triangle
                for(int columna = 0; columna < 9; columna++){
                    if(columna < fila){
                        System.out.print(".");
                    } else {
                        System.out.print(columna);
                    }
               }
               //Segona part del triangle
               for(int col = 9; col >= 0; col--){
                    if(col >= fila){
                       System.out.print(col);
                    } else {
                       System.out.print(".");
                    }
               }
               System.out.println(); 
            }
        }
    }
}