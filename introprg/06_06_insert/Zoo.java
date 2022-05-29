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
import java.util.ArrayList;

public class Zoo {
    private static final String NOM_BASE_DE_DADES = "animals.bd";
    private static final String CADENA_DE_CONNEXIO = "jdbc:sqlite:" +
                                                    NOM_BASE_DE_DADES +
                                                    "?integrity_check&foreign_key_check";
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
        eliminaTaulaAnimals();
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
    public String creaTaulaAnimals() throws SQLException {
        
        if(!getNomTaules().contains("CATEGORIES")){
            creaTaulaCategories();
        }
        String sql = "CREATE TABLE IF NOT EXISTS ANIMALS(" + 
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nom VARCHAR(40)," +
                    "categoria INTEGER, " +
                    "FOREIGN KEY(categoria) REFERENCES CATEGORIES(id))";
        
        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
            return "Creem la taula ANIMALS";
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }
    public void eliminaTaulaCategories() throws SQLException {
        if(getNomTaules().contains("ANIMALS")){
            eliminaTaulaAnimals();
        }
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
    public void eliminaTaulaAnimals() throws SQLException {
        String sql = "DROP TABLE IF EXISTS ANIMALS";
        
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
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            categoria.setId(id);
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }

    public void afegeixAnimal(Animal animal) throws SQLException {
        Categoria categoria;
        if(animal.idIndefinit()){
            return;
        }
        int codi = -1;
        if(null == obteCategoriaPerNom(animal.getCategoria().getNom())){
            categoria = animal.getCategoria();
            afegeixCategoria(categoria);
            codi = categoria.getId();

        } else {
            animal.setId(obteCategoriaPerNom(animal.getCategoria().getNom()).getId());
        }
        

        String sql = String.format("INSERT INTO ANIMALS (nom, categoria) VALUES ('%s', %d)", animal.getNom(), codi);

        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            animal.setId(id);
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
    /* retorna el nom de les taules definides a la bd */
    public String getNomTaules() throws SQLException {
        String sql = "SELECT name FROM sqlite_schema " +
                    "WHERE name NOT LIKE 'sqlite%' " +
                    "ORDER BY name";
        List<String> taules = new ArrayList<>();
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) { taules.add(rs.getString("name")); }
            rs.close();
        }
        return taules.size() > 0 ? String.join(", ", taules) : "cap";
    }
}
