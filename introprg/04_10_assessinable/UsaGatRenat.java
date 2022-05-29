/*
 * Classe UsaGatRenat: Matem a gat Renat
 */

public class UsaGatRenat{
    public static void main(String[] args){
        
        GatRenat renat = new GatRenat();
        for (int vides = 1; vides <= 3; vides++) {
            while (renat.estaViu()) {
                System.out.println("Renat diu: " + renat.mor());
            }
            System.out.println("Renat diu: " + renat.mor());    // per rematar-ho!
            System.out.println("Renat diu: " + renat.resuscita(vides));
        }
    }   
}
