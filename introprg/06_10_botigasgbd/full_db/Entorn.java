/* Aquesta clase s'utilitzara per accedir a la botiga i als vins */ 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;


public class Entorn {
    private final Botiga botiga = new Botiga();

    public static void main(String[] args) throws SQLException{
        Entorn entorn = new Entorn();
        entorn.botiga.connecta();
        entorn.botiga.creaTaulaVins();
        mostraBenvinguda();
        entorn.botiga.mostraReferenciesLlegides();
        while (true) {
            mostraPrompt();
            String comanda = Entrada.readLine().strip();
            if (comanda.isEmpty()) continue;
            if (comanda.equals("surt")) break;
            switch (comanda) {
                case "ajuda": mostraAjuda();
                             break;
                case "afegeix": entorn.processaAfegeix();
                           break;
                
                case "cerca": entorn.processaCerca();
                             break;
                case "modifica": entorn.processaModifica();
                            break;
                case "elimina": entorn.processaElimina();
                           break;
                default: mostraErrorComandaDesconeguda();
            }
        }
        mostraComiat();
        entorn.botiga.mostraReferenciesGuardades();
        entorn.botiga.desconnecta();
    }
    
    
    // Missatge de benvinguda
    public static void mostraBenvinguda(){
        System.out.println("Celler La Bona Estrella. Escriviu ajuda per veure opcions.");
    }
    
    // Missatge de comiat
    public static void mostraComiat(){
        System.out.println("adéu");
    }
    
    // Prompt botiga>
    public static void mostraPrompt(){
        System.out.print("botiga> ");
    }
    
    // Comanda "ajuda"
    public static void mostraAjuda(){
        System.out.printf("Comandes disponibles:%najuda%ncerca%nafegeix%nmodifica%nelimina%nsurt%n");  
    }
    
    // Mostra vi
    public void mostraVi(Vi vi){
        System.out.println(vi.toString());
    }
    
    // Demana "nom"
    public static void quinNom(){
        System.out.print("nom (enter cancel·la)> ");
    }
    // Demana "preu"
    public static void quinPreu(){
        System.out.print("preu (en cèntims)> ");
    }
    // Demana "estoc"
    public static void quinEstoc(){
        System.out.print("estoc (enter sense estoc)> ");
    }
    
    // Demana "preu" mostrant el preu
    public void quinPreuAmbPreu(Vi vi){
        System.out.print("preu (enter " + vi.getPreu() + ")> ");
    }
    
    // Demana "estoc" mostrant el estoc actual
    public void quinEstocAmbEstoc(Vi vi){
        System.out.print("estoc (enter " + vi.getEstoc() + ")> ");
    }
    
    // Comprova número i dona error
    public static boolean esNumero(String numero){
        if (! UtilString.esEnter(numero)) {
            System.out.println("ERROR: el valor ha de ser un enter positiu");
            return false;
        } 
        return true;
    }
    

    // Error comanda desconeguda
    public static void mostraErrorComandaDesconeguda(){
        System.out.println("ERROR: comanda no reconeguda. Escriviu help per ajuda");
    }
    
    //Error no s'ha pogut afegir
    public static void mostraErrorNoAfegit(){
        System.out.println("ERROR: no s'ha pogut afegir");
    }
    
    //Error no s'ha trobat el vi
    public static void mostraErrorViNoTrobat(){
        System.out.println("No trobat");
    }
    
    
    
