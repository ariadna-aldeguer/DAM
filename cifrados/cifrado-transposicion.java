import java.lang.System; 
import java.util.Scanner;
public class Trans { 
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un texto: ");
        String texto = sc.nextLine();
        System.out.print("Introduce numero columnas: ");
        int N = sc.nextInt();
        String cifrado = cifradoTrans(texto, N);
        System.out.println("Cifrado: " + cifrado);
        String descifrado = descifradoTrans(cifrado, N);
        System.out.println("Descrifrado: " + descifrado);
    }

    public static String descifradoTrans(String entrada, int N) {
        int contador = 0;
        String salida = "";
        int ver = (int) Math.ceil((double) entrada.length()/(double) N);
        char [][] matriz = new char[ver][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < ver; j++){
                if (contador >= entrada.length()){
                    matriz[i][j] = ' ';
                } else {
                    if(entrada.charAt(contador) == ' '){
                        matriz[j][i] = ' ';
                    } else {
                        matriz[j][i] = entrada.charAt(contador); 
                    }
                }
                contador++;
            }
        }
        for (int i = 0; i < ver; i++){
            for (int j = 0; j < N; j++){
                salida += matriz[i][j];
            }
        }
        return salida;
    }
    public static String cifradoTrans(String entrada, int N) {
        int contador = 0;
        String salida = "";
        int ver = (int) Math.ceil((double) entrada.length()/(double) N);
        char [][] matriz = new char[ver][N];
        for (int i = 0; i < ver; i++){
            for (int j = 0; j < N; j++){
                if (contador >= entrada.length()){
                    matriz[i][j] = ' ';
                } else {
                    if(entrada.charAt(contador) == ' '){
                        matriz[i][j] = ' ';
                    } else {
                        matriz[i][j] = entrada.charAt(contador); 
                    }
                }
                contador++;
            }
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < ver; j++){
                salida += matriz[j][i];
            }
        }
        return salida;
    }
}