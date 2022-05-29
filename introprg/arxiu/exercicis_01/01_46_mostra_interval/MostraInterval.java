// Programa que demana dos valors enters i mostra tots els enters que hi ha entre el primer i el segon, en l’ordre marcat per l’entrada.

public class MostraInterval{
    public static void main(String [] args){
        
        System.out.println("inici?");
        int inici = Integer.parseInt(Entrada.readLine());
        System.out.println("final?");
        int fin = Integer.parseInt(Entrada.readLine());
        
        if(inici >= fin){
            
            for(int num = inici; num >= fin; num = num - 1){
            System.out.println(num);
            }
            
       } else {
       
            for(int num = inici; num <= fin; num = num + 1){
            System.out.println(num);
            }
       }     
   }
}
        
