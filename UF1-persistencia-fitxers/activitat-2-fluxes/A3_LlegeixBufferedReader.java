package fluxes_streams;
import java.io.*;
public class A3_LlegeixBufferedReader{
    public static void main(String[] args) throws IOException {
        try {
            File fitxer = new File (args[0]); // declaració del fitxer
            FileReader flux = new FileReader (fitxer);  // declaració del reader
            BufferedReader bReader = new BufferedReader(flux); // métode BufferReader

            String linia;
            while ((linia = bReader.readLine()) != null){ // llegim de línia en línia
               System.out.println (linia);
               
            }
            
            bReader.close(); // tanquem el fitxer

        } catch (FileNotFoundException e){
            System.out.println("No existeix el fitxer");
        } catch (Exception e){
            System.out.println(e);
        }
    }
}