/* Classe Animal: Un animal pertany a una 
 * categoria, tindra un nom i un id, i un número referencial a la categoria(bdd)
 */

public class Animal{
    private int id = -1;
    private String nom;
    private Categoria categoria;
    
    public Animal(String nom, Categoria categoria) {
        if (nom == null || nom.isBlank()){
            throw new IllegalArgumentException("El nom no pot ser null ni blanc");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("La categoria no pot ser null"); 
        }
        this.nom = nom;
        this.categoria = categoria;
        
    }
    public Animal(int id, String nom, Categoria categoria) {
        this(nom, categoria);
        if (id < 0) {
            throw new IllegalArgumentException("L'identificador ha de ser positiu");
        }
        this.id = id;
    }

    public boolean idIndefinit() { return id < 0; }

    public int getId(){
        if(idIndefinit()){
            throw new UnsupportedOperationException("L'identificador no està disponible");
        }
        return id;
    }
    public void setId(int id){
        if (id < 0) {
            throw new IllegalArgumentException("L'identificador ha de ser positiu");
        }
        this.id = id;
    }
    public String getNom(){
        return nom;
    }
    public Categoria getCategoria(){
        return categoria;
    }

    @Override
    public String toString(){
        return "Animal(id:" + (id < 0 ? "indefinit" : id) + ", " + nom + ", " + categoria +")";
    }
}