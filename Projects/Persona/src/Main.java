
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
public class Main{
   static String BDPer = "DBPersones.yap";
   public static void main (String [] args) {
       ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPer);
       //Amb el mètode openFile() creem la base de dades “DBPersones.yap”
       //A continuació creem els objectes:
       Persona p1 = new Persona ("Juan","Guadalajara");
       Persona p2 = new Persona ("Anna","Madrid");
       Persona p3 = new Persona ("Lluis","Granada");
       Persona p4 = new Persona ("Gina","Asturias");
       //Utilitzem el mètode store() per emmagatzemar els objectes
       db.store(p1);
       db.store(p2);
       db.store(p3);
       db.store(p4);
       //Tanquem la base de dades
       db.close();
   }
}
