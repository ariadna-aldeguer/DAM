package projecte;
import java.util.Date;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class JDBC2_A5 {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /*A5.- Crea un programa Java que insereixi un empleat en la taula emple, 
        el programa rebrà de l'usuari els valors a inserir. Els arguments que rep són: 
        EMP_NO, COGNOM, OFICI, DIR, SALARI, COMISIÓ, DEPT_NO. Abans d'inserir s'han de realitzar una sèrie de comprovacions:
        - Que el departament existeixi en la taula depart, si no existeix no s'insereix.
        - Que el número de l'empleat no existeixi, si existeix no s'insereix.
        - Que el salari sigui major que zero, si no ho és, no s'insereix.
        - Que el director (dir → “cap” de l'empleat) existeixi, si no existeix no s'insereix.
        - El cognom i l'ofici no poden ser nuls.
        - La data d'alta de l'empleat és la data actual.
        Quan s'insereixi la fila visualitzar un missatge que ho corrobori, i si no s'insereix visualitzar el motiu.
        */
        String[] args_1 = {"5", "ari", "null", "3", "23", "122", "20"};
        String emp_no = args_1[0];
        String cognom = args_1[1];
        String ofici = args_1[2];
        String dir = args_1[3];
        String salari = args_1[4];
        String comisio = args_1[5];
        String dept_no = args_1[6];

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String data = dateFormat.format(date);
        


        if(!departamentIsValid(dept_no)){
            System.out.println("El departament no existeix");
            return;
        }

        if(existeixNumeroEmpleat(emp_no)){
            System.out.println("El número de l'empleat existeix");
            return;
        }
        if(!salariPositiu(salari)){
            System.out.println("El salari ha de ser major que 0");
            return;
        }
        if(!existeixCap(dir)){
            System.out.println("No existeix el director");
            return;
        }
        if(ofici.toLowerCase().equals("null")){
            System.out.println("L'ofici no pot ser null");
            return;
        }
        if(cognom.toLowerCase().equals("null")){
            System.out.println("El cognom no pot ser null");
            return;
        }

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo","root","root");
        Statement stmt = conn.createStatement();
        String sql = String.format("INSERT INTO emple VALUES (%s, '%s', '%s', '%s', '%s', '%s', '%s', '%s')", emp_no, cognom, ofici, dir, data, salari, comisio, dept_no);

        int files = stmt.executeUpdate(sql);
        System.out.printf("Files afectadas: %d %n", files);
        conn.close();

    }

    private static boolean existeixCap(String dir) throws SQLException, ClassNotFoundException {
        boolean bool = true;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo","root","root");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from emple where emp_no = " + dir);
        if (rs.next() == false) bool = false;
        conn.close();
        return bool;
    }

    private static boolean salariPositiu(String salari) {
        int num = Integer.valueOf(salari);
        if(num < 0) return false;
        return true;
    }

    private static boolean existeixNumeroEmpleat(String numero) throws SQLException, ClassNotFoundException {
        boolean bool = true;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo","root","root");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from emple where emp_no = " + numero);
        
        if (rs.next() == false) bool = false;
        conn.close();
        return bool;
    }

    public static boolean departamentIsValid(String id) throws SQLException, ClassNotFoundException{
        boolean b = true;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo","root","root");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from emple where dept_no = " + id);
        
        if (rs.next() == false) b = false;
        conn.close();
        return b;

    }
}