//*Programa que demana un text i mostra només les lletres entre comes

public class NomesLletres{
    public static void main(String [] args){
        
        System.out.println("Text?");
        String text = Entrada.readLine();
        int fin = text.length();
        String coma = "";
        
        for(int num = 0; num < fin; num++){
            if(Character.isLetter(text.charAt(num))){
                System.out.print(coma + text.charAt(num));
                coma = ", ";

            }    
        }
        System.out.println();
    }   
}
