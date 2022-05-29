//*Programa que demana un text i ho mostra entre parèntesis

public class Parentitza{
    public static void main(String [] args){
        
        System.out.println("Text?");
        String text = Entrada.readLine();
        int fin = text.length();
        
        for(int num = 0; num < fin; num++){
            if(Character.isLetter(text.charAt(num))){
            System.out.print("(" + text.charAt(num) + ")");
            } else{
            System.out.print(text.charAt(num));
            }
        }
    }
}
