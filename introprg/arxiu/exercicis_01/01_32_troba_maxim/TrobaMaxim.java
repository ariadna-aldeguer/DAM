//* Programa que demana positius enters i retorna el valor máxim positiu.

public class TrobaMaxim{
    public static void main(String [] args){
    
       int max = 0;
       
       System.out.println("Introdueix un valor");
       int entrada = Integer.parseInt(Entrada.readLine());
        
       while (entrada >= 0){
            if (entrada > max) {
                max = entrada; 
            }
            System.out.println("Introdueix un valor");
            entrada = Integer.parseInt(Entrada.readLine()); 
        }
        
        System.out.println("El màxim és " + max);    
    }
}
        
    
