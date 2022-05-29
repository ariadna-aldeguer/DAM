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
                                                    NOM_BASE_DE_DADES;
                                                    // +
                                                    // "?integrity_check&foreign_key_check";
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
        int codi = -1;
        if(null == obteCategoriaPerNom(animal.getCategoria().getNom())){
            categoria = animal.getCategoria();
            afegeixCategoria(categoria);
            codi = categoria.getId();

        } else {
            codi = obteCategoriaPerNom(animal.getCategoria().getNom()).getId();
            animal.getCategoria().setId(obteCategoriaPerNom(animal.getCategoria().getNom()).getId());
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
    public List<Animal> recuperaAnimals() throws SQLException {
        String sql = "SELECT ANIMALS.id as id_animal, " +
                     "ANIMALS.nom as nom_animal, " + 
                     "CATEGORIES.nom as nom_categoria " +
                     "FROM ANIMALS, CATEGORIES " +
                     "WHERE ANIMALS.categoria = CATEGORIES.id " +
                     "ORDER BY ANIMALS.nom";
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List <Animal> animals = new LinkedList<Animal>();
            while (rs.next()){
                int idAnimal = rs.getInt("id_animal");
                String nomAnimal = rs.getString("nom_animal");
                String nomCategoria = rs.getString("nom_categoria");
                Categoria categoria = obteCategoriaPerNom(nomCategoria);
                Animal animal = new Animal(idAnimal, nomAnimal, categoria);
                animals.add(animal);
            }
            rs.close();
            return animals;
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

    public Animal obteAnimalPerNom(String nom) throws SQLException {
        String sql = String.format("SELECT ANIMALS.id as id_animal, CATEGORIES.nom as nom_categoria FROM ANIMALS, CATEGORIES WHERE ANIMALS.categoria = CATEGORIES.id AND ANIMALS.nom = '%s' ORDER BY ANIMALS.id LIMIT 1", nom);
        Statement st = null;

        try{
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Animal animal = null;
            while(rs.next()){
                int bdId = rs.getInt("id_animal");
                String nomCategoria = rs.getString("nom_categoria");
                Categoria categoria = obteCategoriaPerNom(nomCategoria);
                animal = new Animal(bdId, nom, categoria);
                return animal;
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

    public void canviaCategoria(Animal animal, Categoria categoria) throws SQLException{
        
        if(obteCategoriaPerNom(categoria.getNom()) != null){
            categoria.setId(obteCategoriaPerNom(categoria.getNom()).getId());
        }

        try {
            int idCategoria = categoria.getId();
            
        } catch (UnsupportedOperationException e){
            afegeixCategoria(categoria);
        }

        animal.setCategoria(obteCategoriaPerNom(categoria.getNom()));
        
        if (obteAnimalPerNom(animal.getNom()) == null){ //Si l'animal no esta a la base de dades
            afegeixAnimal(animal);
            return;
        }

        int idCategoria = animal.getCategoria().getId();
        int idAnimal = animal.getId();

        String sql = String.format("UPDATE ANIMALS SET categoria = %d WHERE id = %d", idCategoria, idAnimal);

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

    public void eliminaAnimal(Animal animal) throws SQLException {
        int codi = 0;

        try {
            codi = animal.getId();
        } catch (UnsupportedOperationException e){
            return;
        }
        boolean existeix = true;
        List<Animal> animals = recuperaAnimals();
        for (Animal a: animals){

            int idGat = a.getId();
            if (idGat == codi){
                existeix = true;
            }
        }

        if (!existeix){
            return;
        } 

        String sql = String.format("DELETE FROM ANIMALS WHERE id = %d", codi);

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
    public void eliminaCategoria(Categoria categoria) throws SQLException {
        int codi = 0;

        try {
            codi = categoria.getId();
        } catch (UnsupportedOperationException e){
            return;
        }

        boolean existeix = false;

        List <Categoria> categories = recuperaCategories();
        for (Categoria cat: categories) {
            int idCat = cat.getId();
            if (idCat == codi){
                existeix = true;
            }
        }

        if(!existeix){
            return;
        }

        List <Animal> animals = recuperaAnimals();
        for (Animal animal: animals){
            if (animal.getCategoria().getId() == codi){
                eliminaAnimal(animal);
            }
        }

        String sql = String.format("DELETE FROM CATEGORIES WHERE id = %d", codi);

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
    
}
