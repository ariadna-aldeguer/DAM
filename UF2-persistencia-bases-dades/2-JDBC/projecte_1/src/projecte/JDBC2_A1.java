package projecte;
import java.sql.*;
import java.util.Scanner;

public class JDBC2_A1{
	
   static Scanner sc = new Scanner(System.in);
   public static void main(String[] args) {
	   
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo","root","root");

           Statement stmt = conn.createStatement();
           //Retrieving the data
           ResultSet rs = stmt.executeQuery("select * from depart");
           //Retrieving the ResultSetMetadata object
           ResultSetMetaData data = rs.getMetaData();
           int count = data.getColumnCount();

           for(int i = 1; i <= count; i++){
                System.out.printf("(%d)Nom de la columna: %s%n" + 
                "(%d)Tipus de columna: %s%n" + 
                "(%d)Grandaria: %d%n" + 
                "(%d)Nulabilitat: %b%n", i, data.getColumnName(i), i, data.getColumnType(i), i, data.getColumnDisplaySize(i), i, data.isNullable(i));
           }
           System.out.println();
           conn.close();

       } catch (ClassNotFoundException cn) { cn.printStackTrace();
       } catch (SQLException e) {e.printStackTrace();
       }
   }
}

