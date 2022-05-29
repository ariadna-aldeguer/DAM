/* Aquesta clase s'utilitzara per accedir a la botiga i als vins */ 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Entorn {
    private final Botiga botiga = new Botiga();
    private static final String NOM_BASE_DE_DADES = "botiga.bd";
    private static final String CADENA_DE_CONNEXIO = "jdbc:sqlite:" +
                                                     NOM_BASE_DE_DADES;

    private Connection conn = null;
    private List<Vi> afegits = new ArrayList<Vi>();
    private List<Vi> modificats = new ArrayList<Vi>();
    private List<Vi> eliminats = new ArrayList<Vi>();

    public static void main(String[] args) throws SQLException{
        Entorn entorn = new Entorn();
        entorn.connecta();
        mostraBenvinguda();
        entorn.carregaVins();
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
        entorn.guardaVins();
        mostraComiat();
        entorn.desconnecta();
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
            afegits.add(vi);
            System.out.print("Introduït:");
            mostraVi(vi);
        }  
    }
    // Comanda "cerca" --> permet cercar un vi a la botiga.
    public void processaCerca(){
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
        System.out.println("Modificat:");
        mostraVi(vi);   
        modificats.add(vi);
         
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
                eliminats.add(vi);
            }
        } else {
            System.out.println("No eliminat");
        }
  
    }
    
    /* Crea una taula Vins si no existeix,
     * Recupera els vins de la bdd i retorna quants s'han afegit */
    public void carregaVins() throws SQLException{        
    
        creaTaulaVinsBd();
        int contador = recuperaVinsBd();
        System.out.println("Referències llegides: " + contador);

    }

    /* Crea la taula VINS */
    public void creaTaulaVinsBd() throws SQLException {
        
        String sql = "CREATE TABLE IF NOT EXISTS VINS(" + 
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nom VARCHAR(40), " +
                    "preu INTEGER, " +
                    "estoc INTEGER)";
        
        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
        } finally {
            if (st != null) {
                st.close();
            }
        }
        
    }

    /* Afegeix de la BD els VINS i els afegeix al array,
     *  retorna quants vins ha afegit */
    public int recuperaVinsBd() throws SQLException {
        String sql = "SELECT * FROM VINS ORDER BY nom";
        Statement st = null;
        int contador = 0;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                int idBd = rs.getInt("id");
                String nomBd = rs.getString("nom");
                int preuBd = rs.getInt("preu");
                int estocBd = rs.getInt("estoc");
                Vi vi = new Vi(idBd, nomBd, preuBd, estocBd);
                if (botiga.afegeix(vi) == null) { continue; } // es podria posar un if per si peta
                contador++;
            }
            rs.close();
            return contador;
        } finally {
            if (st != null) { st.close(); }
        }
    }

    /* Elimina Taula VINS de la BD */
    public void eliminaTaulaVinsBd() throws SQLException {
       
        String sql = String.format("DROP TABLE IF EXISTS VINS");

        Statement st = null;
        
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
        } finally {
            if (st != null) {
                st.close();
            }
        }

    }
        /* Guarda els vins nous, modificats i eliminats a la BD*/
    public void guardaVins() throws SQLException{
        int contador = 0;
        contador = insertarBdNousVins();
        contador += modificarBdVinsModificats();
        contador += eliminarBdVinsEliminats();
        System.out.println("Referències guardades: " + contador);
    }

    /* Inserta els vins afegits a la llista afegits a la BD*/
    public int insertarBdNousVins() throws SQLException {
        
        int contador = 0;
        for(Vi vi: afegits){

            String sql = String.format("INSERT INTO VINS (nom, preu, estoc) VALUES ('%s', %d, %d)", vi.getNom(), vi.getPreu(), vi.getEstoc());
            Statement st = null;
            try {
                st = conn.createStatement();
                st.executeUpdate(sql);
                contador++;
            } finally {
                if (st != null) {
                    st.close();
                }
            }
        }
        return contador;
    }
    /* Modifica els vins afegits a modificats a la BD*/
    public int modificarBdVinsModificats() throws SQLException {
        int contador = 0;
        for(Vi vi: modificats){

            String sqlPreu = String.format("UPDATE VINS SET preu = %d WHERE id = %d", vi.getPreu(), vi.getId());
            String sqlEstoc = String.format("UPDATE VINS SET estoc = %d WHERE id = %d", vi.getEstoc(), vi.getId());
            Statement st = null;

            try{
                st = conn.createStatement();
                st.executeUpdate(sqlPreu);
                st.executeUpdate(sqlEstoc);
                contador++;

            } finally {
                if (st != null) {
                    st.close();
                }
            }
        }
        return contador;
    }
    /* Elimina els vins afegits a eliminats a la BD*/
    public int eliminarBdVinsEliminats() throws SQLException {
        int contador = 0;
        for(Vi vi: eliminats){
            
            String sql = String.format("DELETE FROM VINS WHERE id = %d", vi.getId());
            Statement st = null;
            
            try {
                st = conn.createStatement();
                st.executeUpdate(sql);
                contador++;
            } finally {
                if (st != null) {
                    st.close();
                }
            }
        }
        return contador;
    }

    /* Connecta a la BD */
    public void connecta() throws SQLException {
        if (conn != null) return;  
        conn = DriverManager.getConnection(CADENA_DE_CONNEXIO);
    }

    /* Desconecta de la BD */
    public void desconnecta() throws SQLException {
        if (conn == null) return; 
        conn.close();
        conn = null;
    }
}