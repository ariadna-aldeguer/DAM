public class Trilal{
    public static void main(String [] args){
    
    int fila3 = 10;
            
            for(int fila = 0; fila <= 9; fila++){
                
                for(int punts = 0; punts < 19 - fila; punts++){               
                    System.out.print(".");
                }
                for(int numc = 9 - fila; numc < 10; numc++){ //* segundo triangulo numeros  creciendo
                    System.out.print(numc);
                }
                for(int numd = 8; 9 - fila <= numd; numd--){// tercer trinagulo de numeros decreciendo
                    System.out.print(numd);
                }
                for(int p = 19; p - fila > 0; p--){ ///* cuarto triangulo
                    System.out.print(".");
                }
                System.out.println();
             }
             
            
             for(int fila2 = 0; fila2 <= 9; fila2++){
                for(int punts2 = 0; punts2 < 9 - fila2; punts2++){ //primer triangle de punts
                     System.out.print(".");
                }
                for(int numc2 = 9 - fila2; numc2 <= 9; numc2++){ // segundo triangulo numeros  creciendo
                    System.out.print(numc2);
                }
                for(int numd2 = 8; 9 - fila2 <= numd2; numd2--){// tercer trinagulo de numeros decreciendo
                    System.out.print(numd2);
                } 
                for(int p2 = 9; p2 - fila2 > 0; p2--){ // cuarto triangulo
                    System.out.print(".");
                }
                for(int punts2 = 10; punts2 < 20 - fila2; punts2++){ //cinque triangle de punts
                     System.out.print(".");
                }
                for(int numc2 = 9 - fila2; numc2 <= 9; numc2++){ // sisé triangulo numeros  creciendo
                    System.out.print(numc2);
                }
                for(int numd2 = 8; 9 - fila2 <= numd2; numd2--){// seté triangulo de numeros decreciendo
                    System.out.print(numd2);
                } 
                for(int p2 = 9; p2 - fila2 > 0; p2--){ //ultimo triangulo
                    System.out.print(".");
                }
                
                
                System.out.println();
                
                
                
             }
            
            
            
            
            
    }
}
