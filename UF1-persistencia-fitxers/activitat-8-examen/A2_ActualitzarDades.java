/*A2.- Utilitzant la classe RandomAccessFile actualitza les dades contingudes en el fitxer generat en l'exercici anterior 
 de tal forma que els preus superiors a 100€ disminueixin en un 50% i els inferiors augmentin en un 50%.
Un cop creat el fitxer, fes que el programa llegeix-hi el fitxer i mostre les dades per pantalla. */

import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class A2_ActualitzarDades{
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {

        File fitxer = new File ("FitxerDades.dat");
        int id;
        int posicio = 0;
        double preu;
        try {
            // Modifica el fitxer
            RandomAccessFile file = new RandomAccessFile (fitxer, "rw");
            for ( ; ; ){
                file.seek (posicio); 
                id = file.readInt();
                preu = file.readDouble();

                if(preu < 100){
                    preu += preu * 0.5;
                } else {
                    preu -= preu * 0.5;
                }
                file.seek(posicio);
                file.writeInt(id);
                file.writeDouble(preu);
                posicio = posicio + 12;
                if (file.getFilePointer() == file.length()) break; 
            }
            file.close();
            // Llegir dades
            DataInputStream dataIN = new DataInputStream(new FileInputStream(fitxer));

            while(dataIN.available()>0) {
            
                int numb = dataIN.readInt();
                Double pre = dataIN.readDouble();
                System.out.print(numb +" - " + df.format(pre) + "\n");
            }

            dataIN.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 

    }
}