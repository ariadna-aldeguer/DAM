//* Programa que demana un text i analitza si es un numero o no, borrant espais.

public class EsEnter{
    public static void main(String [] args){
        
        System.out.println("Introdueix texts (enter sol per finalitzar)");
        String text = Entrada.readLine();
        int num = text.length();
        String aux = "";
        boolean valid = true;
        char letra; 
        
        text = text.strip();
        int numero = Integer.parseInt(text);
        
        while(!(text.isBlank())){
        
            text = text.strip();
          
            for(int i = 0; i < num; i++){
                
               letra = text.charAt(i);
              
                    if(Character.isDigit(letra)){
                        valid = true;
                        
                    } else {
                        valid = false;    
                    }
            } 
            
            if(valid == true){
                System.out.println("És enter");
            } else {
                System.out.println("No és enter");
            }
            text = Entrada.readLine();
       }     
      
       System.out.println("Adéu"); 
   }   
}    
        
                
        
        
