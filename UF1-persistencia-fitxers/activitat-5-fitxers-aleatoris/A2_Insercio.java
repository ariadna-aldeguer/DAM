import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

// Crea un programa Java que insereixi dades en el fitxer aleatori. 
// El programa s’executarà des de la línia de comandes i ha de rebre 4 paràmetres:
//  identificador d'empleat, cognom, departament i salari. Abans d'inserir es comprovarà si l'identificador existeix, 
// en aquest cas s'ha de visualitzar un missatge indicant-ho i s’aturarà l’execució del programa; si no existeix s'haurà d'inserir.

public class A2_Insercio{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        File fitxer = new File ("AleatoriTreballador.dat");
        RandomAccessFile file = new RandomAccessFile (fitxer , "rw");
        file.seek(file.length());
        file.writeInt(demanaId());
        StringBuffer buffer =  new StringBuffer(demanaCognom());
        buffer.setLength(10); 
        file.writeChars (buffer.toString());
        file.writeInt(demanaDepartament());
        file.writeDouble (demanaSalari());
        file.close(); // Tanquem el fitxer
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
                String idenfiticador = sc.next();
                int id = Integer.valueOf(idenfiticador);
                if (existeixIdentificador(id)){
                    System.out.println("Ja existeix un identificador amb aquest número");
                } else {
                    return id;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage() + "No es un número válid.");
            }
        }
    }
    public static String demanaCognom(){
        System.out.println("Introdueix el cognom:");
        String cognom = sc.next();
        return cognom;
    }
    public static int demanaDepartament(){
        while(true){
            System.out.println("Introdueix el departament:");
            try {
                int dept = sc.nextInt();
                return dept;
            } catch (Exception e) {
                System.out.println("No es un número válid.");
            }
        }
    }
    public static double demanaSalari(){
        while(true){
            System.out.println("Introdueix el salari:");
            try {
                String salari = sc.next();
                double s = Double.valueOf(salari);
                return s;
            } catch (NumberFormatException e) {
                System.out.println("No es un número válid.");
            }
        }
    }
}