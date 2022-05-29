//* Programa que demana un text i retorna el text cifrat mantenint el format. 

public class TextReves{
    public static void main(String [] args){
        
        String reves = "";   
           
        System.out.println("Text?");
        String text = Entrada.readLine();
        
        
        for(int i = text.length()-1; i >= 0; i--){
            
            if(Character.isLetterOrDigit(text.charAt(i))){
                reves += text.charAt(i);
            }    
        }
  
        int j = 0;
        for(int i = 0; i < text.length(); i++){   
  
            if(Character.isLetterOrDigit(text.charAt(i))){
                  System.out.print(reves.charAt(j));
                  j++;
            } else {
                System.out.print(text.charAt(i));
            }
        }
    }
}
        
            
        
        
