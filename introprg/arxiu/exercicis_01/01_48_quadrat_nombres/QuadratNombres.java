//*Programa que demana un enter positiu més gran que 0 i «dibuixa» un quadrat amb els nombres del 1 fins el valor de l’entrada.

public class QuadratNombres {
    public static void main(String [] args){
    
        System.out.println("Valor final?");
        int fi = Integer.parseInt(Entrada.readLine());
        
        if(fi == 0 || fi >= 10){
            System.out.println("Valor inadequat");
        } else {
            for(int num = 1; num <= fi; num++){
                for(int columna = 1; columna <= fi; columna++){
                System.out.print(" " + columna);
                }
            System.out.println();   
            }
       }
   }
}
            
