/*
 * programa que simula un lloro que recorda les frases que li han dit
 */
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Recordat {
    public static void main(String[] args) throws IOException {
        String cami = "records.txt";
        processaEntrada(cami);
        System.out.println("D'acord");
        mostraRecords(cami);
    }

    /**
     * Demana frases per entrada estàndard i les guarda a un fitxer
     * @param nomFitxer: nom del fitxer
     */
    public static void processaEntrada(final String nomFitxer) throws IOException {
        
        BufferedWriter sortida = new BufferedWriter(new FileWriter(nomFitxer,true));
        
        while (true){
            System.out.println("El lloro pregunta paraula:");
            String entrada = Entrada.readLine();
            if(entrada.isBlank()){
                break;
            }
            String escriu = entrada.trim();
            escriu += "\n";
            sortida.write(escriu);
            System.out.printf("El lloro registra: %s%n", escriu);
        }     
        sortida.close();   
     }   
    public static void mostraRecords(final String nomFitxer) throws IOException {

        BufferedReader entrada = new BufferedReader(new FileReader(nomFitxer));
        String linia = entrada.readLine();
        if(linia == null){
            System.out.println("El lloro no recorda res");
        } else {
            while(true){
                System.out.printf("El lloro recorda: %s%n", linia);   
                linia = entrada.readLine();
                if(linia == null) break;
            }
        }
        System.out.println("Adéu");
        entrada.close();
        
    }

}
