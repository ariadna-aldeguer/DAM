// Funcions de comprovació: si l'entrada es un número

public class UtilString {

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
}
