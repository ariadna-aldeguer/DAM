import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Scanner;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class AES {   public static void main (String[] args) {
    
    System.out.println("Entre el nombre de un fichero");
    Scanner sc = new Scanner(System.in);
    String nomFitxer = sc.nextLine(); 
    File fitxer = new File(nomFitxer);

        if(fitxer.exists()) {

            System.out.print("Contraseña: ");
            String password = sc.nextLine();

            try {

                byte[] data = password.getBytes("UTF-8");
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(data);
                byte[] key=  Arrays.copyOf(hash, 192/8);
                SecretKey clau = new SecretKeySpec(key, "AES");

                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING" );

                String nomFitxerNou;

                if (nomFitxer.endsWith(".aes")) {
                    cipher.init(Cipher.DECRYPT_MODE, clau);
                    nomFitxerNou = nomFitxer.substring(0, nomFitxer.length()-4);
                } else {
                    cipher.init(Cipher.ENCRYPT_MODE, clau);
                    nomFitxerNou = nomFitxer + ".aes";
                }

                byte[] dades = new byte[1024];
                
                FileOutputStream out = new FileOutputStream(nomFitxerNou);
                FileInputStream in = new FileInputStream(nomFitxer);

                int llegits = in.read(dades);
                while (llegits > 0){
                        out.write( cipher.doFinal(dades, 0, llegits) );
                        llegits = in.read(dades);
                }
                in.close();
                out.close();


                RandomAccessFile rand = new RandomAccessFile(nomFitxer, "rw");
                for (int i=0; i< rand.length(); i++){
                    rand.write(0);
                }
                rand.close();
                fitxer.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El fichero no existe");
        }
    } 
}