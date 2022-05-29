//* Programa que demana un text i el codifica. 

public class CodificaBasic{
    public static void main(String [] args){
    
        char aux;    
        String vocals = "àéèíïóòúüá"; 
        boolean accents = false;
        
        System.out.println("Text?");
        String text = Entrada.readLine();
    
    
        for(int i = 0; i < text.length(); i++){
            accents = false;
            if(Character.isLowerCase(text.charAt(i))){ //*minuscula
                
                 if(text.charAt(i) == 'z'){ //*si es una Z
                    System.out.print("a");
                } else {
                
                    for(int a = 0; a < vocals.length(); a++){
                        
                        if(text.charAt(i) == vocals.charAt(a)){
                            System.out.print(text.charAt(i));
                            accents = true;
                        } 
                    } 
                    if(!accents){                            
                        aux = (char) (text.charAt(i) + 1);   
                        System.out.print(aux);
                    }
                }
            } else {
                System.out.print(text.charAt(i));
            }
       }
       System.out.println();
   }
}            
