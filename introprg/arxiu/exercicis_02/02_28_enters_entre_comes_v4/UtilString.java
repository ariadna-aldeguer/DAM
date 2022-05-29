//UtilString: Numeros entre comas & Comprobar que un texto sea un numero

public class UtilString {

// Dame un array de Enteros y un separador y yo te devuelvo la lista separada.
    public static String entreComes(int[] numeros, char separador){
        
        
        String aux = "";
        if(numeros.length > 0){
            aux =  String.valueOf(numeros[0]);
            for (int i = 1; i < numeros.length; i++) { //Print els valors entre comes
              
                aux += separador + " " +  String.valueOf(numeros[i]);
            }
        }    
        return aux;
    
    }
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
