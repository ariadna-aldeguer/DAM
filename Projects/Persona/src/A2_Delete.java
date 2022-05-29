import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
public class A2_Delete{
    static String BDPer = "DBPersones.yap";
    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile (Db4oEmbedded.newConfiguration(), BDPer);
        Persona per = new Persona ("Juan",null); //Els paràmetres fan referència al Nom i la Ciutat
        //Per recuperar objectes utilitzem el sistema de consultas QBE (Query-By-Example).
        ObjectSet<Persona> result = db.queryByExample(per);
        if (result.size() == 0){
            System.out.println("No existeixen Registres de persones");
        } else {
            System.out.printf ("Número de registres borrats : %d %n", result.size());
            while (result.hasNext()){
                Persona p = result.next();
                db.delete(p);
            }
        }

        // Mostra els resultats
        Persona query = new Persona (null,null); //Els paràmetres fan referència al Nom i la Ciutat
        //Per recuperar objectes utilitzem el sistema de consultas QBE (Query-By-Example).
         ObjectSet<Persona> show = db.queryByExample(query);
         while (show.hasNext()){
             Persona resultat = show.next();
             System.out.printf("Nom: %s, Ciutat: %s %n", resultat.getNom(),resultat.getCiutat());
         }
 
         db.close();
    }
}