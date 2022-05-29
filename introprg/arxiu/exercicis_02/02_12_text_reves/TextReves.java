//* Programa que demana un text i el retorna al revés.

public class TextReves{
    public static void main(String [] args){
        
        System.out.println("Text?");
        String text = Entrada.readLine();
        
        if(text.isBlank()){return;}
    
        mostraReves(text);
    }
    
    public static void mostraReves(String text){
    
        for(int i = text.length()-1; i >= 0; i--){
            
            if(i == 0){
                System.out.print(text.charAt(i));
            } else {
                System.out.print(text.charAt(i) + ", ");
            }
        }
    }
}
