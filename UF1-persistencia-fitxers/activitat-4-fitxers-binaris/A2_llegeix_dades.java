import java.io.*;

// A2- Ara escriu un programa que permeti visualitzar les dades gravades anteriorment en el fitxer “FitxerDades.dat”.
// S'han d'obtenir en el mateix ordre en el qual es van escriure, és a dir, primer obtenim el nom i després l'edat.


public class A2_llegeix_dades {
    public static void main (String[] args) {

        File fitxer = new File ("FitxerDades.dat");
        try {
            DataInputStream dataIN = new DataInputStream(new FileInputStream(fitxer));

            while(dataIN.available()>0) {
            
                String nom = dataIN.readUTF();
                int edat = dataIN.readInt();
                System.out.print(nom +" " + edat + "\n");
            }

            dataIN.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}