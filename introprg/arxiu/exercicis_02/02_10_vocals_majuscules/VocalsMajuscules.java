//* Programa que demana un text i retorna les vocals amb Majúscules.

public class VocalsMajuscules{
    public static void main(String [] args){
        
       
        System.out.println("Text?");
        String textAux = Entrada.readLine();
        String text = textAux.toLowerCase();
        
        if(text.isBlank()){return;}
        
        majusculitzaVocals(text);
    
    }
    
    public static void majusculitzaVocals(String text){
    
        String vocals = "aeiou";     
        boolean conteVocal = false;  
        
        for(int i = 0; i < text.length(); i++){
            conteVocal = false;
            for(int n = 0; n < vocals.length(); n++){
                
                if(text.charAt(i) == vocals.charAt(n)){
                    System.out.print(Character.toUpperCase(text.charAt(i)));
                    conteVocal = true;
                    break;
                }
            }
            if(!conteVocal){
            System.out.print(Character.toLowerCase(text.charAt(i)));
            }
       }
       System.out.println();    
    }
} 
   

