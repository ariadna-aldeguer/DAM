// Funció que comprova si es vocal

public class UtilString {
      
    // Entra: text. Surt: Només Lletres
    public static String nomesLletres(String text){
    
        String nomesLletres = "";
        for(int i = 0; i < text.length(); i++){
            if(Character.isLetter(text.charAt(i))){
                nomesLletres += text.charAt(i);
            }
        }
        return nomesLletres;
    }
    // Entra: Concatenació de lletres. Surt: lletres entre comes
    public static String lletresSeparades(String text){
    
    
        String separades = "";
        
            if(text.length() > 0){
                    
                separades = String.valueOf(text.charAt(0));
            
                for(int i = 1; i < text.length(); i++){
                    separades += ", " + text.charAt(i);
            }
        }
        return separades;
    }
}
            
