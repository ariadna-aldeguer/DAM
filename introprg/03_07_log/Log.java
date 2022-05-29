/*
 * Programa que guarda els logs d'errors.
 */

import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Log {
    
    public static int contador = 0;
    
    public static String printError(String linia) throws IOException {
        
        contador++;
        String resultat = String.format("[%d] ERROR: %s", contador, linia);
        BufferedWriter sortida = new BufferedWriter(new FileWriter("./log.txt", true));
        sortida.write(resultat +"\n");
        sortida.close();
        
        return resultat;
        
        
        
    }
    public static String printWarning(String linia) throws IOException {
        
        contador++;
        String resultat = String.format("[%d] WARNING: %s", contador, linia);
        BufferedWriter sortida = new BufferedWriter(new FileWriter("./log.txt", true));
        sortida.write(resultat +"\n");
        sortida.close();
        return resultat;
         
    }
    public static String printInfo(String linia) throws IOException {
       
        contador++;
        String resultat = String.format("[%d] INFO: %s", contador, linia);
        BufferedWriter sortida = new BufferedWriter(new FileWriter("./log.txt", true));
        sortida.write(resultat +"\n");
        sortida.close();
        return resultat;
    }
    public static String printDebug(String linia) throws IOException {
      
        contador++;
        String resultat = String.format("[%d] DEBUG: %s", contador, linia);
        BufferedWriter sortida = new BufferedWriter(new FileWriter("./log.txt", true));
        sortida.write(resultat +"\n");
        sortida.close();
        return resultat;
        
    }
    public static void reset(){
        contador = 0;
    }
}
