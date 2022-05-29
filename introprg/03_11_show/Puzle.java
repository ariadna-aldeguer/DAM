/* Puzle: Funcio show.
 * Mostrar el puzle del nom del fitxer demanat. 
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
            String resposta = readLine().strip();
            if (resposta.isEmpty()) continue;
            String[] elementsComanda = resposta.split("\\s+");
            String comanda = elementsComanda[0];
            if (comanda.equals("quit")) break;
            switch (comanda) {
                case "help": mostraAjuda();
                             break;
                case "ls": mostraLlista();
                           break;
                case "show": processaShow(elementsComanda);
                             break;
                default: mostraErrorComandaDesconeguda();
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
        System.out.println("dup «nom1» «nom2»");
        System.out.println("add «nom» «figura» «fila» «columna»");
        System.out.println("del «nom» «fila» «columna»");
        System.out.println("mv »nom» «fila0» «columna0» «fila1» «columna1»");
        System.out.println("new «nom»");
        System.out.println("ls");
        System.out.println("show «nom»");
        System.out.println("quit");
    
    }
    /**
     * Processa la comanda ls
     * @param: cap
     */
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
    /**
     * Comprova que el nom del Fitxer compleix estructura puzle_ .txt
     * @param: String nom del Fitxer
     */
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
    /**
     * Extreu el nom del puzle
     * @param: nomFitxer:  nom del Fitxer
     */
    public static String extreuNomPuzleDeNomFitxer(String nomFitxer){
    
        String nomPuzle = nomFitxer.substring(6, nomFitxer.length()-4);
        return nomPuzle;
    }

    /**
     * Comprova que el nom del Puzle es valid.
     * @param: nomPuzle:  nom del puzle(sense puzle_ .txt)
     */
    public static boolean esNomPuzleValid(String nomPuzle){
        
        String nom = nomPuzle.toLowerCase();
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
    /**
     * Processa la comanda show
     * @param args: arguments de la comanda
     */
    public static void processaShow(String[] args) throws IOException {
        if (args.length != 2) {
            mostraErrorComandaShow();
            return;
        }
        String nomPuzle = args[1];
        if (! esNomPuzleValid(nomPuzle)) {
            mostraErrorNomPuzleNoValid();
            return;
        }
        if (! existeixPuzle(nomPuzle)) {
            mostraErrorPuzleDesconegut();
            return;
        }
        char[][] taulell = llegeixPuzle(nomPuzle);
        Escacs.mostraTaulell(taulell);
    }
     /**
     * Donat un nom de puzle, retorna un String amb el nom del fitxer corresponen al puzle
     * @param nomPuzle: nom del Puzle
     */
    public static String composaNomFitxerDeNomPuzle(String nomPuzle){
        String nomFitxer = "puzle_" + nomPuzle + ".txt";
        return nomFitxer;
    }
    /**
     * Comprova si existeix el puzle
     * @param nomPuzle: nom del Puzle
     */
    public static boolean existeixPuzle(String nomPuzle){
        
        String nomFitxer = composaNomFitxerDeNomPuzle(nomPuzle);

        File carpeta = new File(".");
        String[] continguts = carpeta.list();

        for(String fitxer: continguts){
            if(fitxer.equals(nomFitxer)) return true;
        } 
        return false;
    }

    /**
     * Llegeix el puzle i crea un char[][] amb el contingut
     * @param nomPuzle: nom del Puzle
     */
    public static char[][] llegeixPuzle(String nomPuzle) throws IOException {
        
        String nomFitxer = composaNomFitxerDeNomPuzle(nomPuzle); 

        FileReader fileReader = new FileReader(nomFitxer);
        BufferedReader entrada = new BufferedReader(fileReader);
        char[][] taulell = new char[8][8];

        String linia;
        for(int i = 0; i < taulell.length; i++){
            linia = entrada.readLine();
                if(linia == null) break;
                for(int j = 0; j < linia.length(); j++){
                    taulell[i][j] = linia.charAt(j);
                }
        }
        
        entrada.close();
        return taulell;
    }
    /**
     * Donat un char[][] el mostra 
     * @param taulell: array de chars
     */
    public static void mostraTaulell(char[][] taulell){
        for(int i = 0; i < taulell.length; i++){
            for(int j = 0; j < taulell.length; j++){
                System.out.print(taulell[i][j]);    
            }
            System.out.println();
        }  
    }

    public static void mostraErrorComandaShow(){
        System.out.println("ERROR: show «nom»");
    }
    public static void mostraErrorNomPuzleNoValid(){
        System.out.println("ERROR: nom no vàlid");
    }
    public static void mostraErrorPuzleDesconegut(){
        System.out.println("ERROR: puzle desconegut");
    }
    public static void mostraErrorComandaDesconeguda(){
        
        System.out.println("ERROR: comanda no reconeguda. Escriviu help per ajuda.");
    }
    public static void mostraComiat(){
    
        System.out.println("adèu");
    }

    public static String readLine() throws RuntimeException {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

