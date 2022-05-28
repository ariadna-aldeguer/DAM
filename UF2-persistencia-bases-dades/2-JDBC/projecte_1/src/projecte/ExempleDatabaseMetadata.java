package projecte;
import java.sql.*;
public class ExempleDatabaseMetadata {
   public static void main (String [] args) {
       try
       {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/ejemplo","root","root");
           DatabaseMetaData dbmd = conn.getMetaData();
           ResultSet resul = null;
           String nom = dbmd.getDatabaseProductName();    String driver = dbmd.getDriverName();
           String url = dbmd.getURL();     String usuari = dbmd.getUserName();
           System.out.printf(" Nom: %s %n Nom driver: %s %n URL: %s %n Nom usuari: %s %n", nom, driver, url, usuari);
           resul = dbmd.getTables(null,"ejemplo",null,null);
           while (resul.next()){
               String cataleg = resul.getString(1);   String esquema = resul.getString(2);
               String taula = resul.getString(3);    String tipus = resul.getString(4);
               System.out.printf("%s - Catàleg: %s, Esquema: %s, Nom: %s %n", tipus, cataleg, esquema, taula);
           }
           conn.close();
       }
           catch (ClassNotFoundException cn) {cn.printStackTrace();}
           catch (SQLException e) {e.printStackTrace();}
   }
}
