
import java.util.Scanner;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class A1_Modificar{
    static String BDPer = "DBPersones.yap";
    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPer);
        
        System.out.println("Nom de la persona per modificar?");
        Scanner sc = new Scanner(System.in);
        String nom = sc.nextLine();

        System.out.println("Quina ciutat vols introduir?");
        String ciutat = sc.nextLine();

        Persona per = new Persona(nom,null); //Els paràmetres fan referència al Nom i la Ciutat
        //Per recuperar objectes utilitzem el sistema de consultas QBE (Query-By-Example).
        ObjectSet<Persona> result = db.queryByExample(per);
        if (result.size() == 0)
            System.out.println("No existeix una persona amb aquest nom");
        else
            System.out.printf ("Número de registres modificats : %d %n", result.size());
        while (result.hasNext()){
            Persona p = result.next();
            p.setCiutat(ciutat);
            db.store(p);
        }


        // Mostra els resultats
        Persona query = new Persona (null,null); //Els paràmetres fan referència al Nom i la Ciutat
       //Per recuperar objectes utilitzem el sistema de consultas QBE (Query-By-Example).
        ObjectSet<Persona> show = db.queryByExample(query);
        while (show.hasNext()){
            Persona resultat = show.next();
            if(resultat.getNom().equals(nom)){
                System.out.printf("Nom: %s, Ciutat: %s *MODIFICAT%n", resultat.getNom(),resultat.getCiutat());
            } else {
                System.out.printf("Nom: %s, Ciutat: %s %n", resultat.getNom(),resultat.getCiutat());
            }
        }

        db.close();
        sc.close();

    }
}