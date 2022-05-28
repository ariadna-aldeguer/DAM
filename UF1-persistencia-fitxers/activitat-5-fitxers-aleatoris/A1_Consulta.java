import java.io.*;
import java.util.Scanner;
/* CONSULTA. Crea un programa Java que consulti les dades d'un empleat del fitxer aleatori.
 El programa s'executarà des de la línia de comandes i ha de rebre un identificador d'empleat. 
Si l'empleat existeix es visualitzaran les seves dades, si no existeix es visualitzarà un missatge indicant-ho.
*/
public class A1_Consulta {
    public static void main(String[] args) throws IOException{
        boolean trobat = false;
        System.out.println("Introdueix nº identificador d'usuari:");
        Scanner sc = new Scanner(System.in);
        try {
            int idenfiticador = sc.nextInt();
            File fitxer = new File ("AleatoriTreballador.dat");
            RandomAccessFile file = new RandomAccessFile (fitxer, "r");
            int id, dep, posicio;
            Double salari;
            char cognom[]= new char[10], aux;
            posicio = 0;
            for ( ; ; ){
                file.seek (posicio); // Ens posicionem a "posició"
                id = file.readInt(); // Obtenim l'identificador del treballador
                if(id != idenfiticador){
                    posicio = posicio + 36;
                    if (posicio == file.length()) break; // Si he recorregut tot el fitxer, acabem
                    continue;
                }
                trobat = true;
                for (int i=0; i<cognom.length; i++) {
                    aux = file.readChar(); // Llegim caràcter a caràcter el cognom i...
                    cognom[i]=aux; //... el desem a l'array cognom
                }
                String cognoms = new String (cognom);
                dep = file.readInt(); //Lectura de departament i salari
                salari = file.readDouble();
                System.out.printf("ID: %s, cognom: %s, Departament: %d, Salari: %.2f %n", id, cognoms.trim(), dep, salari);
                posicio = posicio + 36;
                if (posicio == file.length()) break; // Si he recorregut tot el fitxer, acabem
            } // Tancament del for
            if (!trobat){
                System.out.println("No s'ha trobat cap empleat amb aquest identificador.");
            }
            file.close();
        } catch (NumberFormatException e) {
            System.out.println("No es un número válid");
        } 
    }
}
