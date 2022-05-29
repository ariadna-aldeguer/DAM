import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class Puzle {

	public static void main(String[] args) {
		mostraBenvinguda();
        while (true) {
            mostraPrompt();
            Scanner s = new Scanner(System.in);
            String comanda = s.next().strip();
            if (comanda.isEmpty()) continue;
            if (comanda.equals("quit")) break;
            if (comanda.equals("help")) {
                mostraAjuda();
                continue;
            }
            if(comanda.equals("ls")){
                File carpeta = new File(".");
                String[] continguts = carpeta.list();
                Arrays.sort(continguts);           // Ordena els fitxers per ordre alfabetic
                for(String fitxer: continguts){
                    boolean nomFitxerValid = esNomFitxerDePuzleValid(fitxer);
                    if(nomFitxerValid){
                        boolean nomValid = esNomPuzleValid(fitxer);
                        if (nomValid){
                            String nomSortida = extreuNomPuzleDeNomFitxer(fitxer);
                            mostraL	lista(nomSortida);
                        }
                    }
                }     
            } else {
                mostraErrorComandaDesconeguda();
            }
        }
        mostraComiat();
    }
    public static void mostraBenvinguda(){
    
        System.out.println("Gestor de puzles d'escacs. Escriviu help per ajuda.");
    
    }
    public static void mostraPrompt(){
    
        System.out.print("puzle> ");
    
    }
    public static void mostraAjuda(){
    
        System.out.println("Comandes disponibles:");
        System.out.println("help");
        System.out.println("dup «nom1» «nom2»");
        System.out.println("add «nom» «figura» «fila» «columna»");
        System.out.println("del «nom» «fila» «columna»");
        System.out.println("mv »nom» «fila0» «columna0» «fila1» «columna1»");
        System.out.println("new «nom»");
        System.out.println("rm «nom»");
        System.out.println("quit");
    
    }
    public static void mostraErrorComandaDesconeguda(){
        
        System.out.println("ERROR: comanda no reconeguda. Escriviu help per ajuda.");
    }
    public static void mostraComiat(){
    
        System.out.println("adèu");
    
    }
    public static boolean esNomFitxerDePuzleValid(String nom){
    
        if (!nom.substring(0,6).equals("puzle_")) return false;
        if (!nom.substring(nom.length()-4,nom.length()).equals(".txt")) return false;
              
        boolean nomPuzleValid = esNomPuzleValid(nom);
        if (!nomPuzleValid) return false;
        
        return true;
    }
    public static boolean esNomPuzleValid(String nomFitxer){
       
        String minuscules = nomFitxer.toLowerCase();
       
        for (int i = 0; i < nomFitxer.length(); i++){
            
            if (!Character.isDigit(minuscules.charAt(i))){  //Si no és un número
                if (minuscules.charAt(i) > 97 && minuscules.charAt(i) < 122){ //Si no és una lletra
                    if (minuscules.charAt(i) != '_'){ // Si no es '_'
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
    public static void mostraLlista(String nomSortida){
            
            System.out.println(nomSortida);
            
    }

}
