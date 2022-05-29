/* Puzle: Funció ls. 
 * Mostra tots els fitxers amb nom de puzle válid que es troben a la carpeta
 */

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.io.File;
import java.io.InputStreamReader;



public class Puzle {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException  {
        mostraBenvinguda();
        while (true) {
            mostraPrompt();
            String comanda = readLine().strip();
            if (comanda.isEmpty()) continue;
            if (comanda.equals("quit")) break;
            if (comanda.equals("help")) {
                mostraAjuda();
                continue;
            }
            if(comanda.equals("ls")){
                mostraLlista();   
            } else {
                mostraErrorComandaDesconeguda();
            }
        }
        mostraComiat();
    }
    
    public static void mostraBenvinguda() {
    
        System.out.println("Gestor de puzles d'escacs. Escriviu help per ajuda.");
    
    }
    public static void mostraPrompt(){
    
        System.out.print("puzle> ");
    
    }
    public static void mostraAjuda(){
    
        System.out.println("Comandes disponibles:");
        System.out.println("help");
        System.out.println("cp «nom1» «nom2»");
        System.out.println("add «nom» «figura» «fila» «columna»");
        System.out.println("del «nom» «fila» «columna»");
        System.out.println("mv »nom» «fila0» «columna0» «fila1» «columna1»");
        System.out.println("new «nom»");
        System.out.println("quit");
    
    }
    public static void mostraErrorComandaDesconeguda(){
        
        System.out.println("ERROR: comanda no reconeguda. Escriviu help per ajuda.");
    }
    public static void mostraComiat(){
    
        System.out.println("adèu");
    
    }
    public static boolean esNomFitxerDePuzleValid(String nomFitxer){
        
        String nom = nomFitxer.toLowerCase();

        if(nom.length()<6) return false; 
        
        if (!nom.substring(0,6).equals("puzle_")) return false;
        if (!nom.substring(nom.length()-4,nom.length()).equals(".txt")) return false;
        if ((nom.substring(6,nom.length()-4)).isBlank()) return false;
        
        for (int i = 0; i < nom.length(); i++){ 
            if (!Character.isDigit(nom.charAt(i))){  //Si no és un número
                if (!  (nom.charAt(i) >= 97 && nom.charAt(i) <= 122) ){ //Si no és una lletra
                    if (nom.charAt(i) != '_' && nom.charAt(i) != '.'){ // Si no es '_'
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    public static boolean esNomPuzleValid(String nomFitxer){
        
        String nom = nomFitxer.toLowerCase();
        if (nom.isBlank()) return false;

        for (int i = 0; i < nom.length(); i++){ 
            if (!Character.isDigit(nom.charAt(i))){  //Si no és un número
                if (!  (nom.charAt(i) >= 97 && nom.charAt(i) <= 122) ){ //Si no és una lletra
                    if (nom.charAt(i) != '_' && nom.charAt(i) != '.'){ // Si no es '_'
                        return false;
                    }
                }
            }
        }
        return true; 
        
    }

    public static String extreuNomPuzleDeNomFitxer(String nom){
    
        String nomFitxer = nom.substring(6, nom.length()-4);
        return nomFitxer;
    }
    public static void mostraLlista(){
            
        File carpeta = new File(".");
        String[] continguts = carpeta.list();
        Arrays.sort(continguts);           // Ordena els fitxers per ordre alfabetic
        for(String fitxer: continguts){
            boolean nomFitxerValid = esNomFitxerDePuzleValid(fitxer);
            if (nomFitxerValid){
                String nomSortida = extreuNomPuzleDeNomFitxer(fitxer);
                boolean nomValid = esNomPuzleValid(nomSortida);
                if (nomValid){
                    System.out.println(nomSortida);
                }
            }
        }  
            
    }
    public static String readLine() throws RuntimeException {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
