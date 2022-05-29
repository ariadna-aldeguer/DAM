/* Puzle: Funcio moure figura.
 * Mourá una figura a un puzle donada la posicio d'origen i de destí
 * sempre que no estigui ocupada. 
 */

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
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
                case "new": processaNew(elementsComanda); 
                            break;
                case "cp": processaCp(elementsComanda);
                           break;
                case "add": processaAdd(elementsComanda);
                            break;
                case "mv": processaMv(elementsComanda);
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
        System.out.println("cp «nom1» «nom2»");
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
        for(int i = taulell.length-1; i >= 0; i--){
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
        for(int i = taulell.length-1; i >= 0; i--){
            for(int j = 0; j < taulell.length; j++){
                System.out.print(taulell[i][j]);    
            }
            System.out.println();
        }  
    }
    
     /**
     * Processa la comanda new
     * @param args: arguments de la comanda
     */
    public static void processaNew(String[] args) throws IOException{
        
        if (args.length != 2) {
            mostraErrorComandaNew();
            return;
        }   
        
        String nomPuzle = args[1];
        if (! esNomPuzleValid(nomPuzle)) {
            mostraErrorNomPuzleNoValid();
            return;
        }
           
        char[][] taulell = Escacs.creaTaulellBuit();   
            
        if (existeixPuzle(args[1])){
            System.out.println("Ja existeix. El sobreescrivim?");
            String resposta = readLine();
            if (! UtilitatsConfirmacio.respostaABoolean(resposta)){
                return;
            }
        }
        
        escriuPuzle(args[1], taulell);

    }
    /**
     * Escriu un puzzle (Existint el fitxer o no)
     * @param nomPuzle, taulell: el nom del puzle a crear i el seu contingut
     */
    public static void escriuPuzle(String nomPuzle, char[][] taulell) throws IOException{
        
        String cami = "puzle_"+nomPuzle+".txt";
        BufferedWriter sortida = new BufferedWriter(new FileWriter(cami));
        
        for(int i = taulell.length-1; i >= 0; i--){
            for (int j= 0; j<taulell.length; j++){
                sortida.write(taulell[i][j]);
            }
            sortida.write("\n");
        }
        sortida.close();
        System.out.println("fet");    
    }
     /**
     * Duplica un puzzle
     * @param args: arguments de la comanda
     */
    public static void processaCp(String[] args) throws IOException{
        
        if (args.length != 3) {
            mostraErrorComandaCp();
            return;
        }
        
        if (!existeixPuzle(args[1])) {
            mostraErrorPuzleDesconegut();
            return;
        }
        
        if (! esNomPuzleValid(args[2])) {
            mostraErrorNomPuzleNoValid();
            return;
        }
        
        if (existeixPuzle(args[2])){
            System.out.println("Ja existeix. El sobreescrivim?");
            String resposta = readLine();
            if (! UtilitatsConfirmacio.respostaABoolean(resposta)){
                return;
            }
        }
        
        duplicaPuzle(args[1], args[2]);     
    }
     /**
     * Donat dos noms, crea o sobreescriu el segon amb el contingut del primer
     * @param nomOrigen, nomDuplicar: noms dels fitxers ha duplicar
     */  
    public static void duplicaPuzle(String nomOrigen, String nomDuplicar) throws IOException{
        
        String camiOrigen = String.format("puzle_%s.txt", nomOrigen);
        String camiDesti = String.format("puzle_%s.txt", nomDuplicar);
        
        BufferedReader entrada = new BufferedReader(new FileReader(camiOrigen));
        BufferedWriter sortida = new BufferedWriter(new FileWriter(camiDesti));
        
        while(true){
            String linia = entrada.readLine();
            if (linia == null) break;
            sortida.write(linia+"\n");
        }
        entrada.close();
        sortida.close();
        System.out.println("fet");
        
    }
     /**
     * Processa la comanda add
     * @param: args: arguments de la comanda
     */
    public static void processaAdd(String[] args) throws IOException{
        
        if(args.length != 5){
            mostraErrorComandaAdd();
            return;
        }
        
        if (!existeixPuzle(args[1])) {
            mostraErrorPuzleDesconegut();
            return;
        }
        
        char figura = args[4].charAt(0);
        if (! Escacs.esFiguraValida(figura)){
            mostraErrorFiguraNoValida();
            return;
        }
        if (! UtilString.esEnter(args[2]) || ! UtilString.esEnter(args[3])) {
            mostraErrorValorNoEnter();
            return;
        }
        
        int fila = Integer.parseInt(String.valueOf(args[2]));
        int columna = Integer.parseInt(String.valueOf(args[3]));
        char[][] taulell = llegeixPuzle(args[1]);
        if (Escacs.posicionaFigura(taulell, fila, columna, figura)){
            escriuPuzle(args[1], taulell);
            return;
        } else {
            mostraErrorNoPosiciona();
            return;
        }

    }/**
     * Processa la comanda move
     * @param: args: arguments de la comanda
     */
    public static void processaMv(String[] args) throws IOException{
        
        //mv[0] «nom»[1] «fila0»[2] «columna0»[3] «fila1»[4] «columna1»[5]
        
        if(args.length != 6){
            mostraErrorComandaMv();
            return;
        }
        if (!existeixPuzle(args[1])) {
            mostraErrorPuzleDesconegut();
            return;
        }
        if (! UtilString.esEnter(args[2]) || ! UtilString.esEnter(args[3])
        || ! UtilString.esEnter(args[4]) || ! UtilString.esEnter(args[5]) )  {
            mostraErrorValorNoEnter();
            return;
        }

        int filaOrigen = Integer.parseInt(String.valueOf(args[2]));
        int columnaOrigen = Integer.parseInt(String.valueOf(args[3]));
        int filaDesti = Integer.parseInt(String.valueOf(args[4]));
        int columnaDesti = Integer.parseInt(String.valueOf(args[5]));
        char[][] taulell = llegeixPuzle(args[1]);
        
        if (Escacs.mouFigura(taulell, filaOrigen, columnaOrigen, filaDesti, columnaDesti)){
            escriuPuzle(args[1], taulell);
            return;
        } else {
            mostraErrorPosicioNoMoure();
            return;
        }
    }
    
    
    public static void mostraErrorPosicioNoMoure(){
        System.out.println("ERROR: no es pot moure");
    }
    
    public static void mostraErrorNoPosiciona(){
        System.out.println("ERROR: no es pot posicionar");
    }
    public static void mostraErrorValorNoEnter(){
        System.out.println("ERROR: files i columnes han de ser valors enters");
    }   
    public static void mostraErrorFiguraNoValida(){
        System.out.println("ERROR: figura no vàlida");
    }
    public static void mostraErrorComandaMv(){
        System.out.println("ERROR: mv «nom» «fila0» «columna0» «fila1» «columna1»");
    } 
    public static void mostraErrorComandaAdd(){
        System.out.println("ERROR: add «nom» «fila» «columna» «figura»");
    }
    public static void mostraErrorComandaCp(){
        System.out.println("ERROR: cp «nom1» «nom2»");
    }
    public static void mostraErrorComandaNew(){
        System.out.println("ERROR: new «nom»");
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

