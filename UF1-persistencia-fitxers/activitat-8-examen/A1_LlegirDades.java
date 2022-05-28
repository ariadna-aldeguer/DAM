import java.io.*;
/*
Genera un fitxer que albergui dades en binari sobre els productes d'un magatzem. En cada línia o registre del fitxer s'emmagatzemaran dues dades:
Un número sencer que serà l'identificador.
Un número “double” que serà el preu del producte.
Les dades provindran de dos arrais definits a dintre del programa. L’arrai de sencers contindrà els valors {1,2,3,4} i el arrai de preus {12.3,14.6,10,90.76}.
Un cop creat el fitxer, fes que el programa llegeix-hi el fitxer i mostre les dades per pantalla.
*/

public class A1_LlegirDades {
    public static void main(String[] args) {
        
        // Creació de les Arrays

        int[] num = {1,2,3,4};
        Double[] preus = {12.3,14.6,10.0,90.76};

        // Creació del fitxer
        File fitxer = new File ("FitxerDades.dat");

        try {
            //Escriure dades
            DataOutputStream dataOS = new DataOutputStream (new FileOutputStream (fitxer, true));

            for(int i = 0; i < num.length; i++){
                dataOS.writeInt(num[i]);
                dataOS.writeDouble(preus[i]);
            }
            dataOS.close();

            // Llegir dades
            DataInputStream dataIN = new DataInputStream(new FileInputStream(fitxer));

            while(dataIN.available()>0) {
            
                int numb = dataIN.readInt();
                Double preu = dataIN.readDouble();
                System.out.print(numb +" - " + preu + "\n");
            }

            dataIN.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}