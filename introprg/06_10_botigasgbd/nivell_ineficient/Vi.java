/* Aquesta classe es una representació d'un Vi*/

public class Vi {
    private String nom;
    private int preu;   
    private int estoc;
    private int id = -1;
    
    public Vi (String nom, int preu){
        this(nom, preu, 0);
    }
    public Vi (String nom, int preu, int estoc){
        this.nom = normalitzaNom(nom);
        setPreu(preu);
        setEstoc(estoc);
    }

    public Vi (int id, String nom, int preu, int estoc){
        this(nom, preu, estoc);
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

    public String getNom() {  
        return nom;
    }    
    public int getPreu() {  
        return preu;
    }
    public int getEstoc() {  
        return estoc;
    }  
    
    
    // No pot ser negatiu 
    public void setPreu(int preu) { 
        if(preu > 0){
            this.preu = preu;
        }
    } 
    // No pot ser negatiu, si l'estoc no es vàlid serà 0
    public void setEstoc(int estoc) {
        if(estoc >= 0){
            this.estoc = estoc;
        } else {
            this.estoc = 0;
        }     
    } 
    
    /* Nom no pot ser espais en blanc o buit
     * No pot tenir espais ni davant ni darrere
     * No pot tenir més d'un espai entre paraules */     
    public static String normalitzaNom(String nom) {
        if(nom.isBlank()){
            return "nom no vàlid";
        }
        return nom.trim().replaceAll(" +", " ");
    }
    
    @Override
    public String toString() {
        return String.format("%n\tVi: %s%n\tPreu: %d%n\tEstoc: %d%n",
                         nom, preu, estoc);
    }
    
    public static Vi deArrayString(String[] introdueix){
        int preu;
        int estoc;

        // Si rep més de tres elements, mal
        if (introdueix.length != 3) { return null; }
        
        // Si el nom esta buit, etc, mal
        if (normalitzaNom(introdueix[0]).equals("nom no vàlid")) return null;
        
        // Si no son numeros, mal
        if (! UtilString.esEnter(introdueix[1]) || ! UtilString.esEnter(introdueix[2])) return null;
        
        // Passant de String to Int 
        preu = Integer.parseInt(introdueix[1]);
        estoc = Integer.parseInt(introdueix[2]);
        if (preu < 0 || estoc < 0) return null;

        // Crea el vi
        return new Vi(introdueix[0], preu, estoc);

    }

    public String[] aArrayString(){
        String[] arrayVi = new String[3];
        arrayVi[0] = getNom();
        arrayVi[1]  = Integer.toString(getPreu());
        arrayVi[2]  = Integer.toString(getEstoc());
        return arrayVi;
    }
    
}