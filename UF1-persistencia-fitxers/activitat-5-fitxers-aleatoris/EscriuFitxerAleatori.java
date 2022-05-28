import java.io.*;
public class EscriuFitxerAleatori {
   public static void main (String [] args) throws IOException {
       
       File fitxer = new File ("AleatoriTreballador.dat");
       RandomAccessFile file = new RandomAccessFile (fitxer , "rw");
       String cognom[] = {"Fernández", "Gil", "López", "Ramos"};
       int dep[] = {10,20,10,10};
       Double salari[] = {1000.45,2400.60,3000.0,1500.56};
       StringBuffer buffer = null; //Buffer per emmagatzemar cognom
       int n = cognom.length; //Número d'elements en l'arrai
       for (int i = 0; i<n; i++) { //Recorrem els arrais
           file.writeInt (i+1);
           buffer = new StringBuffer (cognom[i]);
           buffer.setLength(10); // Fixem en 10 caràcters la longitud del cognom
           file.writeChars (buffer.toString());
           file.writeInt(dep[i]);
           file.writeDouble (salari[i]);
       }
       file.close(); // Tanquem el fitxer
   }
}