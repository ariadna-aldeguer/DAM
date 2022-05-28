import java.io.*;

public class Borrar_fitxers {
    public static void main(String[] args) {
        File d = new File("NouDir");
        File f1 = new File(d, "Fitxer1.txt");
        File f2 = new File(d, "Fitxer2.txt");
        d.mkdir();
        System.out.println("S'ha creat el directori NouDir");
        try {
            if (f1.createNewFile())
                System.out.println("Fitxer1 creat correctament");
            else
                System.out.println("No s'ha pogut crear Fitxer1");
            if (f2.createNewFile())
                System.out.println("Fitxer2 creat correctament");
            else
                System.out.println("No s'ha pogut crear Fitxer2");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        f1.renameTo(new File(d, "Fitxer1Nou"));
        try {
            File f3 = new File("NouDir/Fitxer3.txt");
            f3.createNewFile();
            System.out.println("Fitxer2 creat correctament");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            File[] fitxers = d.listFiles();
            for (int i = 0; i < fitxers.length; i++){
                String name = fitxers[i].getName();
                fitxers[i].delete();
                System.out.println(name+ " borrat correctament");
            }
            try {
                d.delete(); 
                System.out.println("S'ha borrar el directori correctament");
            } catch (Exception e){
                System.out.println("No s'ha pogut borrar el directori" + e.getMessage());
            }
        } catch (Exception e){
            System.out.println("No s'han pogut borrar tots els fitxers" + e.getMessage());
        }
    }
}