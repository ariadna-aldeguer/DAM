// Funció que comprova si es vocal
// Té en compte si son mayúscules o no.

public class UtilString {
    
    public static boolean esVocal(char lletra) {
    
        String vocals = "aeiouàèéíïòóúü";
        String mayusculas = vocals.toUpperCase();
        
        for (int i = 0; i < vocals.length(); i++) {
        
            if (vocals.charAt(i) == lletra){
                return true;
            }
            if (mayusculas.charAt(i) == lletra){
                return true;
            }
        }
        return false;
    }    
}
            
