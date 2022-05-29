
/* Llibreria externa
 * esEnter: comprova un número
 */ 
 
public class UtilString{
    
    public static boolean esEnter(String text){
        
        if (text.isEmpty()) return false;
        for (int i = 0; i < text.length(); i++){
            if (text.charAt(0) == '-' || text.charAt(0) == '+') continue;
            if (Character.isDigit(text.charAt(i))){
                continue;
            } else {
                return false;
            }
       } 
       return true;
    }  
}
