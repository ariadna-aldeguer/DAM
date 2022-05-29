//* Programa que comprova si un text es capicua.

public class Capicua{
    public static void main(String [] args){
        
        String reves = "";   
           
        System.out.println("Text?");
        String text = Entrada.readLine();
        String aux = "";
        text = text.toLowerCase();
        int largo = text.length();

        
        for(int i = 0; i < text.length(); i++){
            
            if(Character.isLetterOrDigit(text.charAt(i))){ // Si es lletra o digit ho afegeixo a la variable aux
                aux += text.charAt(i);
            }
        }
        
        for(int i = text.length()-1; i >= 0; i--){
            
            if(Character.isLetterOrDigit(text.charAt(i))){ // Si es lletra o digit ho afegeixo del reves a la variable reves
                reves += text.charAt(i);
            }
        }
        if(aux.equals(reves) && !aux.isBlank()){
            System.out.println("És capicua");
        } else {
            System.out.println("No és capicua");
        }
   }
}           
