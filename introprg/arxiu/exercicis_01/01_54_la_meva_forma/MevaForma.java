//* Intento de barco 
public class MevaForma{
    public static void main(String [] args){
    
        for(int fila = 0; fila <= 5; fila++){
                    for(int punts = 0; punts < 5 - fila; punts++){ //*primer triangle de punts
                    System.out.print(".");
                    }
                    for(int numc = 5 - fila; numc <= 5; numc++){ //* segundo triangulo numeros  creciendo
                    System.out.print(numc);
                    }
                    for(int p = 6; p < 10; p++){ ///* cuadrado
                    System.out.print(".");
                    }
                System.out.println();
        }
        for(int fila = 0; fila <= 3; fila++){
            for(int punts = 0; punts < 5; punts++){ //*cuadrado izq 
                System.out.print(".");
            }
            for(int numc = 5; numc <= 5; numc++){ //*los 5s
                System.out.print(numc);
            }
            for(int p = 6; p < 10; p++){ ///*cuadrado der
               System.out.print(".");
            }
         System.out.println();
         }
         for(int fila = 0; fila < 3; fila++){
             for(int a = 0; a <= fila; a++){
                 System.out.print(".");
            }
            for(int b = 1 + fila; b <= 5 ; b++){
                System.out.print(b);
            }
            for(int b = 6; b < 9 - fila ; b++){
                System.out.print(b);
            }
            for(int a = 0; a <= fila; a++){
                 System.out.print(".");
            }
            
        System.out.println();
       }
    System.out.println();
    }     
}

