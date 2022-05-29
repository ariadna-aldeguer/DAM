
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
public class Consulta1 {
   static String BDPer = "DBPersones.yap";
   public static void main (String[] args) {
       //Obrim la base de dades
       ObjectContainer db = Db4oEmbedded.openFile (Db4oEmbedded.newConfiguration(), BDPer);
       Persona per = new Persona (null,null); //Els paràmetres fan referència al Nom i la Ciutat
       //Per recuperar objectes utilitzem el sistema de consultas QBE (Query-By-Example).
       ObjectSet<Persona> result = db.queryByExample(per);
       if (result.size() == 0)
           System.out.println("No existeixen Registres de persones");
       else
           System.out.printf ("Número de registres : %d %n", result.size());
       while (result.hasNext()){
           Persona p = result.next();
           System.out.printf("Nom: %s, Ciutat: %s %n", p.getNom(),p.getCiutat());
       }
   }
}
