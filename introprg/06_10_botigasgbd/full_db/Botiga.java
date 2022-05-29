import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/* Class Botiga */

public class Botiga {
    private int numVi;
    private static final String NOM_BASE_DE_DADES = "botiga.bd";
    private static final String CADENA_DE_CONNEXIO = "jdbc:sqlite:" +
                                                     NOM_BASE_DE_DADES;
    private Connection conn = null;
   
    public Botiga(){
    } 

    public void creaTaulaVins() throws SQLException {
        
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

    /* Afegeix vi
    * Comprova que no hi hagi vi amb el mateix nom
    * Si hi ha, no fa res (retorna null)
    * Afegira el vi a la BD
    * Retornara el vi introduït
    */
    public Vi afegeix(Vi vi) throws SQLException {

        if(cerca(vi.getNom()) != null){
            return null;
        }
        String sql = String.format("INSERT INTO VINS (nom) VALUES ('%s')", vi.getNom());
        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            vi.setId(id);
            return vi;
        } finally {
            if (st != null) {
                st.close();
            }
        }
        
    }

    /* Modifica un vi */
    public Vi modifica(Vi vi) throws SQLException {
        canviarEstocViBd(vi);
        canviarPreuViBd(vi);
        return vi;
    }
    
    public void canviarEstocViBd(Vi vi) throws SQLException{

        if(vi.idIndefinit()){
            return;
        }
        
        String sql = String.format("UPDATE VINS SET estoc = %d WHERE id = %d", vi.getEstoc(), vi.getId());
        Statement st = null;

        try{
            st = conn.createStatement();
            st.executeUpdate(sql);

        } finally {
            if (st != null) {
                st.close();
            }
        }
    }
    public void canviarPreuViBd(Vi vi) throws SQLException{

        if(vi.idIndefinit()){
            return;
        }

        String sql = String.format("UPDATE VINS SET preu = %d WHERE id = %d", vi.getPreu(), vi.getId());
        Statement st = null;

        try{
            st = conn.createStatement();
            st.executeUpdate(sql);

        } finally {
            if (st != null) {
                st.close();
            }
        }
    }

    /* Busca el vi 
     * --> si no existeix: retorna null
     * --> si té més estoc que 1: retorna null
     * --> si no té id: retorna null
     * Finalment, elimina */
    public Vi elimina(Vi vi) throws SQLException {
       
        if(cerca(vi.getNom()) == null){
            return null;
        }  
        if(vi.getEstoc() > 1){
            return null;
        }
        if(vi.idIndefinit()){
            return null;
        }
        String sql = String.format("DELETE FROM VINS WHERE id = %d", vi.getId());
        Statement st = null;
        
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
        } finally {
            if (st != null) {
                st.close();
            }
        }
        return vi; 
    }
      
    /* Si troba el vi, retorna el vi
     * Cas contrari, torna null */
    public Vi cerca(String nom) throws SQLException {
        
        String nombre = Vi.normalitzaNom(nom);

        String sql = String.format("SELECT id FROM VINS WHERE nom = '%s' ORDER BY id LIMIT 1", nombre);
        Statement st = null;

        try{
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Vi vi = null;
            while(rs.next()){
                int bdId = rs.getInt("id");
                vi = new Vi(bdId, nom);
                return vi;
            }
            return null;
        } finally {
            if (conn != null) { st.close(); }
        }
    }
    
    /* Retorna tots els vins que hi ha a la Bd*/
    public ArrayList<Vi> recuperaVins() throws SQLException {
        String sql = "SELECT * FROM VINS ORDER BY nom";
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList <Vi> vins = new ArrayList<Vi>();
            while (rs.next()){
                int idBd = rs.getInt("id");
                String nomBd = rs.getString("nom");
                int preuBd = rs.getInt("preu");
                int estocBd = rs.getInt("estoc");
                Vi vi = new Vi(idBd, nomBd, preuBd, estocBd);
                vins.add(vi);

            }
            rs.close();
            return vins;
        } finally {
            if (st != null) { st.close(); }
        }
    }

    /* Elimina la Taula vins de la BD */
    public void eliminaTaulaVins() throws SQLException {
       
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

    public void iniciaRecorregut(){
        numVi = 0;
    }

    public Vi getSeguent()  throws SQLException {
        
        String sql = String.format("SELECT * FROM VINS WHERE id = '%d'", numVi);
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                int bdId = rs.getInt("id");
                String bdNom = rs.getString("nom");
                int bdPreu = rs.getInt("preu");
                int bdEstoc = rs.getInt("estoc");
                Vi vi = new Vi(bdId, bdNom, bdPreu, bdEstoc);
                numVi++;
                return vi;
            }
            rs.close();
            return null;
        } finally {
            if (st != null) { st.close(); }
        }
        
    }

    public void mostraReferenciesLlegides() throws SQLException {
        String sql = String.format("SELECT count(*) as total FROM VINS");
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                int total = rs.getInt("total");
                rs.close();
                System.out.println("Referencies llegides: " + total);
            }
        } finally {
            if (st != null) { st.close(); }
        }   
    }
    public void mostraReferenciesGuardades() throws SQLException {
        String sql = String.format("SELECT count(*) as total FROM VINS");
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                int total = rs.getInt("total");
                rs.close();
                System.out.println("Referencies guardades: " + total);
            }
        } finally {
            if (st != null) { st.close(); }
        }   
    }

    public void connecta() throws SQLException {
        if (conn != null) return;  
        conn = DriverManager.getConnection(CADENA_DE_CONNEXIO);
    }

    public void desconnecta() throws SQLException {
        if (conn == null) return; 
        conn.close();
        conn = null;
    }    
}