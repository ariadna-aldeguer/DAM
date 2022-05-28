import java.lang.System; 
import java.util.Scanner;
public class Cesar { 
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un texto: ");
        String texto = sc.nextLine();
        System.out.print("Introduce numero: ");
        int N = sc.nextInt();
        String cifrado = cifradoCesar(texto, N);
        System.out.println("Cifrado: " + cifrado);
        String descifrado = descifradoCesar(cifrado, N);
        System.out.println("Descrifrado " + descifrado);
    }

    public static String descifradoCesar(String entrada, int N) {
        String salida = "";
        int numChar;
        for (int i = 0; i < entrada.length(); i++){
            numChar = (int) entrada.charAt(i) - N;
            if (numChar < 97){
                numChar = numChar + 122 - 96;
            }
            salida += Character.toString((char) numChar);
        }
        return salida;
    }
    public static String cifradoCesar(String entrada, int N) {
        String salida = "";
        int numChar;
        for (int i = 0; i < entrada.length(); i++){
            if (entrada.charAt(i) == ' ') {
                
            } 
            numChar = (int) entrada.charAt(i) + N;
            if (numChar > 122){
                numChar = numChar - 122 + 96;
            }
            salida += Character.toString((char) numChar);
        }
        return salida;
    }
}