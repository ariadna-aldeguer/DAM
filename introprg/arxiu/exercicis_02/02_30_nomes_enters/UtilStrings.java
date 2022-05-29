//

public class UtilStrings {

    public static int[] filtraEnters(String[] entrada){ 
        
        int quantsEnters = quantsEnters(entrada);
                
        int[] llistaNumeros = new int[quantsEnters];
        int j = 0;

        for(int i = 0; i < entrada.length; i++){
            boolean valid = esEnter(entrada[i]);
            if(valid){
                int numero = Integer.parseInt(entrada[i]);
                llistaNumeros[j] = numero;  
                j++;
            }
        }
        return llistaNumeros;    
    }   
   
    public static int quantsEnters(String[] llistaNumeros){
       
       int quantsEnters = 0; 
        
       for(int i = 0; i < llistaNumeros.length; i++){
            boolean valid = esEnter(llistaNumeros[i]);
            if(valid){
                quantsEnters += 1; 
            }
        }
        return quantsEnters;     
    }
    public static int sumaEnters(int[] llistaNumeros, int quantsEnters){
        
        int sumaEnters = 0;
        
        for(int i = 0; i < llistaNumeros.length; i++){
            sumaEnters += llistaNumeros[i];
        }
        return sumaEnters;
    
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
