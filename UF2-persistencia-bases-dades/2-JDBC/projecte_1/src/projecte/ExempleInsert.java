package projecte;
import java.sql.*;
   public class ExempleInsert {
       public static void main (String[] args){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/ejemplo","root","austria");
           String dep = args[0];
           String dnom = args[1];
           String loc = args[2];
           String sql = String.format("INSERT INTO depart VALUES (%s, '%s', '%s')", dep, dnom, loc);
           System.out.println(sql);
           Statement sentencia = conn.createStatement();
           int files = sentencia.executeUpdate(sql);
           System.out.printf("Files afectadas: %d %n", files);
           sentencia.close();
           conn.close();
       }
       catch (ClassNotFoundException cn) {cn.printStackTrace();}
       catch (SQLException e) {e.printStackTrace();}
   }
}
