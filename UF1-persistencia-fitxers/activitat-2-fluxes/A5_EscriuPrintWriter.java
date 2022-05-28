package fluxes_streams;
import java.io.*;
public class A5_EscriuPrintWriter{
    public static void main(String[] args) throws IOException {
        try {

            File file = new File(args[0]); // declaració del fitxer
            PrintWriter pw = new PrintWriter(new FileWriter(file)); // declaració del writer

            for (int x=1;x<=10;x++){ // Escriu 10 files 
                pw.println("Fila numero " + x + " Print Writer");
            }
            
            pw.close(); // Es tanca el fitxer
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}