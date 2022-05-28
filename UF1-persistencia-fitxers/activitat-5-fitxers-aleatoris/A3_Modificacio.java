// Crea un programa Java que rebi des de la línia de comandes un identificador d'empleat i un import. 
// S'ha de realitzar la modificació del salari. La modificació consistirà a sumar al salari de l'empleat l'import introduït.
// El programa ha de visualitzar el cognom, el salari antic i el nou. 
// Si l'identificador no existeix es visualitzarà missatge indicant-ho i s’aturarà l’execució.
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class A3_Modificacio{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        int idenfiticador = demanaId();
        double importe = demanaImport();


        File fitxer = new File ("AleatoriTreballador.dat");
        RandomAccessFile file = new RandomAccessFile (fitxer, "rw");
        int id, dep, posicio;
        Double salari;
        char cognom[]= new char[10], aux;
        posicio = 0;
        for ( ; ; ){
            file.seek (posicio); // Ens posicionem a "posició"
            id = file.readInt(); // Obtenim l'identificador del treballador
            for (int i=0; i<cognom.length; i++) {
                aux = file.readChar(); // Llegim caràcter a caràcter el cognom i...
                cognom[i]=aux; //... el desem a l'array cognom
            }
            String cognoms = new String (cognom);
            dep = file.readInt(); //Lectura de departament i salari
            salari = file.readDouble();
            if(id == idenfiticador){
                file.seek(posicio);
                System.out.printf("Cognom: %s, Salari antic: %.2f, Salari nou: %.2f  %n", cognoms.trim(), salari, (salari + importe));
                file.writeInt(idenfiticador);
                StringBuffer buffer =  new StringBuffer(cognoms);
                buffer.setLength(10); 
                file.writeChars (buffer.toString());
                file.writeInt(dep);
                file.writeDouble (salari + importe);
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
    public static double demanaImport(){
        while(true){
            try {
                System.out.println("Introdueix l'import:");
                String importe = sc.next();
                double i = Double.valueOf(importe);
                return i;
            } catch (NumberFormatException e) {
                System.out.println("No es un número válid.");
            }
        }
    }
}