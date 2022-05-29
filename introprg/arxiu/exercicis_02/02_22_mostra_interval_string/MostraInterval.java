//* Programa que demana un interval y un text y retorna les lletres.

public class MostraInterval{
   public static void main(String [] args){
   
        System.out.println("text?");
        String text = Entrada.readLine();
        System.out.println("inici?");
        int inici = Integer.parseInt(Entrada.readLine());
        System.out.println("final?");
        int fi = Integer.parseInt(Entrada.readLine());
        
        String resultant = UtilString.intervalString(text, inici, fi);
        System.out.println(resultant);
        
   }
}

