/* 
 * Programa que retorna la mitja de la clase
 * llegint d'un fitxer csv
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 public class ProcesaLiniaCSV {
     public static void main(String[] args) throws IOException {
          
        // Archiu que llegeix
          
        String cami = "notes.csv";
        
        // Métode per guardar la informació linia per linia
          
        FileReader fileReader = new FileReader(cami);
        BufferedReader input = new BufferedReader(fileReader);
        String linia;
          
        while(true){
          
            linia = input.readLine();   
            
            if(linia == null) break;  
            // Array de Strings de la linia. Split (separa)
             
            String[] elements = linia.split(",");
              
            // Mitja de les notes
              
            int suma = 0;
            int contador = 0;
             
            for (int i=0; i<elements.length; i++) {
               if (i == 0)  {
                  System.out.printf("%d (", elements[i]);    
               } else {
                   int num = Integer.parseInt(elements[i]);
                   suma += num;
                   contador++;
               }
           }
           System.out.printf("%.2f )%n", suma/contador);
       }
       input.close();
    }
}
    
