/* Classe zoo: fara d'intermediari 
* És la classe per conectar-se a la bdd 
*/

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class Zoo {
    private static final String NOM_BASE_DE_DADES = "animals.bd";
    private static final String CADENA_DE_CONNEXIO = "jdbc:sqlite:" +
                                                     NOM_BASE_DE_DADES;
    private Connection conn = null;

    public String connecta() throws SQLException {
        if (conn != null) return "Ja connectat";   // ja connectat
        conn = DriverManager.getConnection(CADENA_DE_CONNEXIO);
        return "connectat";
    }

    public String desconnecta() throws SQLException {
        if (conn == null) return "ja desconnectat"; // ja desconnectat
        conn.close();
        conn = null;
        return "desconnectat";
    }
    public String creaTaulaCategories() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS CATEGORIES(" + 
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nom VARCHAR(40))";
        
        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
            return "Creem la taula CATEGORIES";
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }
    public void eliminaTaulaCategories() throws SQLException {
        String sql = "DROP TABLE IF EXISTS CATEGORIES";
        
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
    public void afegeixCategoria(Categoria categoria) throws SQLException {
        String sql = String.format("INSERT INTO CATEGORIES (nom) VALUES ('%s')", categoria.getNom());

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

    public List <Categoria> recuperaCategories() throws SQLException {
        String sql = "SELECT * FROM CATEGORIES ORDER BY nom";
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List <Categoria> categories = new LinkedList<>();
            while (rs.next()){
                int bdId = rs.getInt("id");
                String nom = rs.getString("nom");
                Categoria categoria = new Categoria(bdId, nom);
                categories.add(categoria);
            }
            rs.close();
            return categories;
        } finally {
            if (st != null) { st.close(); }
        }
    }

    public Categoria obteCategoriaPerNom(String nom) throws SQLException {
        String sql = String.format("SELECT id FROM CATEGORIES WHERE nom = '%s' ORDER BY id LIMIT 1", nom);
        Statement st = null;

        try{
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Categoria categoria = null;
            while(rs.next()){
                int bdId = rs.getInt("id");
                categoria = new Categoria(bdId, nom);
                return categoria;
            }
            return null;
        } finally {
            if (conn != null) { st.close(); }
        }
    }
}