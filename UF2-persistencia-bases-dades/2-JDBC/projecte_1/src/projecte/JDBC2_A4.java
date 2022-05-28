package projecte;
import java.sql.*;
public class JDBC2_A4 {
    public static void main (String[] args){
            try{ 
                /*4.- Realitza un programa en Java que pugi el salari als empleats d'un departament. E
                l programa rebrà el número de departament i l'increment.
                    */ 
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/ejemplo","root","root");
                String dep = args[0];
                String increment = args[1];

                String sql = String.format("UPDATE emple SET salario = salario + %s where dept_no = %s", increment, dep);
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
