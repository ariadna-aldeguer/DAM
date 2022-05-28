package fluxes_streams;
import java.io.*;
public class A2_escriuFitxerText {
   public static void main(String[] args) throws IOException {
        try {   
            File fitxer = new File(args[0]); // declaració del fitxer
            FileWriter fitW = new FileWriter(fitxer, true); // declaració del writer

            String cadena = "--- Prova usant FileWriter ---";
            char[] cad = cadena.toCharArray();

            String prov[] = {"Albacete", "Avila", "Badajoz", "Caceres", "Huelva", "Jaen",
            "Madrid", "Segovia", "Soria", "Toledo", "Valladolid", "Zamora"};
            
            fitW.write(cad, 0, cad.length);  // Escriu la cadena directament
            fitW.write(System.getProperty( "line.separator" ));  // línia separadora

            for (String paraula : prov) {
                cad = paraula.toCharArray();
                fitW.write(cad, 0, cad.length);  // Escriu cada paraula
                fitW.write(System.getProperty( "line.separator" ));
            }
            fitW.append('*'); // afegim un asterisc al final
            fitW.close(); // tanquem el fitxer
        } catch (Exception e){
            System.out.println(e);
        }
   }
}
