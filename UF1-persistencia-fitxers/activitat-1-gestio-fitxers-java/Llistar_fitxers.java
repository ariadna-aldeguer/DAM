import java.io.*;

public class Llistar_fitxers {
    public static void main(String[] args) {
        try {
            // String ruta_Absoluta = "/home/ari/Desktop/DAM/Acces_a_dades/uf1"
            String dir = args[0]; // Ruta absoluta
            try {
                File directori = new File(dir);
                File[] fitxers = directori.listFiles();

                for (int i = 0; i < fitxers.length; i++) {
                    System.out.println("Nom: " + fitxers[i].getName() + "\n" +
                    "Ruta relativa: " + fitxers[i].getPath() + "\n" +
                    "Ruta absoluta: " + fitxers[i].getAbsolutePath() + "\n" +
                    "Permisos: Pot escriure: " + fitxers[i].canWrite() + ", pot llegir: " + fitxers[i].canRead() + ", pot executar: " + fitxers[i].canExecute() + "\n" +
                    "Grandaria: " + fitxers[i].length());
                }
            } catch (Exception e){
                System.out.println("El directori no existeix");
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("No s'ha introduït cap argument: " + e.getMessage());
        } 
    }
}