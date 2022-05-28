// Crea un programa Java que en executar-lo des de la línia de comandes rebi un identificador d'empleat i l'esborri. 
// Es farà un esborrat lògic marcant el registre amb la següent informació: l'identificador serà
// igual a -1, el cognom serà igual a l'identificador que s'esborra, i el departament i salari seran 0.

import java.io.*;
import java.util.Scanner;

public class A4_Esborrat{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException{

        int idenfiticador = demanaId();

        File fitxer = new File ("AleatoriTreballador.dat");
        RandomAccessFile file = new RandomAccessFile (fitxer, "rw");

        int id, dep, posicio;
        Double salari;
        char cognom[]= new char[10], aux;
        posicio = 0;
        for ( ; ; ){
            file.seek (posicio); // Ens posicionem a "posició"
            id = file.readInt(); // Obtenim l'identificador del treballador
            if(id == idenfiticador){
                file.seek(posicio);
                file.writeInt(-1);
                StringBuffer buffer =  new StringBuffer(idenfiticador);
                buffer.setLength(10); 
                file.writeChars (buffer.toString());
                file.writeInt(0);
                file.writeDouble (0);
                break;
            }
            posicio = posicio + 36;
            if (posicio == file.length()) break; // Si he recorregut tot el fitxer, acabem
        } // Tancament del for
        file.close();
    }
    public static boolean existeixIdentificador(int idenfiticador) throws IOException{
        File fitxer = new File ("AleatoriTreballador.dat");
        RandomAccessFile file = new RandomAccessFile (fitxer, "r");
        int id, posicio;
        posicio = 0;
        for ( ; ; ){
            file.seek (posicio); 
            id = file.readInt();
            if(id == idenfiticador){
                file.close();
                return true;
            }
            posicio = posicio + 36;
            if (posicio == file.length()) break;
        } 
        file.close();
        return false;
    }
    public static int demanaId(){
        while(true){
            try {
                System.out.println("Introdueix l'indentificador:");
                int idenfiticador = sc.nextInt();
                if (!existeixIdentificador(idenfiticador)){
                    System.out.println("No existeix un identificador amb aquest número");
                } else {
                    return idenfiticador;
                }
            } catch (NumberFormatException e) {
                System.out.println("No es un número válid.");
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}