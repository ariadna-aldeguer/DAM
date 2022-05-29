import java.sql.SQLException;

/* Class Botiga */

public class Botiga {
    private int DEFAULT_MAX_VINS;
    private Vi[] vins;
    private int numVi;
   
    public Botiga() {
        this(100);
    } 
    public Botiga(int maxVins){
        if (maxVins < 0) { maxVins = 0; }
        DEFAULT_MAX_VINS = maxVins;
        vins = new Vi[DEFAULT_MAX_VINS];
    }
    
    
    /* Afegeix vi
    * Comprova que no hi hagi vi amb el mateix nom
    * Si hi ha, no fa res (retorna null)
    * Si no hi ha, buscara entrada array = null
    * Afegira alla el vi
    * Retornara el vi introduït
    */
    public Vi afegeix(Vi vino){
        
        if(cerca(vino.getNom()) == null){
            for (int i=0; i <vins.length; i++){
                if(vins[i] == null){
                    vins[i] = vino;
                    return vins[i];
                }
            }
        }
        return null;
    }
    
    /* Busca el vi --> no: retorna null
     * sí --> posicio posara null i retorna el vi
     * si hi ha estoc, no l'elimina, retornara null */
    public Vi elimina(Vi vino){
       
        if(cerca(vino.getNom()) == null){
            return null;
        }  
        if(vino.getEstoc() > 1){
            return null;
        }
        for (int i=0; i <vins.length; i++){
            if(vins[i].equals(vino)){
                vins[i] = null;
                return vino;
            }
        }
        return null;
    }
      
    /* Si troba el vi, retorna el vi
     * Cas contrari, torna null */
    public Vi cerca(String nom){
        
        String nombre = Vi.normalitzaNom(nom);

        for(Vi vi: vins){
            if(vi != null){
                if(vi.getNom().equals(nombre)){
                    return vi;
                }
            }
        }
        return null;
    }
    
    public void iniciaRecorregut(){
        numVi = 0;
    }

    public Vi getSeguent(){
        Vi vi = vins[numVi];
        while(numVi < vins.length){  
            vi = vins[numVi];
            if (numVi == vins.length-1){
                if(vi == null){
                    return null;
                }
            }
            if (vi == null) {
                numVi++;
                continue;
            } 
            
            break;
        }
        numVi++;
        return vi;
    }

    

}