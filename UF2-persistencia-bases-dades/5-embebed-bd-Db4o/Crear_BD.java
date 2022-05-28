
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
public class Crear_BD {
    static String BDEmp = "EMPLEDEP.yap";
    public static void main (String [] args) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDEmp);
        //Amb el mètode openFile() creem la base de dades “DBPersones.yap”
        //A continuació creem els objectes:

        Empleat emp1 = new Empleat("Ari", "Marketing");
        Empleat emp2 = new Empleat("Laura", "Informatica");
        Empleat emp3 = new Empleat("Miquel", "Informatica");


        Departament dept1 = new Departament(1, "Marketing");
        Departament dept2 = new Departament(2,"Informatica");

        db.store(emp1);
        db.store(emp2);
        db.store(emp3);
        db.store(dept1);
        db.store(dept2);
        
        
        //Mostrar resultats d'un mateix dept
        Empleat empleat = new Empleat (null,"Informatica"); //Els paràmetres fan referència al Nom i el Departament
        //Per recuperar objectes utilitzem el sistema de consultas QBE (Query-By-Example).
        ObjectSet<Empleat> result = db.queryByExample(empleat);
        if (result.size() == 0)
        System.out.println("No existeixen registres de persones");
        else
        System.out.printf ("Número de registres : %d %n", result.size());
        while (result.hasNext()){
            Empleat e = result.next();
            System.out.printf("Nom: %s, Departament: %s %n", e.getNom(),e.getDepartament());
        }
        
        //Tanquem la base de dades
        db.close();
    } 
}
