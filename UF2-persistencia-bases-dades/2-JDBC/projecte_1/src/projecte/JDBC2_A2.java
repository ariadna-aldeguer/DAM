package projecte;
import java.sql.*;
import java.util.Scanner;

public class JDBC2_A2{
	
   static Scanner sc = new Scanner(System.in);
   public static void main(String[] args) {
        /*A2.- Genera un programa que retorni la clau primària de la taula departaments 
        i la clau aliena que apunta a la taula departaments. */
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo","root","root");

            DatabaseMetaData dbmd = conn.getMetaData();  
            ResultSet rs = dbmd.getPrimaryKeys(null, null, "depart");  
            ResultSet rs_em = dbmd.getImportedKeys(null, null, "emple");
           
            while (rs.next()){
                System.out.println("Columna primary key : " + rs.getString("COLUMN_NAME"));
            }
            while (rs_em.next()){
                System.out.println("Nom foreign key : " + rs_em.getString("FK_NAME"));
            }
            conn.close();

        } catch (ClassNotFoundException cn) { cn.printStackTrace();
        } catch (SQLException e) {e.printStackTrace();
        }
    } 
}

