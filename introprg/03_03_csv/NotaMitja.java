/* 
 * Programa que retorna la mitja de la clase
 * llegint d'un fitxer csv
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 public class NotaMitja {
     public static void main(String[] args) throws IOException {
          
        // Archiu que llegeix
          
        String cami = "notes.csv";
        
        // Métode per guardar la informació linia per linia
          
        FileReader fileReader = new FileReader(cami);
        BufferedReader input = new BufferedReader(fileReader);
        String linia = input.readLine();
          
        while(true){
          
            linia = input.readLine();   
            
            if(linia == null) break;  
            // Array de Strings de la linia. Split (separa)
             
            String[] elements = linia.split(",");
              
            // Mitja de les notes
              
            double suma = 0;

            for (int i=0; i<elements.length; i++) {
               if (i == 0)  {
                  System.out.printf("%s (", elements[i]);    
               } else {
                   boolean numValid = esEnter(elements[i]);
                   if (numValid){
                       int  numero = Integer.parseInt(String.valueOf(elements[i]));
                       suma += numero;
                   }
               }
           }
           System.out.printf("%.2f)%n", suma/6);
       }
       System.out.println();
       input.close();
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
    
