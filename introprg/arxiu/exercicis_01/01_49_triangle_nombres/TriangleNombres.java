//* Programa que fa un triangle amb numeros

public class TriangleNombres{
    public static void main(String [] args){
    System.out.println("Nombre?");
    int num = Integer.parseInt(Entrada.readLine());
    
        
            for(int fila = 1; num >= fila; fila++){
                for(int columna = fila; columna >= 1; columna--){
                System.out.print(" " + columna);
                }
            System.out.println();
            }
        
    }
}
        
