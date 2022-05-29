/*
 * Programa que treballa amb interficies: Garfield subclasse de Gat 
 * amb la interficie: Animal de companyia. 
 */
 

public class Garfield extends Gat implements AnimalDeCompanyia{
    
    public Garfield(){
        super("Garfield", 9);
    }
    
    public String deixatEstimar() {
         return "em deixo estimar una mica";
    }
}
