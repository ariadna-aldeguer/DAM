package projecte;
import java.sql.*;
import java.util.Scanner;

public class JDBC2_A3{
	
   static Scanner sc = new Scanner(System.in);
   public static void main(String[] args) {
        /*A3.- Busca informació sobre la interfície ResultSetMetaData i realitza un programa utilitzant aquesta interfície 
        que obtingui el nombre de columnes i el tipus de columnes retornats per la consulta “SELECT * FROM DEPARTAMENTOS”. */
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo","root","root");

            Statement stmt = conn.createStatement();
           //Retrieving the data
            ResultSet rs = stmt.executeQuery("select * from depart");
            //Retrieving the ResultSetMetadata object
            ResultSetMetaData data = rs.getMetaData();
            System.out.println("Número de columnes: " + data.getColumnCount());
            System.out.println("Tipus de columnes: ");
           
            for(int i = 1; i <= data.getColumnCount(); i++){
                System.out.println("- "  + data.getColumnType(i));
           }
            conn.close();

        } catch (ClassNotFoundException cn) { cn.printStackTrace();
        } catch (SQLException e) {e.printStackTrace();
        }
    }
}