    // Comanda "afegeix" --> Crea un vi i l'afegeix a botiga
    public void processaAfegeix() throws SQLException {
        
        // Demana nom i comprovacions
        quinNom();
        String nom = Entrada.readLine().strip();
        if (nom.isBlank()) { return; }
        
        // Demana preu i fa comprovacions
        quinPreu();
        String preu = Entrada.readLine().strip();
        int numPreu;
        if (preu.isBlank()) { preu = "0"; }
        if (! esNumero(preu)) { 
            return; 
        } 
        numPreu = Integer.parseInt(preu);
        if (numPreu < 0) { 
            System.out.println("ERROR: el valor ha de ser un enter positiu");
            return; 
        }
        
        // Demana estoc i fa comprovacions
        quinEstoc();
        String estoc = Entrada.readLine().strip();
        int numEstoc;
        if (estoc.isBlank()) { estoc = "0"; } 
        if ( ! esNumero(estoc)) { 
            return; 
        } 
        numEstoc = Integer.parseInt(estoc);
        if (numEstoc < 0) { 
            System.out.println("ERROR: el valor ha de ser un enter positiu");
            return; 
        } 
        
        // Crea el vi
        Vi vi = new Vi(nom, numPreu, numEstoc);
        
        // Afegim el vi a la botiga
        if (botiga.afegeix(vi) == null) { 
            mostraErrorNoAfegit(); 
        } else {
            System.out.print("Introduït:");
            mostraVi(vi);
        }  
    }
    // Comanda "cerca" --> permet cercar un vi a la botiga.
    public void processaCerca() throws SQLException {
        // Demana el nom
        quinNom();
        String nom = Entrada.readLine().strip();
        if (nom.isBlank()) { return; }
        
        // Busca si existeix el vi --> Si: imprimeix/No: retorna no trobat.
        if (botiga.cerca(nom) == null){
            mostraErrorViNoTrobat();
        } else {
           System.out.println("Trobat:");
           System.out.println(botiga.cerca(nom).toString());
        }
        
    }
    
    // Comanda "modifica"  --> permet modificar les dades d'un vi
    public void processaModifica() throws SQLException{
        quinNom();
        String nom = Entrada.readLine().strip();
        if (nom.isBlank()) { return; }
        Vi vi = botiga.cerca(nom);
        if (vi == null) {
            mostraErrorViNoTrobat();
            return; 
         }
          // Demana preu i fa comprovacions
        quinPreuAmbPreu(vi);
        String preu = Entrada.readLine().strip();
        int numPreu;
        if (preu.isBlank()) { preu = "0"; }
        if (! esNumero(preu)) { 
            return; 
        } 
        numPreu = Integer.parseInt(preu);
        if (numPreu < 0) { 
            System.out.println("ERROR: el valor ha de ser un enter positiu");
            return; 
        }
        
        // Demana estoc i fa comprovacions
        quinEstocAmbEstoc(vi);
        String estoc = Entrada.readLine().strip();
        int numEstoc;
        if (estoc.isBlank()) { 
            numEstoc = vi.getEstoc(); 
        }else if ( ! esNumero(estoc)) { 
            return; 
        }else{
            numEstoc = Integer.parseInt(estoc);   
        }
        if (numEstoc < 0) { 
            System.out.println("ERROR: el valor ha de ser un enter positiu");
            return; 
        } 
        
        vi.setPreu(numPreu);
        vi.setEstoc(numEstoc);
        botiga.modifica(vi);
        System.out.println("Modificat:");
        mostraVi(vi);   
         
    }
    
    // Comanda "elimina" --> Elimina un vi
    public void processaElimina() throws SQLException{
        
        // Demana nom
        quinNom();
        String nom = Entrada.readLine().strip();
        Vi vi = botiga.cerca(nom);
        if (nom.isBlank()) { return; } 
        if (botiga.cerca(nom) == null) {
            mostraErrorViNoTrobat(); 
            return;
        } 
        System.out.println("A eliminar:");
        mostraVi(vi);
        System.out.print("Segur?> ");
        String resposta = Entrada.readLine();
        boolean confirmacio = UtilString.respostaABoolean(resposta);
        if (confirmacio){
            vi = botiga.elimina(vi);
            if (vi == null){
                System.out.println("ERROR: no s'ha pogut eliminar");
            } else {
                System.out.println("Eliminat");
            }
        } else {
            System.out.println("No eliminat");
        }
    }
}