//* Programa que comprova si un text es capicua.

public class Capicua{
    public static void main(String [] args){
        
        String reves = "";   
           
        System.out.println("Text?");
        String text = Entrada.readLine();
        text = text.toLowerCase();
        int largo = text.length();
        
        for(int i = text.length()-1; i >= 0; i--){
            reves += text.charAt(i);
        }
        
        if(text.isBlank()){
            System.out.println("No és capicua");
        } else if(text.equals(reves)){
            System.out.println("És capicua");
        } else {
            System.out.println("No és capicua");
        }
   }
}           
