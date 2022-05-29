//*Programa que demana text i el transforma segons unes regles específiques.

public class TransformaText{
    public static void main (String [] args){
    
       String vocals = "aeiouáàéèíïóòúü";       
            
            
            System.out.println("Text?");
            String text = Entrada.readLine(); 
            text = text.toLowerCase();      
            String num = "";
            boolean numero = false;
            boolean vocal;
            
            for(int i = 0; i < text.length(); i++){
                
                
                vocal = false;
            
                if(Character.isDigit(text.charAt(i))){
                       num += text.charAt(i);
                       numero = true;
                       
                } else if(Character.isLetter(text.charAt(i))){
                    if(numero){
                        System.out.print("("+ num +")");
                        num = "";
                        numero = false;
                    }
                    for(int n = 0; n < vocals.length(); n++){
                        
                        if(text.charAt(i) == vocals.charAt(n)){
                              System.out.print(text.charAt(i));
                              vocal = true;
                              break;  
                        }   
                    }
                    if(!vocal){
                         System.out.print(Character.toUpperCase(text.charAt(i)));
                         continue;
                    }  
               } else if(Character.isWhitespace(text.charAt(i))){
                    if(numero){
                        System.out.print("("+ num +")");
                        num = "";
                        numero = false;
                    }
                    System.out.print(text.charAt(i));
               } 
           }
           if(numero){
                        System.out.print("("+ num +")");
                        num = "";
           }
           System.out.println();    
     }
}
        
        

