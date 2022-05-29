
public class proves{
    public static void main(String [] args){
    
    System.out.println("quants?");
    int quants = Integer.parseInt(Entrada.readLine());
    
        for(int vegades = quants; vegades > 0; vegades--){
        
            for(int fila = 0; fila <= 9; fila++){
                for(int punts = 0; punts < 9 - fila; punts++){ //*primer triangle de punts
                System.out.print(".");
                }
                for(int numc = 9 - fila; numc <= 9; numc++){ //* segundo triangulo numeros  creciendo
                System.out.print(numc);
                }
                for(int numd = 8; 9 - fila <= numd; numd--){// tercer trinagulo de numeros decreciendo
                System.out.print(numd);
                } 
                for(int p = 9; p - fila > 0; p--){ ///* cuarto triangulo
                System.out.print(".");
                }
            System.out.println();
            }
        }
    }
}
