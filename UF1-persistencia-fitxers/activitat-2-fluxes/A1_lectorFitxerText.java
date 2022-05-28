package fluxes_streams;
import java.io.*;
import java.util.Arrays;
public class A1_lectorFitxerText {
   public static void main (String [] args) throws IOException {
        try {
            File fitxer = new File (args[0]); // declaració del fitxer
            FileReader flux = new FileReader (fitxer); // creem flux d'entrada al fitxer
            char text[] = new char[20]; // Creem un char de 20 carácters
            int i;

            while((i = flux.read(text, 0, 20)) != -1){   // i = 20 carácters
                    if(text.length == i){
                        System.out.println(text); // printa els 20 carácters
                    } else if (text.length != i){ // si es diferent, només queda l'última fila
                            System.out.println(Arrays.copyOfRange(text, 0, i));
                    }
            }
            flux.close(); // tanquem el flux
        
        } catch (Exception e){
            System.out.println("No existeix el fitxer");
        }
   }
}
