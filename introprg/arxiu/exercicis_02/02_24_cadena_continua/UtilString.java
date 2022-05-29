// Funció que comprova que sigui un número Enter

public class UtilString{
    
    public static boolean esEnter(String text){
        
        if(!text.isEmpty()){    
            if(text.charAt(0) == '-' || text.charAt(0) == '+'){
                for(int i = 1; i < text.length(); i++){
                         
                    if(!Character.isDigit(text.charAt(i))){
                        return false;
                    }
                }
                return true; 
            } else {
                for(int i = 0; i < text.length(); i++){
                         
                    if(!Character.isDigit(text.charAt(i))){
                        return false;
                    }
                }
                return true; 
           }
       } 
       return false;
   }
 // Funció que retorna una cadena de text, donat un text i la longitud  
   public static String cadenaContinua(String text, int longitud) {
        
        String aux ="";

        
        if (longitud < text.length()){ 
            for (int i = 0; i < longitud; i++){
                aux += text.charAt(i);
            }
        } else { 
            if (longitud%text.length() == 0){
                for (int i = 1; i <= (longitud/text.length()); i++){
                    for(int a = 0; a < text.length(); a++){
                        aux += text.charAt(a);
                    }
                }
            } else {
                for (int a = 1; a <= longitud/text.length(); a++){
                    for (int i = 0; i < text.length(); i++){
                        aux += text.charAt(i);
                    }
                }
                for (int i = 0; i <longitud%text.length(); i++){
                    aux += text.charAt(i);
                }
            }
        }
        return aux;
   }
}
