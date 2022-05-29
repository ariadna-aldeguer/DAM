//*Programa que demana un text i ho mostra entre parèntesis

public class Parentitza{
    public static void main(String [] args){
    
        System.out.println("Text?");
        String text = Entrada.readLine();
        
        if(text.isBlank()){return;}
        
        parentitza(text);
    }
    public static void parentitza(String text){
    
        for(int num = 0; num < text.length(); num++){
            if(Character.isLetter(text.charAt(num))){
                System.out.print("(" + text.charAt(num) + ")");
            } else{
                System.out.print(text.charAt(num));
            }
        }
    }
}

