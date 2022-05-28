import java.io.*;
import java.util.ArrayList;

// A1- Escriu un programa que insereixi dades en “FitxerDades.dat”. Les dades les prendrà de dos arrays fixes definits en el propi programa. 
// Un array contindrà els noms d'una sèrie de persones.
// L'altre array contindrà les edats de els persones. 
// S'anirà recorrent els arrays i anirem escrivint en el fitxer el nom (mitjançant el mètode writeUTF(String str) i l'edat (writeInt (int v)). 
// NOTA: si volem afegir bytes al final del fitxer (“FitxerDades.dat”) es pot usar el següent constructor: FileOutputStream fileout = new FileOutputStream (fitxer, true).

public class A1_insereix_dades {
    public static void main (String[] args) {

        // Creació de les Arrays

        ArrayList<String> noms = new ArrayList<String>();
        noms.add("Ariadna");
        noms.add("Laura");
        noms.add("Miquel");

        int[] edats = {25, 20, 21};

        // Creació del fitxer

        File fitxer = new File ("FitxerDades.dat");
        try {
            // FileOutputStream fileout = new FileOutputStream (fitxer);
            DataOutputStream dataOS = new DataOutputStream (new FileOutputStream (fitxer, true));
            // Escriptura de dades
            for(int i = 0; i < noms.size(); i++){
                dataOS.writeUTF(noms.get(i));
                dataOS.writeInt(edats[i]);
            }
            dataOS.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
