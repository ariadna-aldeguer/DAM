//*Programa que demana un text i mostra només les lletres entre comes

public class NomesLletres{
    public static void main(String [] args){
    
        System.out.println("Text?");
        String text = Entrada.readLine();
        
        if(text.isBlank()){return;}
        
        filtraLletres(text);
    
    }
        
    public static void filtraLletres(String text){
    
        String coma = "";
        
        for(int num = 0; num < text.length(); num++){
            if(Character.isLetter(text.charAt(num))){
                System.out.print(coma + text.charAt(num));
                coma = ", ";
            }    
        }
    }
}
