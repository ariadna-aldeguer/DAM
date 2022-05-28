
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class FuerzaBruta {
    public static void main(String[] args) {
        byte [] enc = { 
            (byte)0x2d,(byte)0xb3,(byte)0x14,(byte)0x90,
            (byte)0xbd,(byte)0x0a,(byte)0xb1,(byte)0x7c,
            (byte)0x45,(byte)0x2f,(byte)0x40,(byte)0x67,
            (byte)0xc0,(byte)0x81,(byte)0xe2,(byte)0x79,
            (byte)0x4d,(byte)0xa8,(byte)0x54,(byte)0x86,
            (byte)0x3a,(byte)0xf7,(byte)0x0e,(byte)0x64,
            (byte)0x97,(byte)0xc1,(byte)0x78,(byte)0xef,
            (byte)0x84,(byte)0xdd,(byte)0x9a,(byte)0xf1
        };
        for (int i = 0; i < 9999; i++) {
           try {
                String contrasenya= Integer.toString(i);
                byte[] contra_hash= contrasenya.getBytes("UTF-8");
                MessageDigest md= MessageDigest.getInstance("SHA-256");
                byte[] hash= md.digest(contra_hash);
                byte[] key= Arrays.copyOf(hash, 192/8);
                SecretKey clau= new SecretKeySpec(key,"AES");
                Cipher cipher= Cipher.getInstance("AES/ECB/PKCS5PADDING");
                cipher.init(Cipher.DECRYPT_MODE,clau);
                byte[] e= cipher.doFinal(enc);
                
                System.out.print(i+" ");
                System.out.println(new String(e));
           } catch (Exception e) {

           }
        }
    }
}