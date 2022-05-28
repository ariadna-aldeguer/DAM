package fluxes_streams;
import java.io.*;
public class A4_EscriuBufferedWriter{
    public static void main(String[] args) throws IOException {
        try {
            File file = new File(args[0]); // declaració del fitxer
            BufferedWriter bw = new BufferedWriter(new FileWriter(file)); // declaració del writer

            for (int x=1;x<=10;x++){ // Escriu 10 files 
                bw.write("Fila numero " + x);
                bw.newLine(); // Salt de lía
            }
            
            bw.close(); // Es tanca el fitxer
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}