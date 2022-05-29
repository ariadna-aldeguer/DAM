/*
 * programa que canvia una paraula "clau" per una altra d'un fitxer
 */
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Traduccio {
    public static void main (String [] args) throws IOException{
        
        if (args.length != 3){
            System.out.println("ERROR: Cal especificar els fitxers origen, traduccio i destinació");
            return;
        }
        
        tradueix(args[0], args[1], args[2]);
        
        
    }
    public static void tradueix(String fitxerOrigen, String fitxerTraduccio, String fitxerDestinacio) throws IOException {
        
        FileReader origen = new FileReader(fitxerOrigen);
        BufferedWriter sortida = new BufferedWriter(new FileWriter(fitxerDestinacio));
        
        BufferedReader input = new BufferedReader(origen); 
        
        while (true){
        
            String linia = input.readLine();
            if (linia == null){
                    break;
            }        
            String print = tradueixLinia(linia, fitxerTraduccio);
            sortida.write(print + "\n");
            
            
        }
        sortida.close();
        origen.close();

    }
    public static String tradueixLinia(String linia, String fitxerTraduccio) throws IOException{
        
        FileReader traduccio = new FileReader(fitxerTraduccio);
        BufferedReader input = new BufferedReader(traduccio); 
        
            while (true){
            
                String lineaTraduccio = input.readLine();
                if (lineaTraduccio == null){
                    break;
                }

                // Separa la linea en dos parts
                String[] parts = lineaTraduccio.split(",");
               // System.out.println(parts[0] + parts[1].strip());
                if (parts.length != 2){
                    continue;
                }
                // Tradueix
                linia = linia.replace(parts[0], parts[1].strip());

            }

        traduccio.close();    
        return linia; 
    }
}

                                
