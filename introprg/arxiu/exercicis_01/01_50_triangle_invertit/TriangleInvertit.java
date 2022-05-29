
//* Demana un número y retorna un triangle invertit. 
public class TriangleInvertit{
    public static void main(String [] args){

        System.out.println("Nombre?");
        int num = Integer.parseInt(Entrada.readLine());
        int aux = num;
        
        
        for(int fila = 1; fila <= num; fila++){
            for(int columna = 1; columna <= aux; columna++){
                if(columna < aux){
                System.out.print(columna + ", ");
                } else {
                System.out.print(columna);
                }
            }
        aux = aux - 1;
        System.out.println();
        }        
   }
}

